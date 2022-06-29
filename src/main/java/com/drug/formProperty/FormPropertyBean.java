package com.drug.formProperty;

import java.util.List;

public class FormPropertyBean {
	
	private String form_code;
	private String formname;
	private String formcodeparent;
	private String formurl;
	private String displayorder;
	private String menuorder;
	private String iconName;
	private List<FormPropertyBean> subMenuList;
	
	
	
	public String getIconName() {
		return iconName;
	}
	public void setIconName(String iconName) {
		this.iconName = iconName;
	}
	public List<FormPropertyBean> getSubMenuList() {
		return subMenuList;
	}
	public void setSubMenuList(List<FormPropertyBean> subMenuList) {
		this.subMenuList = subMenuList;
	}
	public String getForm_code() {
		return form_code;
	}
	public void setForm_code(String form_code) {
		this.form_code = form_code;
	}
	public String getFormname() {
		return formname;
	}
	public void setFormname(String formname) {
		this.formname = formname;
	}
	public String getFormcodeparent() {
		return formcodeparent;
	}
	public void setFormcodeparent(String formcodeparent) {
		this.formcodeparent = formcodeparent;
	}
	public String getFormurl() {
		return formurl;
	}
	public void setFormurl(String formurl) {
		this.formurl = formurl;
	}
	public String getDisplayorder() {
		return displayorder;
	}
	public void setDisplayorder(String displayorder) {
		this.displayorder = displayorder;
	}
	public String getMenuorder() {
		return menuorder;
	}
	public void setMenuorder(String menuorder) {
		this.menuorder = menuorder;
	}
	
	
	
}
