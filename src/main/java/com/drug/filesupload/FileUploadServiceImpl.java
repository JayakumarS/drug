package com.drug.filesupload;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileUploadServiceImpl implements FileUploadService {
	@Autowired
	FileUploadDao customerMasterDao;

	@Override
	public FileUploadResultBean save(FileUploadBean bean) throws Exception {
		return customerMasterDao.save(bean);
	}

	@Override
	public List<FileUploadBean> getList() throws Exception {
		// TODO Auto-generated method stub
		return customerMasterDao.getList();
	}

	@Override
	public FileUploadResultBean delete(String bean) throws Exception {
		// TODO Auto-generated method stub
		return customerMasterDao.delete(bean);
	}

	@Override
	public FileUploadResultBean update(FileUploadBean bean) throws Exception {
		// TODO Auto-generated method stub
		return customerMasterDao.update(bean);
	}

	@Override
	public FileUploadResultBean edit(String bean) throws Exception {
		// TODO Auto-generated method stub
		return customerMasterDao.edit(bean);
	}

	
	@Override
	public FileUploadResultBean getCustomerList() throws Exception {
		// TODO Auto-generated method stub
		return customerMasterDao.getCustomerList();
	}

	
}
