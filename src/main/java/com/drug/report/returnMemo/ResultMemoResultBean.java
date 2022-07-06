package com.drug.report.returnMemo;

import java.util.List;


public class ResultMemoResultBean {
	
private static final long serialVersionUID = 1L;
	
	public boolean Success;
	
	private List<ResultMemoResultBean> memoList;
	
	private String no;
	private String name;
	private String date;
	private String text;
	private String create;	
	
	
	
	
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCreate() {
		return create;
	}

	public void setCreate(String create) {
		this.create = create;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isSuccess() {
		return Success;
	}

	public void setSuccess(boolean success) {
		Success = success;
	}
	
	public List<ResultMemoResultBean> getMemoList() {
		return memoList;
	}

	public void setMemoList(List<ResultMemoResultBean> list) {
		this.memoList = list;
	}


}
