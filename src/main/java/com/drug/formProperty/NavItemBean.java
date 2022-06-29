package com.drug.formProperty;

import java.util.List;

public class NavItemBean {
	private String formName;
	private String formCode;
	private String iconName;
	private String formUrl;
	private List<NavItemBean> subMenuList;
	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}
	public String getFormCode() {
		return formCode;
	}
	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}
	public String getIconName() {
		return iconName;
	}
	public void setIconName(String iconName) {
		this.iconName = iconName;
	}
	public String getFormUrl() {
		return formUrl;
	}
	public void setFormUrl(String formUrl) {
		this.formUrl = formUrl;
	}
	public List<NavItemBean> getSubMenuList() {
		return subMenuList;
	}
	public void setSubMenuList(List<NavItemBean> subMenuList) {
		this.subMenuList = subMenuList;
	}
	
	
}
