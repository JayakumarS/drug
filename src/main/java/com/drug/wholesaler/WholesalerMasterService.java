package com.drug.wholesaler;

import java.util.List;

import com.drug.setup.users.UsersMasterBean;

public interface WholesalerMasterService {

	
	WholesalerMasterResultBean save(WholesalerMasterBean bean) throws Exception;

	public List<WholesalerMasterBean> getList() throws Exception;

	WholesalerMasterResultBean edit(String code) throws Exception;

	WholesalerMasterResultBean delete(Integer code) throws Exception;

	WholesalerMasterResultBean update(WholesalerMasterBean bean) throws Exception;

}
