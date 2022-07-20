package com.drug.filesupload;

import java.util.List;

public interface FileUploadDao {

	FileUploadResultBean save(FileUploadBean bean) throws Exception;

	List<FileUploadBean> getList() throws Exception;

	FileUploadResultBean edit(String bean) throws Exception;

	FileUploadResultBean delete(String bean) throws Exception;

	FileUploadResultBean update(FileUploadBean bean) throws Exception;
	
	FileUploadResultBean getCustomerList() throws Exception;

	FileUploadResultBean getCustomerList(String companyCode) throws Exception;
}
