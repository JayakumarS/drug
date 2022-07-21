package com.drug.setup.roles;

public class RolesMasterQueryUtil {

	//public static final String INSERT = "insert into auth.role (name,remark,created_by,created_on) values(:roleName,:remarks,:userName,now())";
	public static final String INSERT = "insert into auth.role (name,remark) values(:roleName,:remarks)";

	public static final String getList = "select role_id as roleId,name as roleName,remark as remarks from auth.role order by name asc";

	public static final String DELETE = "delete from auth.role where role_id = ?";
	public static final String SELECT_DTL = "select role_id as roleId,name as roleName,remark as remarks from auth.role where role_id = ?";
	public static final String UPDATE_CUSTOMER_MASTER = "update auth.role set name=:roleName,remark=:remarks where role_id=:roleId";

	public static String getLoginRoleList = "select r.name as roleName,ur.role_id as roleId\r\n"
			+ "from auth.role r\r\n"
			+ "left join auth.user_roles ur  on ur.role_id = r.role_id\r\n"
			+ "where ur.user_id = ?;";
	
	
}
