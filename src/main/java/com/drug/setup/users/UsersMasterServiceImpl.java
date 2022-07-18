package com.drug.setup.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersMasterServiceImpl implements UsersMasterService {
	@Autowired
	UsersMasterDao rolesMasterDao;

	@Override
	public UsersMasterResultBean save(UsersMasterBean bean) throws Exception {
		return rolesMasterDao.save(bean);
	}

	@Override
	public List<UsersMasterBean> getList() throws Exception {
		// TODO Auto-generated method stub
		return rolesMasterDao.getList();
	}

	@Override
	public UsersMasterResultBean delete(Integer bean) throws Exception {
		// TODO Auto-generated method stub
		return rolesMasterDao.delete(bean);
	}

	@Override
	public UsersMasterResultBean update(UsersMasterBean bean) throws Exception {
		// TODO Auto-generated method stub
		return rolesMasterDao.update(bean);
	}

	@Override
	public UsersMasterResultBean edit(String bean) throws Exception {
		// TODO Auto-generated method stub
		return rolesMasterDao.edit(bean);
	}

	@Override
	public UsersMasterResultBean getRoleList() throws Exception {
		// TODO Auto-generated method stub
		return rolesMasterDao.getRoleList();
	}

	@Override
	public UsersMasterResultBean oldPasswordValidation(String validatePassword,String userId) throws Exception {
		// TODO Auto-generated method stub
		return rolesMasterDao.oldPasswordValidation(validatePassword,userId);
	}

	@Override
	public UsersMasterResultBean updatePassword(UsersMasterBean bean) throws Exception{
		// TODO Auto-generated method stub
		return rolesMasterDao.updatePassword(bean);
	}

	@Override
	public boolean resetPasswordCheck(String userId) throws Exception {
		// TODO Auto-generated method stub
		return rolesMasterDao.resetPasswordCheck(userId);
	}

	


	
}
