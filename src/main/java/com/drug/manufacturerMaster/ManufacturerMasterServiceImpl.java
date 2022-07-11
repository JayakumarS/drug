package com.drug.manufacturerMaster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ManufacturerMasterServiceImpl implements ManufacturerMasterService {

	@Autowired
	ManufacturerMasterDao manufacturerMasterDao;
	
	@Override
	public ManufacturerMasterResultBean save(ManufacturerMasterBean bean) throws Exception {
		return manufacturerMasterDao.save(bean);
	}

	@Override
	public List<ManufacturerMasterBean> getList() throws Exception {
		return manufacturerMasterDao.getList();
	}

	@Override
	public ManufacturerMasterResultBean edit(String bean) throws Exception {
		return manufacturerMasterDao.edit(bean);
	}

	@Override
	public ManufacturerMasterResultBean delete(Integer bean) throws Exception {
		return manufacturerMasterDao.delete(bean);
	}

	@Override
	public ManufacturerMasterResultBean update(ManufacturerMasterBean bean) throws Exception {
		return manufacturerMasterDao.update(bean);
	}

}
