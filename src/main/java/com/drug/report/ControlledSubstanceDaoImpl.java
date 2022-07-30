package com.drug.report;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class ControlledSubstanceDaoImpl implements ControlledSubsatanceDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	ControlledSubstanceService controlledSubstanceService;
	
     //Search
	
	@Override
	public SearchResultBean getSearchList(SearchBean bean) throws Exception {
		
		SearchResultBean resultBean = new SearchResultBean();
 		try {
 			
 			
 			if(bean.getStartDate()!=""&&bean.getEndDate()!="") {
 		String[] startdt = bean.getStartDate().split("T");
 		String startdate = startdt[0];
 		String[] enddt = bean.getEndDate().split("T");
 		String enddate = enddt[0];
 		
 		
 		SimpleDateFormat fromdatt = new SimpleDateFormat("yyyy-mm-dd");
 		SimpleDateFormat fromdt = new SimpleDateFormat("dd/mm/yyyy");
			String startdate1 = fromdt.format(fromdatt.parse(startdate));
			String enddate1 = fromdt.format(fromdatt.parse(enddate));
			bean.setStartDate((startdate1).toString());
			bean.setEndDate((enddate1).toString());
 			}

List<SearchBean> searchBean = jdbcTemplate.query(ControlledSubstanceQueryUtil.getReturnSearchList(bean.getCompany(),bean.getReturnMemoNo(),bean.getStartDate(),bean.getEndDate()), new BeanPropertyRowMapper<SearchBean>(SearchBean.class));
resultBean.setListSearchBean(searchBean);

		    resultBean.setSuccess(true);
		  //  System.out.print(result);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		
		return resultBean;
	}

	//Returnable
	
		@Override
		public ReturnableResultBean getReturnSearchList(ReturableSearchBean bean) throws Exception {
			
			ReturnableResultBean resultBean = new ReturnableResultBean();
	 		try {
	 			
	 			
	 			if(bean.getStartDate()!=""&&bean.getEndDate()!="") {
	 		String[] startdt = bean.getStartDate().split("T");
	 		String startdate = startdt[0];
	 		String[] enddt = bean.getEndDate().split("T");
	 		String enddate = enddt[0];
	 		
	 		
	 		SimpleDateFormat fromdatt = new SimpleDateFormat("yyyy-mm-dd");
	 		SimpleDateFormat fromdt = new SimpleDateFormat("dd/mm/yyyy");
				String startdate1 = fromdt.format(fromdatt.parse(startdate));
				String enddate1 = fromdt.format(fromdatt.parse(enddate));
				bean.setStartDate((startdate1).toString());
				bean.setEndDate((enddate1).toString());
	 			}

	    List<ReturableSearchBean> returableSearchBean = jdbcTemplate.query(ControlledSubstanceQueryUtil.getReturnSearchList(bean.getCompany(),bean.getReturnMemoNo(),bean.getStartDate(),bean.getEndDate()), new BeanPropertyRowMapper<ReturableSearchBean>(
	    		ReturableSearchBean.class));
	    resultBean.setReturnableSearchBean(returableSearchBean);
			    resultBean.setSuccess(true);
			  //  System.out.print(result);
			}catch(Exception e) {
				e.printStackTrace();
				resultBean.setSuccess(false);
			}
			
			return resultBean;
		}

		
	//NonReturnable
	
	@Override
	public NonReturableSearchResultBean getNonReturnSearchList(NonReturnableSearchBean bean) throws Exception {
		
		NonReturableSearchResultBean resultBean = new NonReturableSearchResultBean();
 		try {
 			
 			
 			if(bean.getStartDate()!=""&&bean.getEndDate()!="") {
 		String[] startdt = bean.getStartDate().split("T");
 		String startdate = startdt[0];
 		String[] enddt = bean.getEndDate().split("T");
 		String enddate = enddt[0];
 		
 		
 		SimpleDateFormat fromdatt = new SimpleDateFormat("yyyy-mm-dd");
 		SimpleDateFormat fromdt = new SimpleDateFormat("dd/mm/yyyy");
			String startdate1 = fromdt.format(fromdatt.parse(startdate));
			String enddate1 = fromdt.format(fromdatt.parse(enddate));
			bean.setStartDate((startdate1).toString());
			bean.setEndDate((enddate1).toString());
 			}

    List<NonReturnableSearchBean> nonReturnableSearchBean = jdbcTemplate.query(ControlledSubstanceQueryUtil.getNonReturnSearchList(bean.getCompany(),bean.getReturnMemoNo(),bean.getStartDate(),bean.getEndDate()), new BeanPropertyRowMapper<NonReturnableSearchBean>(
		NonReturnableSearchBean.class));
    resultBean.setNonListSearchBean(nonReturnableSearchBean);
		    resultBean.setSuccess(true);
		  //  System.out.print(result);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		
		return resultBean;
	}

	//SchedulaII
	
	@Override
	public ReportSearchResultBean getReportII(ReportSearchBean bean) throws Exception {
		
		ReportSearchResultBean resultBean = new ReportSearchResultBean();
 		try {
 			
 			
 			if(bean.getStartDate()!=""&&bean.getEndDate()!="") {
 		String[] startdt = bean.getStartDate().split("T");
 		String startdate = startdt[0];
 		String[] enddt = bean.getEndDate().split("T");
 		String enddate = enddt[0];
 		
 		
 		SimpleDateFormat fromdatt = new SimpleDateFormat("yyyy-mm-dd");
 		SimpleDateFormat fromdt = new SimpleDateFormat("dd/mm/yyyy");
			String startdate1 = fromdt.format(fromdatt.parse(startdate));
			String enddate1 = fromdt.format(fromdatt.parse(enddate));
			bean.setStartDate((startdate1).toString());
			bean.setEndDate((enddate1).toString());
 			}

List<ReportSearchBean> reportSearchBean = jdbcTemplate.query(ControlledSubstanceQueryUtil.getReportII(bean.getCompany(),bean.getReturnMemoNo(),bean.getStartDate(),bean.getEndDate()), new BeanPropertyRowMapper<ReportSearchBean>(
		ReportSearchBean.class));
resultBean.setReportSearchList(reportSearchBean);
		    resultBean.setSuccess(true);
		  //  System.out.print(result);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		
		return resultBean;
	}
	
	
	//ScheduleIII_V
	
	@Override
	public ReportSearchResultBean getReportIII_V(ReportSearchBean bean) throws Exception {
		
		ReportSearchResultBean resultBean = new ReportSearchResultBean();
 		try {
 			
 			
 			if(bean.getStartDate()!=""&&bean.getEndDate()!="") {
 		String[] startdt = bean.getStartDate().split("T");
 		String startdate = startdt[0];
 		String[] enddt = bean.getEndDate().split("T");
 		String enddate = enddt[0];
 		
 		
 		SimpleDateFormat fromdatt = new SimpleDateFormat("yyyy-mm-dd");
 		SimpleDateFormat fromdt = new SimpleDateFormat("dd/mm/yyyy");
			String startdate1 = fromdt.format(fromdatt.parse(startdate));
			String enddate1 = fromdt.format(fromdatt.parse(enddate));
			bean.setStartDate((startdate1).toString());
			bean.setEndDate((enddate1).toString());
 			}

List<ReportSearchBean> reportSearchBean = jdbcTemplate.query(ControlledSubstanceQueryUtil.getReportIII_V(bean.getCompany(),bean.getReturnMemoNo(),bean.getStartDate(),bean.getEndDate()), new BeanPropertyRowMapper<ReportSearchBean>(
		ReportSearchBean.class));
resultBean.setReportSearchList(reportSearchBean);
		    resultBean.setSuccess(true);
		  //  System.out.print(result);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		
		return resultBean;
	}
	
	
	//Inventory
		
		@Override
		public ReportSearchResultBean getInventory(ReportSearchBean bean) throws Exception {
			
			ReportSearchResultBean resultBean = new ReportSearchResultBean();
	 		try {
	 			
	 			
	 			if(bean.getStartDate()!=""&&bean.getEndDate()!="") {
	 		String[] startdt = bean.getStartDate().split("T");
	 		String startdate = startdt[0];
	 		String[] enddt = bean.getEndDate().split("T");
	 		String enddate = enddt[0];
	 		
	 		
	 		SimpleDateFormat fromdatt = new SimpleDateFormat("yyyy-mm-dd");
	 		SimpleDateFormat fromdt = new SimpleDateFormat("dd/mm/yyyy");
				String startdate1 = fromdt.format(fromdatt.parse(startdate));
				String enddate1 = fromdt.format(fromdatt.parse(enddate));
				bean.setStartDate((startdate1).toString());
				bean.setEndDate((enddate1).toString());
	 			}

	List<ReportSearchBean> reportSearchBean = jdbcTemplate.query(ControlledSubstanceQueryUtil.getInventory(bean.getCompany(),bean.getReturnMemoNo(),bean.getStartDate(),bean.getEndDate()), new BeanPropertyRowMapper<ReportSearchBean>(
			ReportSearchBean.class));
	resultBean.setReportSearchList(reportSearchBean);
			    resultBean.setSuccess(true);
			  //  System.out.print(result);
			}catch(Exception e) {
				e.printStackTrace();
				resultBean.setSuccess(false);
			}
			
			return resultBean;
		}
		
		
//		@PostMapping(value = "/getAntiRaggingPDF")
//		public ResponseEntity<?>  studentsListExportPDfClar(@RequestBody AntiRaggingSearchCriteria antiRaggingCriteria, HttpServletResponse response) {
//			//BasicResultBean basicResultBean=new BasicResultBean();
//			//List<HashMap<String, Object>> list;
//			//String fileName = "AntiRaggingList";
//			try {		
//				List<AntiRagging> list =antiRaggingService.GetAntiRaggingListExportPdf(antiRaggingCriteria);
//				String heading="Anti Ragging Report";
//					
//				if (antiRaggingCriteria.getPeriod() != null && antiRaggingCriteria.getPeriod().trim() != ""
//						&& !antiRaggingCriteria.getPeriod().equalsIgnoreCase("undefined")
//						&& !antiRaggingCriteria.getPeriod().equalsIgnoreCase("")) {
//					if(antiRaggingCriteria.getPeriod().equals("By 30th Apr"))
//						heading+="-April ";				
//					else
//						heading+=" -October ";
//				}	
//				if (antiRaggingCriteria.getYear()>0) {
//					heading+=antiRaggingCriteria.getYear(); 
//				}
//				else
//				{
//					Calendar cal = Calendar.getInstance();
//					heading+=cal.get(Calendar.YEAR);
//				}
//				 ByteArrayInputStream bis = antiRaggingReport(list,heading);
//
//				 HttpHeaders headers = new HttpHeaders();
//			        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");
//
//			        return ResponseEntity
//			                .ok()
//			                .headers(headers)
//			                //.contentType(MediaType.APPLICATION_BINARY)
//			                .body(new InputStreamResource(bis));
//				//String generatedFileName = documentGenerator.reportDocumentGenerator(list, fileName, docPath);
//			//	generatedFileName = documentGenerator.convertExcelltoPdf(generatedFileName, docPath);
////				documentGenerator.downloadReports(response, generatedFileName, fileName + Constants.pdf, docPath);
//				//basicResultBean.setMessage(generatedFileName);
////				Resource file = antiRaggingService.load(docPath+generatedFileName);
////			    return ResponseEntity.ok()
////			        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
//			} catch (Exception e) {
//				log.error(e.getMessage());
//				e.printStackTrace();
//				return new ResponseEntity<String>(Responses.FAILED + e.getMessage(), HttpStatus.EXPECTATION_FAILED);
//				
//			}
//		}
		
		
		//PackingSlip
		
				
				@Override
				public ReportSearchResultBean getPackingSlip(ReportSearchBean bean) throws Exception {
					
					ReportSearchResultBean resultBean = new ReportSearchResultBean();
			 		try {
			 			
			 			
			 			if(bean.getStartDate()!=""&&bean.getEndDate()!="") {
			 		String[] startdt = bean.getStartDate().split("T");
			 		String startdate = startdt[0];
			 		String[] enddt = bean.getEndDate().split("T");
			 		String enddate = enddt[0];
			 		
			 		
			 		SimpleDateFormat fromdatt = new SimpleDateFormat("yyyy-mm-dd");
			 		SimpleDateFormat fromdt = new SimpleDateFormat("dd/mm/yyyy");
						String startdate1 = fromdt.format(fromdatt.parse(startdate));
						String enddate1 = fromdt.format(fromdatt.parse(enddate));
						bean.setStartDate((startdate1).toString());
						bean.setEndDate((enddate1).toString());
			 			}

			List<ReportSearchBean> reportSearchBean = jdbcTemplate.query(ControlledSubstanceQueryUtil.getPackingSlip(bean.getCompany(),bean.getReturnMemoNo(),bean.getStartDate(),bean.getEndDate()), new BeanPropertyRowMapper<ReportSearchBean>(
					ReportSearchBean.class));
			resultBean.setReportSearchList(reportSearchBean);
					    resultBean.setSuccess(true);
					  //  System.out.print(result);
					}catch(Exception e) {
						e.printStackTrace();
						resultBean.setSuccess(false);
					}
					
					return resultBean;
				}

				
				//Manufacturer
				
				@Override
				public List<ManufacturerBean> getManufacturerAddress(String manufacturercode) {
					List<ManufacturerBean> manufacturerBean = new ArrayList<ManufacturerBean>();
					try {
						 manufacturerBean= jdbcTemplate.query(ControlledSubstanceQueryUtil.getManufacturerAddress(manufacturercode), new BeanPropertyRowMapper<ManufacturerBean>(ManufacturerBean.class));	
					}catch(Exception e){
						e.printStackTrace();
					}
					return manufacturerBean;
				}
				
				
				//
				
				@Override
				public List<CompanyBean> getCompanyAddress(String companyId) {
					List<CompanyBean> companyBean = new ArrayList<CompanyBean>();
					try {
						companyBean = jdbcTemplate.query(ControlledSubstanceQueryUtil.COMPANY_MASTER(companyId), new BeanPropertyRowMapper<CompanyBean>(CompanyBean.class));	
					}catch(Exception e){
						e.printStackTrace();
					}
					return companyBean;
				}

				
				
			
}
