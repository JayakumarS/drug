package com.drug.report.returnMemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RetrunMemoServiceImpl implements RetrunMemoService{

	@Autowired
	RetrunMemoDao retrunMemoDao;
	
	@Override
	public List<ResultMemoResultBean> getMemoList() throws Exception {
		return retrunMemoDao.getMemoList();
	}
	
	@Override
	public List<CompleteReturnMemoDetails> getMemoDetails() throws Exception {
		return retrunMemoDao.getMemoDetails();
	}
	
	@Override
	public List<CompleteReturnMemoDetails> getMemoListDetails() throws Exception {
		return retrunMemoDao.getMemoListDetails();
	}
}
