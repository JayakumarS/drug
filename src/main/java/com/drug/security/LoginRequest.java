package com.drug.security;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
	
	@NotBlank
	private String username;

	@NotBlank
	private String password;
	
	private String otpValue;
	
	private String userNameEmailId;
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOtpValue() {
		return otpValue;
	}

	public void setOtpValue(String otpValue) {
		this.otpValue = otpValue;
	}

	public String getUserNameEmailId() {
		return userNameEmailId;
	}

	public void setUserNameEmailId(String userNameEmailId) {
		this.userNameEmailId = userNameEmailId;
	}
	
	
}
