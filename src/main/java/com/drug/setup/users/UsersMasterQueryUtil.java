package com.drug.setup.users;

public class UsersMasterQueryUtil {
	
	public static final String getList = "select ud.emp_id as empId, ud.emp_user_id as newUserName,ud.first_name as firstName,\n"
			+ "ud.last_name as lastName,ud.phone_no as mobileNo,ud.email_id as emailId,ud.photo_url as uploadImg,\n"
			+ "string_agg(r.name,',') as roleText from user_details ud left join auth.user_roles ur \n"
			+ "on ur.user_id = ud.emp_user_id left join auth.role r on r.role_id = ur.role_id \n"
			+ "group by ud.emp_id,ud.emp_user_id,ud.first_name,ud.last_name,ud.phone_no,ud.email_id  \n"
			+ "order by emp_user_id asc";

	public static final String DELETE = "delete from auth.role where role_id = ?";
	
//	public static final String SELECT_DTL = "select emp_id as empId,email_id as emailId,first_name as firstName,last_name as lastName,phone_no as mobileNo,emp_name as empName,emp_user_id as newUserName ,role.name as roleName from user_details left join auth.user_roles auth on auth.user_id= user_details.emp_user_id left join auth.role  role on auth.role_id = role.role_id where emp_id =?";
	
	public static final String UPDATE_CUSTOMER_MASTER = "update auth.role set name=:roleName,remark=:remarks where role_id=:roleId";
	
	public static final String GET_ROLE_LIST = "select role_id as id ,name as text from auth.role ";
	
	public static final String INSERT_USER_DETAILS = "INSERT INTO user_details (emp_id, email_id,created_by,created_dt,first_name,last_name,phone_no,photo_url,emp_name,emp_user_id,company_code) VALUES (:empId, :emailId,:userName,now(),:firstName,:lastName,:mobileNo,:photoUrl,:empName,:userId,:companyCode)";
	
	public static final String INSERT_AppUser = "INSERT INTO auth.app_user(user_id,password,reference_id,pwd_changed)values(:userId,:password,:empId,'false')";
	
	public static String GETUSERDETAILS = "select user_id as username,reference_id as email,password as password from auth.app_user where user_id=?";
	
	public static String GETEMPID = "SELECT CASE WHEN MAX(emp_id) IS NULL  THEN 'E0001' ELSE rpad(MAX(emp_id),1,'E')|| lpad(cast(cast((SUBSTRING(MAX(emp_id),2)) as int)+1  as text),4,'0') END FROM user_details";

	public static final String INSERT_USER_ROLE_MAP = "insert into auth.user_roles (user_id,role_id) values (:userId,:id)";


	public static final String UPDATE_CHANGE_PASSWORD = "UPDATE auth.app_user set password=:newChangePassword,pwd_changed='true' where user_id=:newUserName";

	public static final String GET_EMAIL_ID = "select email_id as emailId from user_details where emp_user_id=?";

	public static final String GET_FLAG_VALUE = "select pwd_changed as pwdChanged from auth.app_user where user_id=?";

	public static final String DELETE_USER_ROLE_MAP = " delete from auth.user_roles where user_id =:userId ";
	
//	public static final String UPDATE_CHANGE_PASSWORD = "UPDATE auth.app_user set password=:newChangePassword where user_id=:newUserName";
//
//	public static final String GET_EMAIL_ID = "select email_id as emailId from user_details where emp_user_id=?";

//	public static final String SELECT_ROLE_DTL = "select ur.user_id as newUserName ,ur.role_id as roles ,role.name as roleName from auth.user_roles ur left join auth.role role on role.role_id = ur.role_id where user_id =?";

	public static final String SELECT_DTL = "select emp_id as empId,email_id as emailId,first_name as firstName,last_name as lastName,phone_no as mobileNo,emp_name as empName,emp_user_id as newUserName,photo_url as uploadImg  from user_details where emp_id =?";

	public static final String SELECT_User_Name = "select emp_user_id as newUserName from user_details where emp_id = ?";
	public static final String SELECT_ROLE_DTL = "select distinct ur.role_id as id ,role.name as text from auth.user_roles ur left join auth.role role on role.role_id = ur.role_id where user_id =?";
//	public static final String SELECT_ROLE_DTL = "select string_agg(role_id::text, ',') roles from auth.user_roles where user_id = ?	";
	 

}
