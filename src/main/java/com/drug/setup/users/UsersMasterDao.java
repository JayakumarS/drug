package com.drug.setup.users;

import java.util.List;

public interface UsersMasterDao {

	UsersMasterResultBean save(UsersMasterBean bean) throws Exception;

	List<UsersMasterBean> getList() throws Exception;

	UsersMasterResultBean edit(String usersId)  throws Exception;

	UsersMasterResultBean delete(Integer bean) throws Exception;

	UsersMasterResultBean update(UsersMasterBean bean) throws Exception;

	UsersMasterResultBean getRoleList() throws Exception;

	UsersMasterResultBean oldPasswordValidation(String validatePassword,String userId) throws Exception;

	UsersMasterResultBean updatePassword(UsersMasterBean bean) throws Exception;

	boolean resetPasswordCheck(String userId) throws Exception;
	
}
