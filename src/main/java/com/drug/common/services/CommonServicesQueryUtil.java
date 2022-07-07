package com.drug.common.services;

public class CommonServicesQueryUtil {

	public static final String GETUSERNAME = "select case when (count(*)) >0 then true else false end as result from auth.app_user where user_id = ?;";
	public static final String INSERT_OTP = "INSERT INTO login_otp (user_id,email_id,otp_value,created_on,isactive) VALUES (:userId,:emailId,:otp,now(),'Y')";
	public static final String INSERT_OTP_HISTORY = "INSERT INTO login_otp_history (user_id,email_id,otp_value,created_on,isactive) VALUES (:userId,:emailId,:otp,now(),'Y')";
	public static final String VALIDATE_OTP = "SELECT case when (count(*)) >0 then true else false end as result from login_otp where user_id =? and otp_value =? and created_on between now()- interval '5 mins' and now() ";
	
	
}
