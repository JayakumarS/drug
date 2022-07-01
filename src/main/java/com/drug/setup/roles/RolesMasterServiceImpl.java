package com.drug.setup.roles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesMasterServiceImpl implements RolesMasterService {
	@Autowired
	RolesMasterDao rolesMasterDao;

	@Override
	public RolesMasterResultBean save(RolesMasterBean bean) throws Exception {
		return rolesMasterDao.save(bean);
	}

	@Override
	public List<RolesMasterBean> getList() throws Exception {
		// TODO Auto-generated method stub
		return rolesMasterDao.getList();
	}

	@Override
	public RolesMasterResultBean delete(Integer bean) throws Exception {
		// TODO Auto-generated method stub
		return rolesMasterDao.delete(bean);
	}

	@Override
	public RolesMasterResultBean update(RolesMasterBean bean) throws Exception {
		// TODO Auto-generated method stub
		return rolesMasterDao.update(bean);
	}

	@Override
	public RolesMasterResultBean edit(Integer bean) throws Exception {
		// TODO Auto-generated method stub
		return rolesMasterDao.edit(bean);
	}

	@Override
	public List<RolesMasterBean> getLoginRoleList(String userName) {
		// TODO Auto-generated method stub
		return rolesMasterDao.getLoginRoleList(userName);
	}

	


	
}
