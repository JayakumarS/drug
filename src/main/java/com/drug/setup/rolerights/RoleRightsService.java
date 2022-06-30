package com.drug.setup.rolerights;

import java.util.List;

public interface RoleRightsService {

	RoleRightsResultBean save(RoleRightsBean bean) throws Exception;

	public List<RoleRightsBean> getList() throws Exception;

	RoleRightsResultBean edit(Integer code) throws Exception;

	RoleRightsResultBean delete(Integer code) throws Exception;
	
	RoleRightsResultBean update(RoleRightsBean bean) throws Exception;
	
	public List<RoleRightsBean> getLoginRoleList(String userName);
}