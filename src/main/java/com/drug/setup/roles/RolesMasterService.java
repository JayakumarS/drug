package com.drug.setup.roles;

import java.util.List;

public interface RolesMasterService {

	RolesMasterResultBean save(RolesMasterBean bean) throws Exception;

	public List<RolesMasterBean> getList() throws Exception;

	RolesMasterResultBean edit(Integer code) throws Exception;

	RolesMasterResultBean delete(Integer code) throws Exception;
	
	RolesMasterResultBean update(RolesMasterBean bean) throws Exception;

}