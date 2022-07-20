package com.drug.filesupload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.drug.common.FileUploadUtill;


@RestController
@RequestMapping("/api/auth/app/fileUpload")
public class FileUploadController {
	
	@Value("${file.upload.drugCustomerUpload}")
	private String drugCustomerUpload;
	
	@Value("${file.upload.drugCustomerUploadServerPath}")
	private String drugCustomerUploadServerPath;
	
	@Autowired
	FileUploadService fileUploadService;
	
	@RequestMapping(value="/save")
	public FileUploadResultBean save(@RequestBody FileUploadBean bean) {
		FileUploadResultBean objbean = new FileUploadResultBean();
		try {
			objbean = fileUploadService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	
	@RequestMapping(value = "/getList")
   	public FileUploadResultBean getList() throws Exception {
		FileUploadResultBean objResultBean = new FileUploadResultBean();
		objResultBean.setFileUploadDetails(fileUploadService.getList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
	@RequestMapping(value = "/edit")
	public FileUploadResultBean edit(@RequestParam("customer") String customer) throws Exception {
		FileUploadResultBean objResultBean = new FileUploadResultBean();
		try {
			objResultBean = fileUploadService.edit(customer);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@RequestMapping(value="/update")
	public FileUploadResultBean update(@RequestBody FileUploadBean bean) {
		FileUploadResultBean objResultBean = new FileUploadResultBean();
		try {
			objResultBean = fileUploadService.update(bean);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@RequestMapping(value="/delete")
	public FileUploadResultBean delete(@RequestParam("customer") String customer) {
		FileUploadResultBean objResultBean = new FileUploadResultBean();
		try {
			objResultBean = fileUploadService.delete(customer);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}

	@RequestMapping(value = "/getCustomerList")
   	public FileUploadResultBean getCustomerList() throws Exception {
   		return fileUploadService.getCustomerList();
   	}
	
	@RequestMapping(value = "/uploadFile")
	public @ResponseBody FileUploadResultBean uploadFile(@RequestParam MultipartFile file,@RequestParam("fileName") String fileName) {
		FileUploadResultBean resultBean = new FileUploadResultBean();
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
	
	@GetMapping(value = "/getCustomerListFiles")
   	public FileUploadResultBean getCustomerListFiles(@RequestBody String companyCode) throws Exception {
		FileUploadResultBean objResultBean = new FileUploadResultBean();
		fileUploadService.getCustomerListFiles(companyCode);
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
}
