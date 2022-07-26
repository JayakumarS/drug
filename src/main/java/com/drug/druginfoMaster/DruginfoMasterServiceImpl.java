package com.drug.druginfoMaster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DruginfoMasterServiceImpl implements DruginfoMasterService {

	@Autowired
	DruginfoMasterDao drugInfoMasterDao;
	
	@Override
	public DruginfoMasterResultBean save(DruginfoMasterBean bean) throws Exception {
		return drugInfoMasterDao.save(bean);
	}

	@Override
	public List<DruginfoMasterBean> getList() throws Exception {
		return drugInfoMasterDao.getList();
	}

	@Override
	public DruginfoMasterResultBean edit(String bean) throws Exception {
		return drugInfoMasterDao.edit(bean);
	}

	@Override
	public DruginfoMasterResultBean delete(String bean) throws Exception {
		return drugInfoMasterDao.delete(bean);
	}

	@Override
	public DruginfoMasterResultBean update(DruginfoMasterBean bean) throws Exception {
		return drugInfoMasterDao.update(bean);
	}

	@Override
	public DruginfoMasterResultBean getManufacturerList() {
		return drugInfoMasterDao.getManufacturerList();
	}

	@Override
	public DruginfoMasterResultBean saveDruginfoReturnPolicy(DruginfoReturnPolicyBean bean) throws Exception {
		return drugInfoMasterDao.saveDruginfoReturnPolicy(bean);
	}

	@Override
	public DruginfoMasterResultBean editDruginfoReturnPolicy(String bean) {
		return drugInfoMasterDao.editDruginfoReturnPolicy(bean);
	}

}
