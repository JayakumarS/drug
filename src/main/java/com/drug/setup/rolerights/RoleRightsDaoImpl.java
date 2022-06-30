package com.drug.setup.rolerights;

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
public class RoleRightsDaoImpl implements RoleRightsDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public RoleRightsResultBean save(RoleRightsBean bean) throws Exception {
		RoleRightsResultBean resultBean = new RoleRightsResultBean();
		try {
			Map<String, Object> saveMap = new HashMap<String, Object>();
			saveMap.put("roleName", bean.getRoleName());
			saveMap.put("remarks", bean.getRemarks());
			
			namedParameterJdbcTemplate.update(RoleRightsQueryUtil.INSERT,saveMap);
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		
		return resultBean;
	}

	@Override
	public List<RoleRightsBean> getList() throws Exception {
		List<RoleRightsBean> objCustomerMasterBean = new ArrayList<RoleRightsBean>();
		try {
			objCustomerMasterBean = jdbcTemplate.query(RoleRightsQueryUtil.getList, new BeanPropertyRowMapper<RoleRightsBean>(RoleRightsBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return objCustomerMasterBean;
	}

	@Override
	public RoleRightsResultBean edit(Integer code) throws Exception {
		RoleRightsResultBean resultBean = new RoleRightsResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setRolesMasterBean(jdbcTemplate.queryForObject(RoleRightsQueryUtil.SELECT_DTL,new Object[] { code }, new BeanPropertyRowMapper<RoleRightsBean>(RoleRightsBean.class)));
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public RoleRightsResultBean delete(Integer cusCode) throws Exception {
		RoleRightsResultBean resultBean = new RoleRightsResultBean();
		try {
			if(cusCode!=null) {
				jdbcTemplate.update(RoleRightsQueryUtil.DELETE,cusCode);
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
	public RoleRightsResultBean update(RoleRightsBean bean) throws Exception {
		RoleRightsResultBean resultBean = new RoleRightsResultBean();
		try {
			Map<String, Object> customerMasterMap = new HashMap<String, Object>();
			    
				namedParameterJdbcTemplate.update(RoleRightsQueryUtil.UPDATE_CUSTOMER_MASTER,customerMasterMap);
			   resultBean.setSuccess(true);
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public List<RoleRightsBean> getLoginRoleList(String userName) {
		List<RoleRightsBean> rolesBean = new ArrayList<RoleRightsBean>();
		try {
			rolesBean = jdbcTemplate.query(RoleRightsQueryUtil.getLoginRoleList,new Object[] { userName }, new BeanPropertyRowMapper<RoleRightsBean>(RoleRightsBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return rolesBean;
	}


}
