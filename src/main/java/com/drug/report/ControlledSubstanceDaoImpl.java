package com.drug.report;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.drug.core.util.DropDownList;
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


}
