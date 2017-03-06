package com.ecommerce.domain;

import java.io.Serializable;

public class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7049694254205179360L;
	private int orderId;
	private String customerId;
	private int itemId;
	private int productId;
	private int categoryId;
	private int quantity;

	public Order(int orderid, String custid, int itemid, int prodid,
			int categid, int quantity) {
		super();
		this.orderId = orderid;
		this.customerId = custid;
		this.itemId = itemid;
		this.productId = prodid;
		this.categoryId = categid;
		this.quantity = quantity;
	}

	public int getOrderid() {
		return orderId;
	}

	public void setOrderid(int orderid) {
		this.orderId = orderid;
	}

	public String getCustid() {
		return customerId;
	}

	public void setCustid(String custid) {
		this.customerId = custid;
	}

	public int getItemid() {
		return itemId;
	}

	public void setItemid(int itemid) {
		this.itemId = itemid;
	}

	public int getProdid() {
		return productId;
	}

	public void setProdid(int prodid) {
		this.productId = prodid;
	}

	public int getCategid() {
		return categoryId;
	}

	public void setCategid(int categid) {
		this.categoryId = categid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return this.orderId + " " + this.productId + " " + this.categoryId + " "
				+ this.quantity + " " + this.customerId + "\n";
	}
}
