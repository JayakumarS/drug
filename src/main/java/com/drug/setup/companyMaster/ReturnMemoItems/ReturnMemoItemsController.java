package com.drug.setup.companyMaster.ReturnMemoItems;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.drug.core.util.DropDownList;
import com.drug.core.util.ResultResponse;


@RestController
@RequestMapping("/api/auth/app/returnMemoItems")
public class ReturnMemoItemsController {
	@Autowired
	ReturnMemoItemsService returnMemoItemsService;
	
	@RequestMapping(value="/save")
	public ReturnMemoItemsResultBean save(@RequestBody ReturnMemoItemsBean bean) {
		ReturnMemoItemsResultBean objbean = new ReturnMemoItemsResultBean();
		try {
			objbean = returnMemoItemsService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	
	@RequestMapping(value = "/getList")
   	public ReturnMemoItemsResultBean getdebitMemoList(@RequestBody ReturnMemoItemsBean bean) throws Exception {
		ReturnMemoItemsResultBean objResultBean = new ReturnMemoItemsResultBean();
		objResultBean.setListReturnMemoItems(returnMemoItemsService.getDebitMemoList(bean));
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
	@RequestMapping(value = "/edit")
	public ReturnMemoItemsResultBean edit(@RequestParam("returnMemoNo") String returnMemoNo) throws Exception {
		ReturnMemoItemsResultBean objResultBean = new ReturnMemoItemsResultBean();
		try {
			objResultBean = returnMemoItemsService.edit(returnMemoNo);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@RequestMapping(value="/update")
	public ReturnMemoItemsResultBean update(@RequestBody ReturnMemoItemsBean bean) {
		ReturnMemoItemsResultBean objResultBean = new ReturnMemoItemsResultBean();
		try {
			objResultBean = returnMemoItemsService.update(bean);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@RequestMapping(value="/delete")
	public ReturnMemoItemsResultBean delete(@RequestParam("returnMemoNo") String returnMemoNo) {
		ReturnMemoItemsResultBean objResultBean = new ReturnMemoItemsResultBean();
		try {
			objResultBean = returnMemoItemsService.delete(returnMemoNo);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}

	
	@RequestMapping(value= "/getCompanyMasterDropdownList")
	public List<DropDownList> getCompanyMasterList(){
			return returnMemoItemsService.getCompanyMasterList();	
	}
	
	
	@RequestMapping(value= "/getDebitMemoDropdownList")
	public List<DropDownList> getDebitMemoList(){
			return returnMemoItemsService.getDebitMemoDropdownList();	
	}
	
	

	@RequestMapping(value="/fetchreturnMemoNamebyId")
	public ResultResponse fetchreturnMemoNamebyId(@RequestParam("returnMemoNo") String returnMemoNo) throws Exception{
			return returnMemoItemsService.fetchreturnMemoNamebyId(returnMemoNo);	
	}
	
	@RequestMapping(value="/checkDrugIsReturnable")
	public ResultResponse checkDrugIsReturnable(@RequestBody ReturnMemoItemsBean bean) throws Exception{
			return returnMemoItemsService.checkDrugIsReturnable(bean);	
	}
}
