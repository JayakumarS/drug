package com.drug.common.services;

public class CommonServicesQueryUtil {

	public static final String GETUSERNAME = "select case when (count(*)) >0 then true else false end as result from auth.app_user where user_id = ?;";
	
	
}
