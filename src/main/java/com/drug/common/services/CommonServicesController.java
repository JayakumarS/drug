package com.drug.common.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.drug.common.FileUploadUtill;
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
	
}