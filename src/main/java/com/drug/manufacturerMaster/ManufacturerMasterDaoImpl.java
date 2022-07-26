package com.drug.manufacturerMaster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.drug.common.ErrorMessage;
import com.drug.core.util.CustomException;

@Service
public class ManufacturerMasterDaoImpl implements ManufacturerMasterDao {
	private final static Logger LOGGER = LoggerFactory.getLogger(ManufacturerMasterDaoImpl.class);
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
 					bean.getFax(),
 					//bean.getUseName(),
 
 					}, String.class);

		    resultBean.setSuccess(true);
		    System.out.print(result);
		}
 		catch (Exception e) {
			LOGGER.error("Error in addManufacturer", e);
			resultBean.setSuccess(false);
			resultBean.setMessage(ErrorMessage.ERROR_ADD);
		}
		return resultBean;
	}

	
	@Override
	public ManufacturerMasterResultBean saveManufactureReturnPolicy(ManufactureReturnPolicyBean bean) throws Exception {
		ManufacturerMasterResultBean resultBean = new ManufacturerMasterResultBean();
		String result="";
 		try {
 			int isexit=jdbcTemplate.queryForObject(ManufacturerMasterQueryUtil.CHECKISEXIST_MANUFACTURE_RETURNPOLICY, new Object[]{ bean.getManufacturerCode() }, int.class);
			if(isexit>0) {
 			result= jdbcTemplate.queryForObject(ManufacturerMasterQueryUtil.UPDATE_MANUFACTURE_RETURNPOLICY, new Object[]{
 					bean.getManufacturerCode(),
 					bean.getNoMonthsBeforeExpiration(),
 					bean.getNoMonthsAfterExpiration(),
 					bean.getAcceptReturns(),
 					bean.getAcceptPartialReturns(),
 					bean.getAcceptpercentage(),
 					bean.getCheckPackageOriginality()
 					}, String.class);
			}else {
				 result= jdbcTemplate.queryForObject(ManufacturerMasterQueryUtil.INSERT_MANUFACTURE_RETURNPOLICY, new Object[]{
		 					bean.getManufacturerCode(),
		 					bean.getNoMonthsBeforeExpiration(),
		 					bean.getNoMonthsAfterExpiration(),
		 					bean.getAcceptReturns(),
		 					bean.getAcceptPartialReturns(),
		 					bean.getAcceptpercentage(),
		 					bean.getCheckPackageOriginality()
		 					}, String.class);
			}
		    resultBean.setSuccess(true);
		    System.out.print(result);
		}
 		catch (Exception e) {
			LOGGER.error("Error in addManufacturer", e);
			resultBean.setSuccess(false);
			resultBean.setMessage(ErrorMessage.ERROR_ADD);
		}
		return resultBean;
	}
	
	

	@Override
	public ManufacturerMasterResultBean editManufactureReturnPolicy(String bean) {
		ManufacturerMasterResultBean resultBean = new ManufacturerMasterResultBean();
		resultBean.setSuccess(false);
		try {
			int isexit=jdbcTemplate.queryForObject(ManufacturerMasterQueryUtil.CHECKISEXIST_MANUFACTURE_RETURNPOLICY, new Object[]{ bean }, int.class);
			if(isexit>0) {
			resultBean.setManufactureReturnPolicyBean(jdbcTemplate.queryForObject(ManufacturerMasterQueryUtil.GETMANUFACTURE_RETURNPOLICY,new Object[] { bean }, new BeanPropertyRowMapper<ManufactureReturnPolicyBean>(ManufactureReturnPolicyBean.class)));
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
	public ManufacturerMasterResultBean delete(String code) throws Exception {
		ManufacturerMasterResultBean resultBean = new ManufacturerMasterResultBean();
		try {
			if(code!=null) {
				jdbcTemplate.update(ManufacturerMasterQueryUtil.DELETE_MANUFACTURE,code);
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
	 					bean.getFax(),
	 					// bean.getUseName()
	 					}, String.class);

			   resultBean.setSuccess(true);
			   System.out.print(result);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean;
	}



	


}
