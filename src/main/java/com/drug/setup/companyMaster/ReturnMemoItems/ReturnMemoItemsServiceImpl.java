package com.drug.setup.companyMaster.ReturnMemoItems;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.core.util.DropDownList;

@Service
public class ReturnMemoItemsServiceImpl implements ReturnMemoItemsService {
	@Autowired
	ReturnMemoItemsDao returnMemoItemsDao;

	@Override
	public ReturnMemoItemsResultBean save(ReturnMemoItemsBean bean) throws Exception {
		return returnMemoItemsDao.save(bean);
	}

	@Override
	public List<ReturnMemoItemsBean> getDebitMemoList() throws Exception {
		// TODO Auto-generated method stub
		return returnMemoItemsDao.getDebitMemoList();
	}

	@Override
	public ReturnMemoItemsResultBean delete(String bean) throws Exception {
		// TODO Auto-generated method stub
		return returnMemoItemsDao.delete(bean);
	}

	@Override
	public ReturnMemoItemsResultBean update(ReturnMemoItemsBean bean) throws Exception {
		// TODO Auto-generated method stub
		return returnMemoItemsDao.update(bean);
	}

	@Override
	public ReturnMemoItemsResultBean edit(String bean) throws Exception {
		// TODO Auto-generated method stub
		return returnMemoItemsDao.edit(bean);
	}

	@Override
	public List<DropDownList> getCompanyMasterList() {
		return returnMemoItemsDao.getCompanyMasterList();
	}

	@Override
	public List<DropDownList> getDebitMemoDropdownList() {
		return returnMemoItemsDao.getDebitMemoDropdownList();
	}

	


	
}
