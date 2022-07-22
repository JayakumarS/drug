package com.drug.report;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.drug.core.util.DropDownList;
import com.drug.druginfoMaster.DruginfoMasterBean;
import com.drug.druginfoMaster.DruginfoMasterQueryUtil;
import com.drug.druginfoMaster.DruginfoMasterResultBean;
import com.drug.setup.users.UsersMasterQueryUtil;
import com.drug.setup.users.UsersMasterResultBean;

@Repository
public class ControlledSubstanceDaoImpl implements ControlledSubsatanceDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
//	@Override
//	public List<ControlledSubstanceResultBean> getCompanyNameList() throws Exception {
//		List<ControlledSubstanceResultBean> objControlledSubstanceResultBean = new ArrayList<ControlledSubstanceResultBean>();
//		try {
//			objControlledSubstanceResultBean = jdbcTemplate.query(ControlledSubstanceQueryUtil.getCompanyNameList, new BeanPropertyRowMapper<ControlledSubstanceResultBean>(ControlledSubstanceResultBean.class));
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return objControlledSubstanceResultBean;
//		
//	}
	
	
//	@Override
//	public List<ControlledSubstanceResultBean> getReturnMemoNo() throws Exception {
//		List<ControlledSubstanceResultBean> objControlledSubstanceResultBean = new ArrayList<ControlledSubstanceResultBean>();
//		try {
//			objControlledSubstanceResultBean = jdbcTemplate.query(ControlledSubstanceQueryUtil.getReturnMemoNo, new BeanPropertyRowMapper<ControlledSubstanceResultBean>(ControlledSubstanceResultBean.class));
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return objControlledSubstanceResultBean;
//		
//	}
//	

	
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

List<SearchBean> searchBean = jdbcTemplate.query(ControlledSubstanceQueryUtil.getSearchList(bean.getCompany(),bean.getReturnMemoNo(),bean.getStartDate(),bean.getEndDate()), new BeanPropertyRowMapper<SearchBean>(
					SearchBean.class));
resultBean.setListSearchBean(searchBean);
		    resultBean.setSuccess(true);
		  //  System.out.print(result);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		
		return resultBean;
	}

	
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

}
