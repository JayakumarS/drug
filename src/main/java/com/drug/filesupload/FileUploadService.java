package com.drug.filesupload;

import java.util.List;

public interface FileUploadService {

	FileUploadResultBean save(FileUploadBean bean) throws Exception;

	public List<FileUploadBean> getList() throws Exception;

	FileUploadResultBean edit(String code) throws Exception;

	FileUploadResultBean delete(String code) throws Exception;
	
	FileUploadResultBean update(FileUploadBean bean) throws Exception;
	
	FileUploadResultBean getCustomerList()throws Exception;

	FileUploadResultBean getCustomerListFiles(String companyCode) throws Exception;
}