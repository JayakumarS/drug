package com.drug.common.services;

public class CommonServicesQueryUtil {

	public static final String GETUSERNAME = "select case when (count(*)) >0 then true else false end as result from auth.app_user where user_id = ?;";
	public static final String INSERT_OTP = "INSERT INTO login_otp (user_id,email_id,otp_value,created_on,isactive) VALUES (:userId,:emailId,:otp,now(),'Y')";
	public static final String INSERT_OTP_HISTORY = "INSERT INTO login_otp_history (user_id,email_id,otp_value,created_on,isactive) VALUES (:userId,:emailId,:otp,now(),'Y')";
	public static final String VALIDATE_OTP = "SELECT case when (count(*)) >0 then true else false end as result from login_otp where user_id =? and otp_value =? and created_on between now()- interval '5 mins' and now() ";
	public static final String GETUSERDETAILS = "SELECT email_id as emailId from user_details where emp_id = ? limit 1; ";
	public static final String GETCOUNTVALUE = "SELECT COUNT(*) FROM login_otp_history AS \"Login_otp_history\" WHERE \"Login_otp_history\".\"created_on\" BETWEEN NOW() - INTERVAL '1 HOURS' AND NOW() AND \"Login_otp_history\".\"user_id\"= ? ";
	public static final String DELETE_OTP = "DELETE from login_otp where user_id=? returning user_id as userId";
	public static final String GETOTPVALUE = "select count(*) from login_otp where user_id= ? ";
	public static final String COMPANY_MASTER_DROPDOWNLIST = "select company_code as id, company_name as text from company order by company_name asc";
	public static final String DEBIT_MEMO_DROPDOWNLIST = "select return_memo_no as id, return_memo_name as text from return_memo order by return_memo_name asc";
	
	public static final String GETOLDPASSWORD = "select password  from auth.app_user where user_id = ?";
	public static final String UPDATE_PASSWORD_WITH_EMAIL = "UPDATE auth.app_user set password=:otpForForgotPassword,pwd_changed='false' where user_id=:userNameEmailId";
	public static final String UPDATE_PASSWORD_WITHOUT_EMAIL = "UPDATE auth.app_user set password=:otpForForgotPassword,pwd_changed='false' where user_id=:userNameEmailId";
	public static final String GET_EMAIL_ID = "select email_id as emailId from user_details where emp_user_id=?";
	public static final String VALIDATE_UNIQUE = "SELECT * FROM fn_unique_validation(?,?,?)";
	
}
