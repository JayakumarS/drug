package com.drug.common.services;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.drug.core.util.DropDownList;
import com.drug.setup.users.UsersMasterBean;

@Service
public class CommonServicesServiceImpl implements CommonServicesService {
	
	public static final String url = "https://www.google.com/recaptcha/api/siteverify";
	public static final String secret = "6LeiApIfAAAAAFIrMh9iBzdm-5BBoZEB5hh-XfkW";
	private final static String USER_AGENT = "Mozilla/5.0";
	
	private final RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	CommonServicesDao commonServicesDao;
	
//	@Value("${google.recaptcha.secret.key}")
//    public String recaptchaSecret;
//	
//    @Value("${google.recaptcha.verify.url}")
//    public String recaptchaVerifyUrl;

	@Override
	public boolean validateUserName(String userName) {
		// TODO Auto-generated method stub
		return commonServicesDao.validateUserName(userName);
	}

	@Override
	public void insertOtp(String userId, String emailId, String otp) {
		// TODO Auto-generated method stub
		commonServicesDao.insertOtp(userId, emailId, otp);
	}

	@Override
	public HashMap<String, Object> validateOtp(String userId, String otp) {
		// TODO Auto-generated method stub
		return commonServicesDao.validateOtp(userId, otp);
	}

	@Override
	public UsersMasterBean getUserDetails(String empid) {
		// TODO Auto-generated method stub
		return commonServicesDao.getUserDetails(empid);
	}

	@Override
	public Integer getCountValue(String empid) {
		// TODO Auto-generated method stub
		return commonServicesDao.getCountValue(empid);
	}

	@Override
	public List<DropDownList> getCompanyMasterList() {
		return commonServicesDao.getCompanyMasterList();
	}

	@Override
	public List<DropDownList> getDebitMemoList(String companyId) {
		return commonServicesDao.getDebitMemoList(companyId);
	}
	
	public HashMap<String, Object> forgotPassword(String userNameEmailId,String otpForForgotPassword) {
		// TODO Auto-generated method stub
		return commonServicesDao.forgotPassword(userNameEmailId,otpForForgotPassword);
	}

	@Override
	public boolean validateUnique(String tableName, String columnName, String columnValue) {
		// TODO Auto-generated method stub
		return commonServicesDao.validateUnique(tableName,columnName,columnValue);
	}

	@Override
	public boolean verify(String gRecaptchaResponse) {
		// TODO Auto-generated method stub
		
		if (gRecaptchaResponse == null || "".equals(gRecaptchaResponse)) {
			return false;
		}
		
		try{
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String postParams = "secret=" + secret + "&response="
				+ gRecaptchaResponse;

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(postParams);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
//		System.out.println("\nSending 'POST' request to URL : " + url);
//		System.out.println("Post parameters : " + postParams);
//		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
	//	System.out.println(response.toString());
		
		return true;// jsonObject.getBoolean("success");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
    }

	@Override
	public List<DropDownList> getManufacturerList() {
		return commonServicesDao.getManufacturerList();
	}
	
	@Override
	public List<DropDownList> getStateDropdownList() {
		return commonServicesDao.getStateDropdownList();
	}


	
}
