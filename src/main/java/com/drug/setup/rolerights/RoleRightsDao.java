package com.drug.setup.rolerights;

import java.util.List;

public interface RoleRightsDao {

	RoleRightsResultBean save(RoleRightsBean bean) throws Exception;

	List<RoleRightsBean> getList() throws Exception;

	RoleRightsResultBean edit(Integer bean) throws Exception;

	RoleRightsResultBean delete(Integer bean) throws Exception;

	RoleRightsResultBean update(RoleRightsBean bean) throws Exception;
	
	List<RoleRightsBean> getLoginRoleList(String userName);
	
	RoleRightsResultBean getFormList(Integer roleId)throws Exception;

}
