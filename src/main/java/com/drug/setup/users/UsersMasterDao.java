package com.drug.setup.users;

import java.util.List;

public interface UsersMasterDao {

	UsersMasterResultBean save(UsersMasterBean bean) throws Exception;

	List<UsersMasterBean> getList() throws Exception;

	UsersMasterResultBean edit(Integer bean) throws Exception;

	UsersMasterResultBean delete(Integer bean) throws Exception;

	UsersMasterResultBean update(UsersMasterBean bean) throws Exception;

	UsersMasterResultBean getRoleList() throws Exception;
}
