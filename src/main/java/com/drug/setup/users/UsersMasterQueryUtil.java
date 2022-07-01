package com.drug.setup.users;

public class UsersMasterQueryUtil {
	
	public static final String getList = "select ud.emp_user_id as newUserName,ud.first_name as firstName,ud.last_name as lastName, "
			+ "ud.phone_no as mobileNo,ud.email_id as emailId,string_agg(r.name,',') as roleText  "
			+ "from user_details ud  "
			+ "left join auth.user_roles ur on ur.user_id = ud.emp_user_id "
			+ "left join auth.role r on r.role_id = ur.role_id "
			+ "group by ud.emp_user_id,ud.first_name,ud.last_name,ud.phone_no,ud.email_id  "
			+ "order by emp_user_id asc";

	public static final String DELETE = "delete from auth.role where role_id = ?";
	public static final String SELECT_DTL = "select role_id as roleId,name as roleName,remark as remarks from auth.role where role_id = ?";
	public static final String UPDATE_CUSTOMER_MASTER = "update auth.role set name=:roleName,remark=:remarks where role_id=:roleId";
	
	public static final String GET_ROLE_LIST = "select role_id as id ,name as text from auth.role ";
	
	public static final String INSERT_USER_DETAILS = "INSERT INTO user_details (emp_id, email_id,created_by,created_dt,first_name,last_name,phone_no,photo_url,emp_name,emp_user_id,company_code) VALUES (:empId, :emailId,'',now(),:firstName,:lastName,:mobileNo,:photoUrl,:empName,:userId,:companyCode)";
	
	public static final String INSERT_AppUser = "INSERT INTO auth.app_user(user_id,password,reference_id)values(:userId,:password,:empId)";
	
	public static String GETUSERDETAILS = "select user_id as username,reference_id as email,password as password from auth.app_user where user_id=?";
	
	public static String GETEMPID = "SELECT CASE WHEN MAX(emp_id) IS NULL  THEN 'E0001' ELSE rpad(MAX(emp_id),1,'E')|| lpad(cast(cast((SUBSTRING(MAX(emp_id),2)) as int)+1  as text),4,'0') END FROM user_details";

	public static final String INSERT_USER_ROLE_MAP = "insert into auth.user_roles (user_id,role_id) values (:userId,:roleId)";
}
