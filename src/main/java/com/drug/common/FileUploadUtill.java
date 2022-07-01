package com.drug.common;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.io.Files;

@RestController
@RequestMapping(value = "app/common")
public class FileUploadUtill {
	@RequestMapping(value = "/uploadFile")
	public @ResponseBody String uploadFileHandler(@RequestParam MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = "D:/EDUERP_FILE_BACKUP/pastHistory";
				File dir = new File(rootPath + File.separator);
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				String fileName = "/picture/pastHistory/" + file.getOriginalFilename();
				return fileName;
			} catch (Exception e) {
				return "You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + file.getOriginalFilename() + " because the file was empty.";
		}
	}

	@RequestMapping(value = "/ailmentuploadfile")
	public @ResponseBody String uploadAliement(@RequestParam MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = "D:/EDUERP_FILE_BACKUP/ailment";
				File dir = new File(rootPath + File.separator);
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				String fileName = "/picture/ailment/" + file.getOriginalFilename();
				return fileName;
			} catch (Exception e) {
				return "You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + file.getOriginalFilename() + " because the file was empty.";
		}
	}

	// Without Random number

	public synchronized static String uploadFileHandlerWithOutRandom(MultipartFile file, String fileAbsolutePath, String serverPath, String fileName) {

		String url = "";
		try {
			File dirCreatory = new File(fileAbsolutePath);
			if (!dirCreatory.exists()) {
				dirCreatory.mkdir();
			}
			if (file.getSize() > 0) {
				String currentTimeStamp = "." + FilenameUtils.getExtension(file.getOriginalFilename());
				//String destinationFileName = fileName + "_" + currentTimeStamp;
				String destinationFileName = fileName ;
				File destinationFile = new File(fileAbsolutePath + destinationFileName);
				//File destinationFile = new File(fileAbsolutePath);
				Files.write(file.getBytes(), destinationFile);
				url = serverPath + "/" + destinationFileName;
				System.out.println("serverpath is" + url);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}
}
