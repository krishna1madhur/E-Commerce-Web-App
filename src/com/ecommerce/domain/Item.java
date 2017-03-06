package com.ecommerce.domain;

import java.io.Serializable;

public class Item implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4607409733831343817L;
	private int itemId;
	private int productId;
	private int categoryId;
	private String itemName;
	private String itemDescription;
	private int itemPrice;

	public Item(int itemId, int productId, int categoryId, String itemName,
			String itemDescription, int itemPrice) {
		super();
		this.itemId = itemId;
		this.productId = productId;
		this.categoryId = categoryId;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemPrice = itemPrice;
	}

	public Item(int itemId, int productId, int categoryId) {
		super();
		this.itemId = itemId;
		this.productId = productId;
		this.categoryId = categoryId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
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

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return this.productId + " " + this.categoryId + " " + this.itemId + " "
				+ this.itemName + " " + this.itemPrice + " "
				+ this.itemDescription + "\n";
	}
}
