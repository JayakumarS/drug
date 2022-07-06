package com.drug.report.returnMemo;

import java.util.List;

public interface RetrunMemoDao {
	
	List<ResultMemoResultBean> getMemoList() throws Exception;
	List<CompleteReturnMemoDetails> getMemoDetails() throws Exception;


}
