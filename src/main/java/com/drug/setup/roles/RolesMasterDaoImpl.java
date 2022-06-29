package com.drug.setup.roles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RolesMasterDaoImpl implements RolesMasterDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public RolesMasterResultBean save(RolesMasterBean bean) throws Exception {
		RolesMasterResultBean resultBean = new RolesMasterResultBean();
		try {
			Map<String, Object> saveMap = new HashMap<String, Object>();
			saveMap.put("roleName", bean.getRoleName());
			saveMap.put("remarks", bean.getRemarks());
			
			namedParameterJdbcTemplate.update(RolesMasterQueryUtil.INSERT,saveMap);
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		
		return resultBean;
	}

	@Override
	public List<RolesMasterBean> getList() throws Exception {
		List<RolesMasterBean> objCustomerMasterBean = new ArrayList<RolesMasterBean>();
		try {
			objCustomerMasterBean = jdbcTemplate.query(RolesMasterQueryUtil.getList, new BeanPropertyRowMapper<RolesMasterBean>(RolesMasterBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return objCustomerMasterBean;
	}

	@Override
	public RolesMasterResultBean edit(Integer code) throws Exception {
		RolesMasterResultBean resultBean = new RolesMasterResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setRolesMasterBean(jdbcTemplate.queryForObject(RolesMasterQueryUtil.SELECT_DTL,new Object[] { code }, new BeanPropertyRowMapper<RolesMasterBean>(RolesMasterBean.class)));
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public RolesMasterResultBean delete(Integer cusCode) throws Exception {
		RolesMasterResultBean resultBean = new RolesMasterResultBean();
		try {
			if(cusCode!=null) {
				jdbcTemplate.update(RolesMasterQueryUtil.DELETE,cusCode);
			}
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public RolesMasterResultBean update(RolesMasterBean bean) throws Exception {
		RolesMasterResultBean resultBean = new RolesMasterResultBean();
		try {
			Map<String, Object> customerMasterMap = new HashMap<String, Object>();
			    
				namedParameterJdbcTemplate.update(RolesMasterQueryUtil.UPDATE_CUSTOMER_MASTER,customerMasterMap);
			   resultBean.setSuccess(true);
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean;
	}


}
