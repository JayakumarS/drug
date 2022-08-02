package com.drug.report;

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

 			List<SearchBean> searchBean = jdbcTemplate.query(ControlledSubstanceQueryUtil.getSearchList(bean.getReportType(),bean.getCompany(),bean.getReturnMemoNo(),bean.getStartDate(),bean.getEndDate()), new BeanPropertyRowMapper<SearchBean>(SearchBean.class));
            resultBean.setListSearchBean(searchBean);
	
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
