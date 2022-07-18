package com.drug.setup.companyMaster.DebitMemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.core.util.DropDownList;

@Service
public class DebitMemoServiceImpl implements DebitMemoService {
	@Autowired
	DebitMemoDao debitMemoDao;

	@Override
	public DebitMemoResultBean save(DebitMemoBean bean) throws Exception {
		return debitMemoDao.save(bean);
	}

	@Override
	public List<DebitMemoBean> getDebitMemoList(DebitMemoBean bean) throws Exception {
		// TODO Auto-generated method stub
		return debitMemoDao.getDebitMemoList(bean);
	}

	@Override
	public DebitMemoResultBean delete(String bean) throws Exception {
		// TODO Auto-generated method stub
		return debitMemoDao.delete(bean);
	}

	@Override
	public DebitMemoResultBean update(DebitMemoBean bean) throws Exception {
		// TODO Auto-generated method stub
		return debitMemoDao.update(bean);
	}

	@Override
	public DebitMemoResultBean edit(String bean) throws Exception {
		// TODO Auto-generated method stub
		return debitMemoDao.edit(bean);
	}

	@Override
	public List<DropDownList> getCompanyMasterList() {
		return debitMemoDao.getCompanyMasterList();
	}

	@Override
	public List<DropDownList> getDebitMemoDropdownList() {
		return debitMemoDao.getDebitMemoDropdownList();
	}

	


	
}
