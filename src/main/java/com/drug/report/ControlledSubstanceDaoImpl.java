package com.drug.report;

import java.util.ArrayList;
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
	
	
	@Override
	public List<ControlledSubstanceResultBean> getCompanyNameList() throws Exception {
		List<ControlledSubstanceResultBean> objControlledSubstanceResultBean = new ArrayList<ControlledSubstanceResultBean>();
		try {
			objControlledSubstanceResultBean = jdbcTemplate.query(ControlledSubstanceQueryUtil.getCompanyNameList, new BeanPropertyRowMapper<ControlledSubstanceResultBean>(ControlledSubstanceResultBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return objControlledSubstanceResultBean;
		
	}
	
	
	@Override
	public List<ControlledSubstanceResultBean> getReturnMemoNo() throws Exception {
		List<ControlledSubstanceResultBean> objControlledSubstanceResultBean = new ArrayList<ControlledSubstanceResultBean>();
		try {
			objControlledSubstanceResultBean = jdbcTemplate.query(ControlledSubstanceQueryUtil.getReturnMemoNo, new BeanPropertyRowMapper<ControlledSubstanceResultBean>(ControlledSubstanceResultBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return objControlledSubstanceResultBean;
		
	}
	
//	@Override
//	public List<SearchBean> getSearchList() throws Exception {
//		List<SearchBean> objSearchBean = new ArrayList<SearchBean>();
//		try {
//			objSearchBean = jdbcTemplate.query(ControlledSubstanceQueryUtil.getSearchList, new BeanPropertyRowMapper<SearchBean>(SearchBean.class));
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return objSearchBean;
//		
//	}

	
	@Override
	public SearchResultBean getSearchList(SearchBean bean) throws Exception {
		
		SearchResultBean resultBean = new SearchResultBean();
 		try {
 		
List<SearchBean> searchBean = jdbcTemplate.query(ControlledSubstanceQueryUtil.getSearchList, new Object[] { bean.getCompanyName(),
			bean.getReturnMemoNo(),
			bean.getStartDate(),
			bean.getEndDate()}, new BeanPropertyRowMapper<>(
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


}
