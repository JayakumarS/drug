package com.drug.druginfoMaster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.drug.core.util.DropDownList;
import com.drug.filesupload.FileUploadQueryUtil;
import com.drug.filesupload.FileUploadResultBean;
import com.drug.manufacturerMaster.ManufacturerMasterQueryUtil;
import com.drug.setup.users.UsersMasterBean;

@Service
public class DruginfoMasterDaoImpl implements DruginfoMasterDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public DruginfoMasterResultBean save(DruginfoMasterBean bean) throws Exception {
		DruginfoMasterResultBean resultBean = new DruginfoMasterResultBean();
 		try {
 		
 			
 			String result= jdbcTemplate.queryForObject(DruginfoMasterQueryUtil.INSERT_DRUGINFO_MASTER, new Object[]{
 					bean.getNdcupc(),
 					bean.getManufacturerBy(),
 					bean.getDescription(),
 					bean.getStrength(),
 					bean.getControl(),
 					bean.getPackageSize(),
 					bean.getRxOtc(),
 					bean.getUnitPerPackage(),
 					bean.getUnitDose(),
 					bean.getDosage(),
 					bean.getUnitOfMeasure(),
 					bean.getHazardous(),
 					bean.getAwp(),
 					bean.getWap(),
 					bean.getMyPrice(),
 					//bean.getUserName(),
 					"API"}, String.class);

		    resultBean.setSuccess(true);
		    System.out.print(result);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		
		return resultBean;
	}

	@Override
	public List<DruginfoMasterBean> getList() throws Exception {
		List<DruginfoMasterBean> objDrugInfoMasterBean = new ArrayList<DruginfoMasterBean>();
		try {
			objDrugInfoMasterBean = jdbcTemplate.query(DruginfoMasterQueryUtil.GET_DRUGINFO_LIST, new BeanPropertyRowMapper<DruginfoMasterBean>(DruginfoMasterBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return objDrugInfoMasterBean;
	}

	@Override
	public DruginfoMasterResultBean edit(String code) throws Exception {
		DruginfoMasterResultBean resultBean = new DruginfoMasterResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setDrugInfoMasterBean(jdbcTemplate.queryForObject(DruginfoMasterQueryUtil.GETCUSCODE,new Object[] { code }, new BeanPropertyRowMapper<DruginfoMasterBean>(DruginfoMasterBean.class)));
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public DruginfoMasterResultBean delete(String code) throws Exception {
		DruginfoMasterResultBean resultBean = new DruginfoMasterResultBean();
		try {
			if(code!=null) {
				jdbcTemplate.update(DruginfoMasterQueryUtil.DELETE_DRUGINFO,code);
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
	public DruginfoMasterResultBean update(DruginfoMasterBean bean) throws Exception {
		DruginfoMasterResultBean resultBean = new DruginfoMasterResultBean();
		try {
			String result= jdbcTemplate.queryForObject(DruginfoMasterQueryUtil.UPDATE_DRUGINFO_MASTER, new Object[]{
					bean.getNdcupc(),
 					bean.getManufacturerBy(),
 					bean.getDescription(),
 					bean.getStrength(),
 					bean.getControl(),
 					bean.getPackageSize(),
 					bean.getRxOtc(),
 					bean.getUnitPerPackage(),
 					bean.getUnitDose(),
 					bean.getDosage(),
 					bean.getUnitOfMeasure(),
 					bean.getHazardous(),
 					bean.getAwp(),
 					bean.getWap(),
 					bean.getMyPrice(),
 				//	bean.getUserName(),
 					"API"}, String.class);

			   resultBean.setSuccess(true);
			   System.out.print(result);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public DruginfoMasterResultBean getManufacturerList() {
		DruginfoMasterResultBean druginfoMasterResultBean =new DruginfoMasterResultBean ();
		druginfoMasterResultBean.setSuccess(false);
		try {
			druginfoMasterResultBean.setManufacturerList(jdbcTemplate.query(DruginfoMasterQueryUtil.GET_MANUFACTURER_LIST, new BeanPropertyRowMapper<DropDownList>(DropDownList.class)));
			druginfoMasterResultBean.setSuccess(true);
			
		}catch(Exception e){
			e.printStackTrace();
			druginfoMasterResultBean.setSuccess(false);
		}
		return druginfoMasterResultBean;
	}

	@Override
	public DruginfoMasterResultBean saveDruginfoReturnPolicy(DruginfoReturnPolicyBean bean)throws Exception {
		DruginfoMasterResultBean resultBean = new DruginfoMasterResultBean();
		String result="";
 		try {
 			int isexit=jdbcTemplate.queryForObject(DruginfoMasterQueryUtil.CHECKISEXIST_DRUG_RETURNPOLICY, new Object[]{ bean.getNdcupcCode() }, int.class);
			if(isexit>0) {
 			result= jdbcTemplate.queryForObject(DruginfoMasterQueryUtil.UPDATE_DRUG_RETURNPOLICY, new Object[]{
 					bean.getNdcupcCode(),
 					bean.getNoMonthsBeforeExpiration(),
 					bean.getNoMonthsAfterExpiration(),
 					bean.getAcceptReturns(),
 					bean.getAcceptPartialReturns(),
 					bean.getAcceptpercentage(),
 					bean.getCheckPackageOriginality()
 					}, String.class);
			}else {
				 result= jdbcTemplate.queryForObject(DruginfoMasterQueryUtil.INSERT_DRUG_RETURNPOLICY, new Object[]{
		 					bean.getNdcupcCode(),
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
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		
		return resultBean;
	}

	@Override
	public DruginfoMasterResultBean editDruginfoReturnPolicy(String bean) {
		DruginfoMasterResultBean resultBean = new DruginfoMasterResultBean();
		resultBean.setSuccess(false);
		try {
			int isexit=jdbcTemplate.queryForObject(DruginfoMasterQueryUtil.CHECKISEXIST_DRUG_RETURNPOLICY, new Object[]{ bean }, int.class);
			if(isexit>0) {
			 resultBean.setDruginfoReturnPolicyBean(jdbcTemplate.queryForObject(DruginfoMasterQueryUtil.GETDRUG_RETURNPOLICY,new Object[] { bean }, new BeanPropertyRowMapper<DruginfoReturnPolicyBean>(DruginfoReturnPolicyBean.class)));
			}
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}



	


}
