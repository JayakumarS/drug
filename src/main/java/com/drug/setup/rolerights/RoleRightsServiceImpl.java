package com.drug.setup.rolerights;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleRightsServiceImpl implements RoleRightsService {
	@Autowired
	RoleRightsDao rolesMasterDao;

	@Override
	public RoleRightsResultBean save(RoleRightsBean bean) throws Exception {
		return rolesMasterDao.save(bean);
	}

	@Override
	public List<RoleRightsBean> getList() throws Exception {
		// TODO Auto-generated method stub
		return rolesMasterDao.getList();
	}

	@Override
	public RoleRightsResultBean delete(Integer bean) throws Exception {
		// TODO Auto-generated method stub
		return rolesMasterDao.delete(bean);
	}

	@Override
	public RoleRightsResultBean update(RoleRightsBean bean) throws Exception {
		// TODO Auto-generated method stub
		return rolesMasterDao.update(bean);
	}

	@Override
	public RoleRightsResultBean edit(Integer bean) throws Exception {
		// TODO Auto-generated method stub
		return rolesMasterDao.edit(bean);
	}

	@Override
	public List<RoleRightsBean> getLoginRoleList(String userName) {
		// TODO Auto-generated method stub
		return rolesMasterDao.getLoginRoleList(userName);
	}

	


	
}
