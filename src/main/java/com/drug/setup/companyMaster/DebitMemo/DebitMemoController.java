package com.drug.setup.companyMaster.DebitMemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.drug.core.util.DropDownList;


@RestController
@RequestMapping("/api/auth/app/debitMemo")
public class DebitMemoController {
	@Autowired
	DebitMemoService debitMemoService;
	
	@RequestMapping(value="/save")
	public DebitMemoResultBean save(@RequestBody DebitMemoBean bean) {
		DebitMemoResultBean objbean = new DebitMemoResultBean();
		try {
			objbean = debitMemoService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	
	@RequestMapping(value = "/getList")
   	public DebitMemoResultBean getdebitMemoList() throws Exception {
		DebitMemoResultBean objResultBean = new DebitMemoResultBean();
		objResultBean.setListDebitMemo(debitMemoService.getDebitMemoList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
	@RequestMapping(value = "/edit")
	public DebitMemoResultBean edit(@RequestParam("debitMemo") String debitMemo) throws Exception {
		DebitMemoResultBean objResultBean = new DebitMemoResultBean();
		try {
			objResultBean = debitMemoService.edit(debitMemo);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@RequestMapping(value="/update")
	public DebitMemoResultBean update(@RequestBody DebitMemoBean bean) {
		DebitMemoResultBean objResultBean = new DebitMemoResultBean();
		try {
			objResultBean = debitMemoService.update(bean);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@RequestMapping(value="/delete")
	public DebitMemoResultBean delete(@RequestParam("debitMemo") String debitMemo) {
		DebitMemoResultBean objResultBean = new DebitMemoResultBean();
		try {
			objResultBean = debitMemoService.delete(debitMemo);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}

	
	@RequestMapping(value= "/getCompanyMasterDropdownList")
	public List<DropDownList> getCompanyMasterList(){
			return debitMemoService.getCompanyMasterList();	
	}
	
	
	@RequestMapping(value= "/getDebitMemoDropdownList")
	public List<DropDownList> getDebitMemoList(){
			return debitMemoService.getDebitMemoDropdownList();	
	}
	
}
