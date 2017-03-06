package com.ecommerce.domain;

import java.io.Serializable;

public class Category implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2626872206571297877L;
	private int categoryId;
	private String categoryName;
	private String categoryDescription;

	public Category(int categoryId, String categoryName,
			String categoryDescription) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	@Override
	public String toString() {
		return this.categoryId + " " + this.categoryName + " "
				+ this.categoryDescription + "\n";
	}

}
