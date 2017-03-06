package com.ecommerce.domain;

import java.io.Serializable;

public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 621524888149055270L;
	private int productId;
	private int categoryId;
	private String productName;
	private String productDescription;

	public Product(int productId, int categoryId, String productName,
			String productDescription) {
		super();
		this.productId = productId;
		this.categoryId = categoryId;
		this.productName = productName;
		this.productDescription = productDescription;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	@Override
	public String toString() {
		return this.productId + " " + this.categoryId + " " + this.productName
				+ " " + this.productDescription + "\n";
	}

}
