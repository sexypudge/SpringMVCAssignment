package com.nissho.vn.model;

public class Product {
	private String productCode;
	private String productName;
	private String ctgCode;
	private String salesStartDate;
	private int salesPrice;
	private int costPrice;
	private int discountLimit;
	
	public Product() {
		super();
	}

	public Product(String productCode, String productName, String ctgCode, String salesStartDate, int salesPrice,
			int costPrice, int discountLimit) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.ctgCode = ctgCode;
		this.salesStartDate = salesStartDate;
		this.salesPrice = salesPrice;
		this.costPrice = costPrice;
		this.discountLimit = discountLimit;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCtgCode() {
		return ctgCode;
	}

	public void setCtgCode(String ctgCode) {
		this.ctgCode = ctgCode;
	}

	public String getSalesStartDate() {
		return salesStartDate;
	}

	public void setSalesStartDate(String salesStartDate) {
		this.salesStartDate = salesStartDate;
	}

	public int getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(int salesPrice) {
		this.salesPrice = salesPrice;
	}

	public int getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(int costPrice) {
		this.costPrice = costPrice;
	}

	public int getDiscountLimit() {
		return discountLimit;
	}

	public void setDiscountLimit(int discountLimit) {
		this.discountLimit = discountLimit;
	}

	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName + ", ctgCode=" + ctgCode
				+ ", salesStartDate=" + salesStartDate + ", salesPrice=" + salesPrice + ", costPrice=" + costPrice
				+ ", discountLimit=" + discountLimit + "]";
	}
	
}
