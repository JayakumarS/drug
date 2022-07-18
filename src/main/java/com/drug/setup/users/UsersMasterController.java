package com.drug.setup.users;

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


@RestController
@RequestMapping("/api/auth/app/userMaster")
public class UsersMasterController {
	@Autowired
	UsersMasterService usersMasterService;
	
	@Value("${file.upload.drugCustomerUpload}")
	private String drugCustomerUpload;
	
	@Value("${file.upload.drugCustomerUploadServerPath}")
	private String drugCustomerUploadServerPath;
	
	@RequestMapping(value="/save")
	public UsersMasterResultBean save(@RequestBody UsersMasterBean bean) {
		UsersMasterResultBean objbean = new UsersMasterResultBean();
		try {
			objbean = usersMasterService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	
	@RequestMapping(value = "/getList")
   	public UsersMasterResultBean getList() throws Exception {
		UsersMasterResultBean objResultBean = new UsersMasterResultBean();
		objResultBean.setUsersMasterDetails(usersMasterService.getList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
	@RequestMapping(value = "/edit")
	public UsersMasterResultBean edit(@RequestParam("usersId") String usersId) throws Exception {
		UsersMasterResultBean objResultBean = new UsersMasterResultBean();
		try {
			objResultBean = usersMasterService.edit(usersId);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@RequestMapping(value="/update")
	public UsersMasterResultBean update(@RequestBody UsersMasterBean bean) {
		UsersMasterResultBean objResultBean = new UsersMasterResultBean();
		try {
			objResultBean = usersMasterService.update(bean);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@RequestMapping(value="/delete")
	public UsersMasterResultBean delete(@RequestParam("deleteUser") Integer deleteUser) {
		UsersMasterResultBean objResultBean = new UsersMasterResultBean();
		try {
			objResultBean = usersMasterService.delete(deleteUser);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@RequestMapping(value = "/getRoleList")
   	public UsersMasterResultBean getRoleList() throws Exception {
   		return usersMasterService.getRoleList();
   	}
	
	// File Upload
	
		@RequestMapping(value = "/uploadFile")
		public @ResponseBody UsersMasterResultBean uploadFile(@RequestParam MultipartFile file,@RequestParam("fileName") String fileName) {
			UsersMasterResultBean resultBean = new UsersMasterResultBean();
			String filePath = "";
			if (!fileName.isEmpty()) {
				try {	
					filePath = FileUploadUtill.uploadFileHandlerWithOutRandom(file, drugCustomerUpload, drugCustomerUploadServerPath, fileName);
					resultBean.setFileName(fileName);
					resultBean.setFilePath(filePath);
					resultBean.setSuccess(true);
				} catch (Exception e) {
					resultBean.setSuccess(false);
					resultBean.setMessage(e.getMessage());
				}
			} else {
				resultBean.setSuccess(false);
				resultBean
						.setMessage("You failed to upload " + fileName + " because the file was empty.");
			}
			return resultBean;
		}
		
		@RequestMapping(value = "/oldPasswordValidation")
	   	public UsersMasterResultBean oldPasswordValidation(@RequestParam("validatePassword") String validatePassword,@RequestParam("userId") String userId) throws Exception {
	   		return usersMasterService.oldPasswordValidation(validatePassword,userId);
	   	}
		
		@RequestMapping(value = "/updatePassword")
	   	public UsersMasterResultBean updatePassword(@RequestBody UsersMasterBean bean)throws Exception {
			UsersMasterResultBean objResultBean = new UsersMasterResultBean();
			try {
				objResultBean = usersMasterService.updatePassword(bean);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return objResultBean;
	   	}
		
		@RequestMapping(value = "/resetPasswordCheck")
	   	public boolean resetPasswordCheck(@RequestParam("resetPasswordPopUp") String userId) throws Exception {
	   		return usersMasterService.resetPasswordCheck(userId);
	   	}
	

}
