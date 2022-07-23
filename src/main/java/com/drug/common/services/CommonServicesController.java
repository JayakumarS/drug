package com.drug.common.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.drug.common.FileUploadUtill;
import com.drug.core.util.DropDownList;
import com.drug.druginfoMaster.DruginfoMasterResultBean;
import com.drug.filesupload.FileUploadResultBean;
import com.drug.setup.users.UsersMasterResultBean;


@RestController
@RequestMapping("/api/auth/app/commonServices")
public class CommonServicesController {
	@Autowired
	CommonServicesService commonServicesService;
	
	@RequestMapping(value = "/edit")
	public boolean validateUserName(@RequestParam("newUserName") String newUserName) throws Exception {
		boolean result = false;
		try {
			result = commonServicesService.validateUserName(newUserName);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	@RequestMapping(value= "/getCompanyMasterDropdownList")
	public List<DropDownList> getCompanyMasterList(){
			return commonServicesService.getCompanyMasterList();	
	}
	
	
	@RequestMapping(value= "/getDebitMemoDropdownList")
	public List<DropDownList> getDebitMemoList(@RequestParam("companyId") String companyId){
			return commonServicesService.getDebitMemoList(companyId);	
	}
	
	@RequestMapping(value = "/getManufacturerDropdownList")
   	public List<DropDownList> getManufacturerList() throws Exception {
   		return commonServicesService.getManufacturerList();
   	}
	
	@RequestMapping(value = "/getStateDropdownList")
   	public List<DropDownList> getStateDropdownList() throws Exception {
   		return commonServicesService.getStateDropdownList();
   	}
			
	@RequestMapping(value = "/validateUnique")
	public boolean validateUnique(@RequestParam("tableName") String tableName,@RequestParam("columnName") String columnName,@RequestParam("columnValue") String columnValue) throws Exception {
		boolean result = false;
		try {
			result = commonServicesService.validateUnique(tableName,columnName,columnValue);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
//	@RequestMapping(value = "/generateCaptcha")
//	public boolean generateCaptcha(@RequestParam("tableName") String tableName,@RequestParam("columnName") String columnName,@RequestParam("columnValue") String columnValue) throws Exception {
//		boolean result = false;
//		try {
//			result = commonServicesService.generateCaptcha(tableName,columnName,columnValue);
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
//	
}
