package com.nissho.vn.model;

public class Category {
	private String ctgCode;
	private String ctgName;

	public Category() {
		super();
	}

	public Category(String ctgCode, String ctgName) {
		super();
		this.ctgCode = ctgCode;
		this.ctgName = ctgName;
	}

	public String getCtgCode() {
		return ctgCode;
	}

	public void setCtgCode(String ctgCode) {
		this.ctgCode = ctgCode;
	}

	public String getCtgName() {
		return ctgName;
	}

	public void setCtgName(String ctgName) {
		this.ctgName = ctgName;
	}

	@Override
	public String toString() {
		return ctgName;
	}
	
	
}
