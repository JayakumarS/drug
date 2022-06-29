package com.drug.formProperty;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.drug.common.ErrorMessage;
import com.drug.core.util.CustomException;
import com.drug.usermanagement.User;

@Repository
public class FormPropertyDaoImpl implements FormPropertyDao{
	private final static Logger LOGGER = LoggerFactory.getLogger(FormPropertyDaoImpl.class);
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public FormPropertyResultBean getFormProperty(String userId) throws CustomException {
		FormPropertyResultBean objEmployeeMasterResultBean = new FormPropertyResultBean();
		objEmployeeMasterResultBean.setSuccess(false);
		List<FormPropertyBean> formList = new ArrayList<FormPropertyBean>();
		try {
			
			formList = jdbcTemplate.query(FormPropertyQueryUtil.getFormPropertyList, new BeanPropertyRowMapper<FormPropertyBean>(FormPropertyBean.class), userId);
			List<FormPropertyBean> moduleList = formList
			  .stream()
			  .filter(c -> c.getFormcodeparent().equals("F0001"))
			  .sorted(Comparator.comparing(FormPropertyBean::getDisplayorder))
			  .collect(Collectors.toList());

			for(FormPropertyBean moduleBean:moduleList) {
			    List<FormPropertyBean> firstLevelFormList = formList
						  .stream()
						  .filter(c -> c.getFormcodeparent().equals(moduleBean.getForm_code()))
						  .sorted(Comparator.comparing(FormPropertyBean::getDisplayorder))
						  .collect(Collectors.toList());
			    for(FormPropertyBean firstLevelBean:firstLevelFormList) {
			    	List<FormPropertyBean> secondLevelFormList = formList
							  .stream()
							  .filter(c -> c.getFormcodeparent().equals(firstLevelBean.getForm_code()))
							  .sorted(Comparator.comparing(FormPropertyBean::getDisplayorder))
							  .collect(Collectors.toList());
			    	firstLevelBean.setSubMenuList(secondLevelFormList);
			    }
			    moduleBean.setSubMenuList(firstLevelFormList);
			}
					
			objEmployeeMasterResultBean.setModuleLevelList(moduleList);
			
			objEmployeeMasterResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error in Menu Property", e);
			objEmployeeMasterResultBean.setSuccess(false);
			objEmployeeMasterResultBean.setMessage(ErrorMessage.ERROR_MenuList);
			throw new CustomException(ErrorMessage.ERROR_MenuList);
		}
		
		return objEmployeeMasterResultBean;
	}
	
	
}
