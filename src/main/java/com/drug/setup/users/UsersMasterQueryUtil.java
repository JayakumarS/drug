package com.drug.setup.users;

public class UsersMasterQueryUtil {
	
	public static final String getList = "select emp_user_id as newUserName,first_name as firstName,last_name as lastName,phone_no as mobileNo,email_id as emailId from employee order by emp_user_id asc";

	public static final String DELETE = "delete from auth.role where role_id = ?";
	public static final String SELECT_DTL = "select role_id as roleId,name as roleName,remark as remarks from auth.role where role_id = ?";
	public static final String UPDATE_CUSTOMER_MASTER = "update auth.role set name=:roleName,remark=:remarks where role_id=:roleId";
	
	public static final String GET_ROLE_LIST = "select role_id as id ,name as text from auth.role ";
	
	public static final String INSERT_Employee = "INSERT INTO employee (emp_id, email_id,created_by,created_dt,first_name,last_name,phone_no,photo_url,emp_name,emp_user_id) VALUES (:empId, :emailId,'',now(),:firstName,:lastName,:mobileNo,:photoUrl,:empName,:userId)";
	
	public static final String INSERT_AppUser = "INSERT INTO auth.app_user(user_id,password,reference_id)values(:userId,:password,:empId)";
	
	public static String GETUSERDETAILS = "select user_id as username,reference_id as email,password as password from auth.app_user where user_id=?";
	
	public static String GETEMPID = "SELECT CASE WHEN MAX(emp_id) IS NULL  THEN 'E0001' ELSE rpad(MAX(emp_id),1,'E')|| lpad(cast(cast((SUBSTRING(MAX(emp_id),2)) as int)+1  as text),4,'0') END FROM employee";

	public static final String INSERT_USER_ROLE_MAP = "insert into auth.user_role_map (user_id,role_id) values (:userId,:roleId)";
}
