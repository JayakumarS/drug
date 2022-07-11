package com.drug.manufacturerMaster;

import java.util.List;

import com.drug.setup.users.UsersMasterBean;

public interface ManufacturerMasterService {

	
	ManufacturerMasterResultBean save(ManufacturerMasterBean bean) throws Exception;

	public List<ManufacturerMasterBean> getList() throws Exception;

	ManufacturerMasterResultBean edit(String code) throws Exception;

	ManufacturerMasterResultBean delete(Integer code) throws Exception;

	ManufacturerMasterResultBean update(ManufacturerMasterBean bean) throws Exception;

}
