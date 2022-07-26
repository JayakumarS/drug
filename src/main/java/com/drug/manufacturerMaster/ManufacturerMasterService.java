package com.drug.manufacturerMaster;

import java.util.List;

import com.drug.setup.users.UsersMasterBean;

public interface ManufacturerMasterService {

	
	ManufacturerMasterResultBean save(ManufacturerMasterBean bean) throws Exception;

	ManufacturerMasterResultBean saveManufactureReturnPolicy(ManufactureReturnPolicyBean bean) throws Exception;

	ManufacturerMasterResultBean editManufactureReturnPolicy(String manufacturerId) throws Exception;

	public List<ManufacturerMasterBean> getList() throws Exception;

	ManufacturerMasterResultBean edit(String code) throws Exception;

	ManufacturerMasterResultBean delete(String code) throws Exception;

	ManufacturerMasterResultBean update(ManufacturerMasterBean bean) throws Exception;



}
