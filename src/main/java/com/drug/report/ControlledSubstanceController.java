package com.drug.report;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.attach.ITagWorker;
import com.itextpdf.html2pdf.attach.ProcessorContext;
import com.itextpdf.html2pdf.css.apply.ICssApplier;
import com.itextpdf.html2pdf.css.apply.ICssApplierFactory;
import com.itextpdf.html2pdf.css.apply.impl.BlockCssApplier;
import com.itextpdf.html2pdf.css.apply.impl.DefaultCssApplierFactory;
import com.itextpdf.html2pdf.html.TagConstants;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.styledxmlparser.node.IElementNode;
import com.itextpdf.styledxmlparser.node.IStylesContainer;
import java.io.OutputStream;
import java.net.URLEncoder;

@RestController
@RequestMapping("/api/auth/app/report")

public class ControlledSubstanceController {
	
	@Autowired
	ControlledSubstanceService controlledSubstanceService;
	
	
	//Search
	
	@RequestMapping(value="/getSearchList")
	public SearchResultBean getSearchList(@RequestBody SearchBean bean) {
		SearchResultBean objbean = new SearchResultBean();
		try {
			objbean = controlledSubstanceService.getSearchList(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	//Returnable 
		
	@RequestMapping(value="/getReturnSearchList")
	public ReturnableResultBean getReturnSearchList(@RequestBody ReturableSearchBean bean) {
		ReturnableResultBean objbean = new ReturnableResultBean();
		try {
			objbean = controlledSubstanceService.getReturnSearchList(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
 
	
	
	//NonReturnable 
	
	@RequestMapping(value="/getNonReturnSearchList")
	public NonReturableSearchResultBean getNonReturnSearchList(@RequestBody NonReturnableSearchBean bean) {
		NonReturableSearchResultBean objbean = new NonReturableSearchResultBean();
		try {
			objbean = controlledSubstanceService.getNonReturnSearchList(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	//ScheduleII
	
	@RequestMapping(value="/getReportII")
	public ReportSearchResultBean getReportII(@RequestBody ReportSearchBean bean) {
		ReportSearchResultBean objbean = new ReportSearchResultBean();
		try {
			objbean = controlledSubstanceService.getReportII(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	
	//ScheduleIII_V

	
	@RequestMapping(value="/getReportIII_V")
	public ReportSearchResultBean getReportIII_V(@RequestBody ReportSearchBean bean) {
		ReportSearchResultBean objbean = new ReportSearchResultBean();
		try {
			objbean = controlledSubstanceService.getReportIII_V(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	
	//Inventory
	
	
	@RequestMapping(value="/getInventory")
	public ReportSearchResultBean getInventory(@RequestBody ReportSearchBean bean) {
		ReportSearchResultBean objbean = new ReportSearchResultBean();
		try {
			objbean = controlledSubstanceService.getInventory(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	
	//Packing Slip
	
	@RequestMapping(value="/getPackingSlip")
	public ReportSearchResultBean getPackingSlip(@RequestBody ReportSearchBean bean) {
		ReportSearchResultBean objbean = new ReportSearchResultBean();
		try {
			objbean = controlledSubstanceService.getPackingSlip(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	
	//ManufacturerAddress
	
	@RequestMapping(value= "/getManufacturerAddress")
	public List<ManufacturerBean> getManufacturerAddress(@RequestParam("manufacturercode") String manufacturercode){
			return controlledSubstanceService.getManufacturerAddress(manufacturercode);	
	}
	
	
	//companyAddress
	
	
	@RequestMapping(value= "/getCompanyAddress")
	public List<CompanyBean> getCompanyAddress(@RequestParam("companyId") String companyId){
			return controlledSubstanceService.getCompanyAddress(companyId);	
	}
	
	
	//ExportPDF
	@GetMapping(value = "/getExportPDF")
	public void finalPreviewMOMPDF(@RequestParam String companyId, HttpServletResponse response) {
		try {
			SearchBean beanss=new SearchBean();
			beanss.setCompany("C036");
			beanss.setReturnMemoNo("ADRE01");
					
			SearchResultBean objbean = controlledSubstanceService.getSearchList(beanss);
			InputStream inputStream = velocityTempToPdf(objbean.getListSearchBean());
			
			
			response.setHeader("Content-Disposition",
					"attachment; filename=\"" + URLEncoder.encode("Minutes-" + new Date().getTime()+".pdf", "UTF-8") + '"');
			response.setHeader("Content-Transfer-Encoding", "binary");
			response.setContentType("application/pdf");
			OutputStream outStream = response.getOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead = -1;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}
			outStream.flush();
			outStream.close();
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	//ExportPDF
		@RequestMapping(value = "/getExportString")
		public SearchBean finalPreviewMOMPDF(@RequestBody SearchBean searchBean) {
			try {
				SearchBean bean = new SearchBean();
				SearchResultBean objbean = controlledSubstanceService.getSearchList(searchBean);
				List<SearchBean> list = objbean.getListSearchBean();
				VelocityEngine ve = new VelocityEngine();
				Properties p = new Properties();
				p.setProperty("resource.loader", "class");
				p.setProperty("class.resource.loader.class",
						"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
				p.setProperty("velocity.engine.resource.manager.cache.enabled", "true");
				ve.init(p);
				
				VelocityContext context = new VelocityContext();
				context.put("listSearchBean", list);
				context.put("searchBean", list);

				org.apache.velocity.Template t = ve.getTemplate("templates/ScheduleIIReport.vm", "UTF-8");
				StringWriter writer = new StringWriter();
				t.merge(context, writer); 
				bean.setExportPDF(writer.toString());
				return bean;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;

		}
	
//	@RequestMapping(value = "/getExportPDF")
//	public ResponseEntity<?>  getExportPDF(@RequestBody SearchBean bean) {
//		try { 
//			SearchResultBean objbean = controlledSubstanceService.getSearchList(bean);
//			InputStream bis = velocityTempToPdf(objbean.getListSearchBean());
//			 
//			 HttpHeaders headers = new HttpHeaders();
//		        headers.add("Content-Disposition", "attachment; filename=StudentList.pdf");
//
//		        return ResponseEntity
//		                .ok()
//		                .headers(headers) 
//		                .body(new InputStreamResource(bis));
//		        
//		}catch(Exception e){
//			e.printStackTrace();
//			return new ResponseEntity<String>( e.getMessage(), HttpStatus.EXPECTATION_FAILED);
//		} 
//	}
	
	
	
	private InputStream velocityTempToPdf(List<SearchBean> list) throws Exception{
		VelocityEngine ve = new VelocityEngine();
		Properties p = new Properties();
		p.setProperty("resource.loader", "class");
		p.setProperty("class.resource.loader.class",
				"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		p.setProperty("velocity.engine.resource.manager.cache.enabled", "true");
		ve.init(p);
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		VelocityContext context = new VelocityContext();
		context.put("listSearchBean", list);
		context.put("searchBean", list);

		org.apache.velocity.Template t = ve.getTemplate("templates/ScheduleIIReport.vm", "UTF-8");
		StringWriter writer = new StringWriter();
		t.merge(context, writer); 
//		ConverterProperties cp = new ConverterProperties(); 
//
//		cp.setCharset("utf-8");
//		
//		  ByteArrayOutputStream out = new ByteArrayOutputStream(); 
//			PdfWriter pdfwriter = new PdfWriter(out);
//			PdfDocument pdf = new PdfDocument(pdfwriter);
//
//			pdf.setDefaultPageSize(PageSize.A3);
//			HtmlConverter.convertToPdf(writer.toString(), pdf, cp);
			String s = htmlToPdf(writer.toString(), "report.pdf");
			return new FileInputStream(new File(s));
	}

	private String htmlToPdf(String content, String fileName) {
		DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
		ConverterProperties cp = new ConverterProperties();
		String file = "D:\\Softwares\\" + fileName + df.format(new Date()) + ".Pdf";
				
		try {
			final ICssApplier customImageCssApplier = new BlockCssApplier() {
				@Override
				public void apply(ProcessorContext context, IStylesContainer stylesContainer, ITagWorker tagWorker) {
					super.apply(context, stylesContainer, tagWorker);
					if (tagWorker.getElementResult() instanceof Image) {
						Image img = (Image) tagWorker.getElementResult();
						if (img.getImageWidth() > 500) {
							img.setWidth(UnitValue.createPercentValue(100));
						}
					}
				}
			};
			ICssApplierFactory cssApplierFactory = new DefaultCssApplierFactory() {
				@Override
				public ICssApplier getCustomCssApplier(IElementNode tag) {
					if (TagConstants.IMG.equals(tag.name())) {
						return customImageCssApplier;
					}
					return super.getCustomCssApplier(tag);
				}
			};
			DefaultFontProvider dfp = new DefaultFontProvider();
			cp.setFontProvider(dfp);
			cp.setCssApplierFactory(cssApplierFactory);
			cp.setCharset("utf-8");
//			PdfWriter writer = new PdfWriter(file);
//			PdfDocument pdf = new PdfDocument(writer);
//			pdf.setDefaultPageSize(PageSize.A4);
//			HtmlConverter.convertToPdf(content, pdf, cp);
			HtmlConverter.convertToPdf(content, new FileOutputStream(file),cp);
			return file;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}


}

