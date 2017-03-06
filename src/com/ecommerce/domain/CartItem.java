package com.ecommerce.domain;

import java.io.Serializable;

public class CartItem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -403926649953316808L;
	private Item item;
	private int quantity;

	public CartItem(Item item, int quantity) {
		super();
		this.item = item;
		this.quantity = quantity;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return this.item + " " + this.quantity;
	}

}
