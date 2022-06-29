package com.drug.filesupload;

import java.io.Serializable;
import java.util.List;

import com.drug.core.util.BasicResultBean;
import com.drug.core.util.DropDownList;

public class FileUploadResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public boolean success;
	
	private FileUploadBean fileUploadBean;
	
	private List<FileUploadBean> fileUploadDetails;
	
	private List<DropDownList> customerList;
	
	private String fileName;
	private String message;
	private String filePath;
	
	
	
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public FileUploadBean getFileUploadBean() {
		return fileUploadBean;
	}

	public void setFileUploadBean(FileUploadBean fileUploadBean) {
		this.fileUploadBean = fileUploadBean;
	}

	public List<FileUploadBean> getFileUploadDetails() {
		return fileUploadDetails;
	}

	public void setFileUploadDetails(List<FileUploadBean> fileUploadDetails) {
		this.fileUploadDetails = fileUploadDetails;
	}

	public List<DropDownList> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<DropDownList> customerList) {
		this.customerList = customerList;
	}

	

	
	
}
