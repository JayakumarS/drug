package com.drug.report.returnMemo;

import java.util.List;


public interface RetrunMemoService {
	
	public List<ResultMemoResultBean> getMemoList() throws Exception;
	public List<CompleteReturnMemoDetails> getMemoDetails() throws Exception;
	public List<CompleteReturnMemoDetails> getMemoListDetails() throws Exception;

	

}
