package com.drug.wholesaler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class WholesalerMasterServiceImpl implements WholesalerMasterService {

	@Autowired
	WholesalerMasterDao wholesalerMasterDao;
	
	@Override
	public WholesalerMasterResultBean save(WholesalerMasterBean bean) throws Exception {
		return wholesalerMasterDao.save(bean);
	}

	@Override
	public List<WholesalerMasterBean> getList() throws Exception {
		return wholesalerMasterDao.getList();
	}

	@Override
	public WholesalerMasterResultBean edit(String bean) throws Exception {
		return wholesalerMasterDao.edit(bean);
	}

	@Override
	public WholesalerMasterResultBean delete(Integer bean) throws Exception {
		return wholesalerMasterDao.delete(bean);
	}

	@Override
	public WholesalerMasterResultBean update(WholesalerMasterBean bean) throws Exception {
		return wholesalerMasterDao.update(bean);
	}

}
