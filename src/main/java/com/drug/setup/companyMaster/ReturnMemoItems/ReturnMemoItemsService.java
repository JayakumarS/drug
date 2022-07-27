package com.drug.setup.companyMaster.ReturnMemoItems;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.drug.core.util.DropDownList;
import com.drug.core.util.ResultResponse;

public interface ReturnMemoItemsService {

	ReturnMemoItemsResultBean save(ReturnMemoItemsBean bean) throws Exception;

	public List<ReturnMemoItemsBean> getDebitMemoList(ReturnMemoItemsBean bean) throws Exception;

	ReturnMemoItemsResultBean edit(String code) throws Exception;

	ReturnMemoItemsResultBean delete(String code) throws Exception;
	
	ReturnMemoItemsResultBean update(ReturnMemoItemsBean bean) throws Exception;

	List<DropDownList> getCompanyMasterList();

	List<DropDownList> getDebitMemoDropdownList();

	ResultResponse fetchreturnMemoNamebyId(String returnMemoNo) throws Exception;

	ResultResponse checkDrugIsReturnable(ReturnMemoItemsBean bean);;


}