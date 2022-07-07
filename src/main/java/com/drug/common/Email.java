package com.drug.common;

import java.util.Map;

public class Email {

	private String[] bccEmailAddress;

	private String bodyHtml;

	private String bodyText;

	private String[] ccEmailAddress;

	private String fromEmailAddress;

	private String subject;

	private String[] toEmailAddress;

	private Map<String, String> attachedFiles;

	public Email() {
		super();
	}

	public Email(String fromEmailAddress, String[] toEmailAddress, String subject, String bodyText, String bodyHtml) {
		super();
		this.fromEmailAddress = fromEmailAddress;
		this.toEmailAddress = toEmailAddress;
		this.subject = subject;
		this.bodyText = bodyText;
		this.bodyHtml = bodyHtml;
	}

	public Email(String fromEmailAddress, String[] toEmailAddress, String subject, String bodyText, String bodyHtml, Map<String, String> attachedFiles) {
		super();
		this.fromEmailAddress = fromEmailAddress;
		this.toEmailAddress = toEmailAddress;
		this.subject = subject;
		this.bodyText = bodyText;
		this.bodyHtml = bodyHtml;
		this.attachedFiles = attachedFiles;
	}

	public Email(String fromEmailAddress, String[] toEmailAddress, String[] ccEmailAddress, String[] bccEmailAddress, String subject, String bodyText, String bodyHtml) {
		super();
		this.fromEmailAddress = fromEmailAddress;
		this.toEmailAddress = toEmailAddress;
		this.ccEmailAddress = ccEmailAddress;
		this.bccEmailAddress = bccEmailAddress;
		this.subject = subject;
		this.bodyText = bodyText;
		this.bodyHtml = bodyHtml;
	}

	public Email(String fromEmailAddress, String[] toEmailAddress, String[] ccEmailAddress, String[] bccEmailAddress, String subject, String bodyText, String bodyHtml, Map<String, String> attachedFiles) {
		super();
		this.fromEmailAddress = fromEmailAddress;
		this.toEmailAddress = toEmailAddress;
		this.ccEmailAddress = ccEmailAddress;
		this.bccEmailAddress = bccEmailAddress;
		this.subject = subject;
		this.bodyText = bodyText;
		this.bodyHtml = bodyHtml;
		this.attachedFiles = attachedFiles;
	}

	public String[] getBccEmailAddress() {
		return bccEmailAddress;
	}

	public void setBccEmailAddress(String[] bccEmailAddress) {
		this.bccEmailAddress = bccEmailAddress;
	}

	public String getBodyHtml() {
		return bodyHtml;
	}

	public void setBodyHtml(String bodyHtml) {
		this.bodyHtml = bodyHtml;
	}

	public String getBodyText() {
		return bodyText;
	}

	public void setBodyText(String bodyText) {
		this.bodyText = bodyText;
	}

	public String[] getCcEmailAddress() {
		return ccEmailAddress;
	}

	public void setCcEmailAddress(String[] ccEmailAddress) {
		this.ccEmailAddress = ccEmailAddress;
	}

	public String getFromEmailAddress() {
		return fromEmailAddress;
	}

	public void setFromEmailAddress(String fromEmailAddress) {
		this.fromEmailAddress = fromEmailAddress;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String[] getToEmailAddress() {
		return toEmailAddress;
	}

	public void setToEmailAddress(String[] toEmailAddress) {
		this.toEmailAddress = toEmailAddress;
	}

	public String toStringVerbose() {
		StringBuffer sbf = new StringBuffer();
		sbf.append("  fromEmailAddress:           " + getFromEmailAddress() + "\n");

		for (int i = 0; i < toEmailAddress.length; i++) {
			sbf.append("   toEmailAddress" + i + ":        " + toEmailAddress[i] + "\n");
		}

		for (int i = 0; i < ccEmailAddress.length; i++) {
			sbf.append("   ccEmailAddress" + i + ":        " + ccEmailAddress[i] + "\n");
		}

		for (int i = 0; i < bccEmailAddress.length; i++) {
			sbf.append("  bccEmailAddress" + i + ":        " + bccEmailAddress[i] + "\n");
		}

		sbf.append("  subject:               " + getSubject() + "\n");
		sbf.append("  bodyText:                  " + getBodyText() + "\n");
		sbf.append("  bodyHtml:                  " + getBodyHtml() + "\n");

		return sbf.toString();
	}

	@Override
	public String toString() {
		return null;
	}

	/**
	 * @return the attachedFiles
	 */
	public Map<String, String> getAttachedFiles() {
		return attachedFiles;
	}

	/**
	 * @param attachedFiles
	 *            the attachedFiles to set
	 */
	public void setAttachedFiles(Map<String, String> attachedFiles) {
		this.attachedFiles = attachedFiles;
	}

	public Object getEmailId() {
		// TODO Auto-generated method stub
		return null;
	}

}
