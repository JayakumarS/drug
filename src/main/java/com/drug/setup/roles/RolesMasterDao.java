package com.drug.setup.roles;

import java.util.List;

public interface RolesMasterDao {

	RolesMasterResultBean save(RolesMasterBean bean) throws Exception;

	List<RolesMasterBean> getList() throws Exception;

	RolesMasterResultBean edit(Integer bean) throws Exception;

	RolesMasterResultBean delete(Integer bean) throws Exception;

	RolesMasterResultBean update(RolesMasterBean bean) throws Exception;

}
