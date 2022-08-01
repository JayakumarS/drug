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

import com.drug.core.util.DropDownList;
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
		@RequestMapping(value = "/getExportString")
		public SearchBean finalPreviewMOMPDF(@RequestBody SearchBean searchBean, CompanyBean companyBean) {
			try {
				SearchBean bean = new SearchBean();
				CompanyBean beanN = new CompanyBean();
//				CompanyBean objbeanN =controlledSubstanceService.getCompanyAddress();
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
				
				context.put("companyName",list.get(0).getCompanyName());
				context.put("returnMemoNo", list.get(0).getReturnMemoNo());
				context.put("createdDate", list.get(0).getReturnMemoDate());

				
				org.apache.velocity.Template t = ve.getTemplate("templates/InventoryReport.vm", "UTF-8");
				StringWriter writer = new StringWriter();
				t.merge(context, writer); 
				bean.setExportPDF(writer.toString());
				return bean;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;

		}
	



		
		

//				@RequestMapping(value = "/getExportString")
//				public ReturableSearchBean finalPreviewMOMPDF(@RequestBody ReturableSearchBean returableSearchBean) {
//					try {
//						ReturableSearchBean bean = new ReturableSearchBean();
////						CompanyBean objbeanN =controlledSubstanceService.getCompanyAddress();
//						ReturnableResultBean objbean = controlledSubstanceService.getReturnSearchList(returableSearchBean);
//						List<ReturableSearchBean> list = objbean.getReturnableSearchBean();
//						VelocityEngine ve = new VelocityEngine();
//						Properties p = new Properties();
//						p.setProperty("resource.loader", "class");
//						p.setProperty("class.resource.loader.class",
//								"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
//						p.setProperty("velocity.engine.resource.manager.cache.enabled", "true");
//						ve.init(p);
//						
//						VelocityContext context = new VelocityContext();
//						context.put("listSearchBean", list);
//						
//						context.put("companyName",list.get(0).getCompanyName());
//						context.put("returnMemoNo", list.get(0).getReturnMemoNo());
//						context.put("createdDate", list.get(0).getReturnMemoDate());
//
//						
//						org.apache.velocity.Template t = ve.getTemplate("templates/InventoryReport.vm", "UTF-8");
//						StringWriter writer = new StringWriter();
//						t.merge(context, writer); 
//						bean.setExportPDF(writer.toString());
//						return bean;
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//					return null;
//
//				}
}

