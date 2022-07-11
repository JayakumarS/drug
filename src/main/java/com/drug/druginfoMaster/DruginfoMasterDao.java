package com.drug.druginfoMaster;

import java.util.List;

import com.drug.setup.users.UsersMasterBean;

public interface DruginfoMasterDao {

	DruginfoMasterResultBean save(DruginfoMasterBean bean) throws Exception;

	public List<DruginfoMasterBean> getList() throws Exception;

	DruginfoMasterResultBean edit(String code) throws Exception;

	DruginfoMasterResultBean delete(Integer code) throws Exception;
	
	DruginfoMasterResultBean update(DruginfoMasterBean bean) throws Exception;;

}
