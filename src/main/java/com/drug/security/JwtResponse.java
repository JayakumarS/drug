package com.drug.security;

import java.util.List;

import com.drug.setup.roles.RolesMasterBean;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String email;
	private List<RolesMasterBean> roles;
	private boolean success;
	private String message;
	private Integer defaultRoleId;
	private String defaultRole;
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public JwtResponse(String accessToken, Long id, String username, String email, List<RolesMasterBean> roles,boolean success,String message,Integer defaultRoleId,String defaultRole) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
		this.success = success;
		this.message = message;
		this.defaultRoleId = defaultRoleId;
		this.defaultRole = defaultRole;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<RolesMasterBean> getRoles() {
		return roles;
	}

	public Integer getDefaultRoleId() {
		return defaultRoleId;
	}

	public void setDefaultRoleId(Integer defaultRoleId) {
		this.defaultRoleId = defaultRoleId;
	}

	public String getDefaultRole() {
		return defaultRole;
	}

	public void setDefaultRole(String defaultRole) {
		this.defaultRole = defaultRole;
	}
}
