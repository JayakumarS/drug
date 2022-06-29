package com.drug.formProperty;

import com.drug.core.util.CustomException;

public interface FormPropertyDao {
	public FormPropertyResultBean getFormProperty(String userId) throws CustomException;
	
}
