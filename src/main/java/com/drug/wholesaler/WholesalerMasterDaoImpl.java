package com.drug.wholesaler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.drug.setup.users.UsersMasterBean;

@Service
public class WholesalerMasterDaoImpl implements WholesalerMasterDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public WholesalerMasterResultBean save(WholesalerMasterBean bean) throws Exception {
		WholesalerMasterResultBean resultBean = new WholesalerMasterResultBean();
 		try {
 		
 			
 			String result= jdbcTemplate.queryForObject(WholesalerMasterQueryUtil.INSERT_WHOLESALER_MASTER, new Object[]{
 					bean.getPolicyCode(),
 					bean.getWholesalerName(),
 					bean.getExpiryPacket(),
 					bean.getEmailID(),
 					bean.getAllowOverride(),
 					bean.getDepartment(),
 					bean.getStreet(),
 					bean.getCity(),
 					bean.getState(),
 					bean.getZipCode(),
 					bean.getPhoneNo(),
 					bean.getTollFreeNo(),
 					bean.getFax(),
 					bean.getPhone()}, String.class);

		    resultBean.setSuccess(true);
		    System.out.print(result);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		
		return resultBean;
	}

	@Override
	public List<WholesalerMasterBean> getList() throws Exception {
		List<WholesalerMasterBean> objWholesalerMasterBean = new ArrayList<WholesalerMasterBean>();
		try {
			objWholesalerMasterBean = jdbcTemplate.query(WholesalerMasterQueryUtil.GET_WHOLESALER_LIST, new BeanPropertyRowMapper<WholesalerMasterBean>(WholesalerMasterBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return objWholesalerMasterBean;
	}

	@Override
	public WholesalerMasterResultBean edit(String code) throws Exception {
		WholesalerMasterResultBean resultBean = new WholesalerMasterResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setWholesalerMasterBean(jdbcTemplate.queryForObject(WholesalerMasterQueryUtil.GETCUSCODE,new Object[] { code }, new BeanPropertyRowMapper<WholesalerMasterBean>(WholesalerMasterBean.class)));
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public WholesalerMasterResultBean delete(String code) throws Exception {
		WholesalerMasterResultBean resultBean = new WholesalerMasterResultBean();
		try {
			if(code!=null) {
				jdbcTemplate.update(WholesalerMasterQueryUtil.DELETE_WHOLESALER,code);
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
	public WholesalerMasterResultBean update(WholesalerMasterBean bean) throws Exception {
		WholesalerMasterResultBean resultBean = new WholesalerMasterResultBean();
		try {
			String result= jdbcTemplate.queryForObject(WholesalerMasterQueryUtil.UPDATE_WHOLESALER_MASTER, new Object[]{
	 					bean.getWholesalerCode(),
	 					bean.getPolicyCode(),
	 					bean.getWholesalerName(),
	 					bean.getExpiryPacket(),
	 					bean.getEmailID(),
	 					bean.getAllowOverride(),
	 					bean.getDepartment(),
	 					bean.getStreet(),
	 					bean.getCity(),
	 					bean.getState(),
	 					bean.getZipCode(),
	 					bean.getPhoneNo(),
	 					bean.getTollFreeNo(),
	 					bean.getFax(),
	 					bean.getPhone()}, String.class);

			   resultBean.setSuccess(true);
			   System.out.print(result);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean;
	}

	


}
