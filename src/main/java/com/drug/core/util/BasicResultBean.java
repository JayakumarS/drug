package com.drug.core.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BasicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String message;
	private String code;
	private String type;
	private boolean success = false;
	private List<String> errors = new ArrayList<String>();

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(String error) {
		this.errors.add(error);
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success
	 *            the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

}
