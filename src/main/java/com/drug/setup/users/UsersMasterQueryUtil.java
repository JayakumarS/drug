package com.drug.setup.users;

public class UsersMasterQueryUtil {

	public static final String INSERT = "insert into item_category (category_name) values(fileUploadUrl) ";
	
	public static final String getList = "select role_id as roleId,name as roleName,remark as remarks from auth.role order by name asc";

	public static final String DELETE = "delete from auth.role where role_id = ?";
	public static final String SELECT_DTL = "select role_id as roleId,name as roleName,remark as remarks from auth.role where role_id = ?";
	public static final String UPDATE_CUSTOMER_MASTER = "update auth.role set name=:roleName,remark=:remarks where role_id=:roleId";
	
	public static final String GET_ROLE_LIST = "select role_id as id ,name as text from auth.role ";

}
