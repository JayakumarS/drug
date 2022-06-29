package com.drug.core.util;

import java.util.ArrayList;
import java.util.List;

public class CustomException extends Exception {

	private static final long serialVersionUID = -2041196429853744956L;

	private String sCustomMessage = "";
	private List<String> lCustomMessage = new ArrayList<String>();

	public CustomException() {
		super();
	}

	public CustomException(String sCustomMessage, List<String> lcustomMessage) {
		this.sCustomMessage = sCustomMessage;
		this.lCustomMessage = lcustomMessage;
	}

	public CustomException(String sCustomMessage) {
		this.sCustomMessage = sCustomMessage;
	}

	public String getCustomMessage() {
		return sCustomMessage;
	}

	public void setCustomMessage(String sCustomMessage) {
		this.sCustomMessage = sCustomMessage;
	}

	public List<String> getAlCustomMessage() {
		return lCustomMessage;
	}

	public void setAlCustomMessage(String sCustomMessage) {
		lCustomMessage.add(sCustomMessage);
	}

	@Override
	public String getMessage() {
		return this.sCustomMessage;
	}
}
