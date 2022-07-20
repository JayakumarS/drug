package com.drug.setup.rolerights;

public class RoleRightsQueryUtil {

	public static final String INSERT = "insert into auth.role_rights (role_id,form_property_id) values(:roleId,:formPropertyId) ";
	
	public static final String getList = "select role_id as roleId,name as roleName,remark as remarks from auth.role order by name asc";

	public static final String DELETE = "delete from auth.role_rights where role_id = ?";
	public static final String SELECT_DTL = "select role_id as roleId,name as roleName,remark as remarks from auth.role where role_id = ?";
	public static final String UPDATE_CUSTOMER_MASTER = "update auth.role set name=:roleName,remark=:remarks where role_id=:roleId";

	public static final String GET_FORM_LIST = "select form_code as item_id,form_name as item_text from auth.form where is_parent='N' and is_active = 'Y' order by form_name";

	public static String getLoginRoleList = "select r.name as roleName,ur.role_id as roleId\r\n"
			+ "from auth.role r\r\n"
			+ "left join auth.user_roles ur  on ur.role_id = r.role_id\r\n"
			+ "where ur.user_id = ?;";
	
	public static String GET_FORM_PROP_ID = "select form_property_id as formPropertyId from auth.form_property where form_code = ?";
	
	public static final String GET_ROLE_BASED_FORM_LIST = "select distinct f.form_code as item_id,f.form_name as item_text \r\n"
			+ "from auth.form f\r\n"
			+ "inner join auth.form_property fp on fp.form_code = f.form_code\r\n"
			+ "inner join auth.role_rights rr on rr.form_property_id = fp.form_property_id\r\n"
			+ "where f.is_parent='N' and f.is_active = 'Y' and rr.role_id = ?\r\n"
			+ "order by f.form_name\r\n"
			+ "";
}
