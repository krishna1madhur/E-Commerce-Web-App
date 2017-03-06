package com.ecommerce.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable {

	private static final long serialVersionUID = -8449017146598680866L;
	private int orderId;
	private String custId;
	private static ArrayList<CartItem> itemDetails = new ArrayList<CartItem>();
	public static CartItem cartitem;
	

	public Cart() {
		super();
	}

	public static ArrayList<CartItem> addCartItem(Item obj, int qty) {
		CartItem cartitem = new CartItem(obj, qty);
		itemDetails.add(cartitem);
		return itemDetails;
	}

	public Cart(Item item, int quantity, int orderId, String custId,
			ArrayList<CartItem> itemDetails) {
		super();
		this.orderId = orderId;
		this.custId = custId;
		Cart.itemDetails = itemDetails;
	}

	public Cart(String custId, ArrayList<CartItem> itemDetails) {
		super();
		this.custId = custId;
		Cart.itemDetails = itemDetails;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public ArrayList<CartItem> getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(ArrayList<CartItem> itemDetails) {
		Cart.itemDetails = itemDetails;
	}

}
