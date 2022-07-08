package com.drug.report.returnMemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth/app/report/returnMemo")
public class ReturnMemoController {
			
		@Autowired
		RetrunMemoService returnMemoService;
		
		
		@RequestMapping(value = "/getMemoList")
	   	public ResultMemoResultBean getMemoList() throws Exception {
			ResultMemoResultBean objResultBean = new ResultMemoResultBean();
			objResultBean.setMemoList(returnMemoService.getMemoList());
			objResultBean.setSuccess(true);
	   		return objResultBean;
	   	}
		
		@RequestMapping(value = "/getMemoDetails")
	   	public CompleteReturnMemoDetails getMemoDetails() throws Exception {
			CompleteReturnMemoDetails objResultBean = new CompleteReturnMemoDetails();
			objResultBean.setMemoDetails(returnMemoService.getMemoDetails());
			objResultBean.setSuccess(true);
	   		return objResultBean;
	   	}
		
		@RequestMapping(value=  "/getMemoListDetails")
	   	public CompleteReturnMemoDetails getMemoListDetails() throws Exception {
			CompleteReturnMemoDetails objResultBean = new CompleteReturnMemoDetails();
			objResultBean.setMemoDetails(returnMemoService.getMemoListDetails());
			objResultBean.setSuccess(true);
	   		return objResultBean;
	   	}
}
