package com.drug.report;

import java.io.StringWriter;
import java.util.List;
import java.util.Properties;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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
				context.put("returnMemoName",list.get(0).getReturnMemoName());
				context.put("companyName",list.get(0).getCompanyName());
				context.put("returnMemoNo", list.get(0).getReturnMemoNo());
				context.put("createdDate", list.get(0).getReturnMemoDate());

				
				org.apache.velocity.Template t = ve.getTemplate("templates/Report.vm", "UTF-8");
				StringWriter writer = new StringWriter();
				t.merge(context, writer); 
				bean.setExportPDF(writer.toString());
				return bean;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;

		}
	
}

