package com.drug.manufacturerMaster;

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
public class ManufacturerMasterDaoImpl implements ManufacturerMasterDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public ManufacturerMasterResultBean save(ManufacturerMasterBean bean) throws Exception {
		ManufacturerMasterResultBean resultBean = new ManufacturerMasterResultBean();
 		try {
 		
 			
 			String result= jdbcTemplate.queryForObject(ManufacturerMasterQueryUtil.INSERT_MANUFACTURE_MASTER, new Object[]{
 					bean.getManufacturerName(),
 					bean.getLinkTo(),
 					bean.getBillTo(),
 					bean.getReturnService(),
 					bean.getContact(),
 					bean.getEmailId(),
 					bean.getDepartmentName(),
 					bean.getStreetName(),
 					bean.getCityName(),
 					bean.getStateName(),
 					bean.getZipCode(),
 					bean.getPhoneNo(),
 					bean.getTollFreeNo(),
 					bean.getFax()}, String.class);

		    resultBean.setSuccess(true);
		    System.out.print(result);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		
		return resultBean;
	}

	@Override
	public List<ManufacturerMasterBean> getList() throws Exception {
		List<ManufacturerMasterBean> objmanufacturerMasterBean = new ArrayList<ManufacturerMasterBean>();
		try {
			objmanufacturerMasterBean = jdbcTemplate.query(ManufacturerMasterQueryUtil.GET_MANUFACTURE_LIST, new BeanPropertyRowMapper<ManufacturerMasterBean>(ManufacturerMasterBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return objmanufacturerMasterBean;
	}

	@Override
	public ManufacturerMasterResultBean edit(String code) throws Exception {
		ManufacturerMasterResultBean resultBean = new ManufacturerMasterResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setmanufacturerMasterBean(jdbcTemplate.queryForObject(ManufacturerMasterQueryUtil.GETCUSCODE,new Object[] { code }, new BeanPropertyRowMapper<ManufacturerMasterBean>(ManufacturerMasterBean.class)));
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public ManufacturerMasterResultBean delete(Integer code) throws Exception {
		ManufacturerMasterResultBean resultBean = new ManufacturerMasterResultBean();
		try {
			if(code!=null) {
				jdbcTemplate.update(ManufacturerMasterQueryUtil.DELETE_CUSTOMER,code);
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
	public ManufacturerMasterResultBean update(ManufacturerMasterBean bean) throws Exception {
		ManufacturerMasterResultBean resultBean = new ManufacturerMasterResultBean();
		try {
			String result= jdbcTemplate.queryForObject(ManufacturerMasterQueryUtil.UPDATE_MANUFACTURE_MASTER, new Object[]{
	 					bean.getManufacturerCode(),
	 					bean.getManufacturerName(),
	 					bean.getLinkTo(),
	 					bean.getBillTo(),
	 					bean.getReturnService(),
	 					bean.getContact(),
	 					bean.getEmailId(),
	 					bean.getDepartmentName(),
	 					bean.getStreetName(),
	 					bean.getCityName(),
	 					bean.getStateName(),
	 					bean.getZipCode(),
	 					bean.getPhoneNo(),
	 					bean.getTollFreeNo(),
	 					bean.getFax()}, String.class);

			   resultBean.setSuccess(true);
			   System.out.print(result);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean;
	}

	


}
