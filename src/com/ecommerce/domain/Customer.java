package com.ecommerce.domain;

import java.io.Serializable;

public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8387769700830577869L;
	private String customerID;
	private String password;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String address;
	private long contactNumber;
	private long creditCardno;
	private String cardType;
	private String cardExpiryDate;

	public Customer(String custid, String password, String firstName,
			String lastName, String dateOfBirth, String address,
			long contactNumber, long creditCardno, String cardType,
			String cardExpiryDate) {
		super();
		this.customerID = custid;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.contactNumber = contactNumber;
		this.creditCardno = creditCardno;
		this.cardType = cardType;
		this.cardExpiryDate = cardExpiryDate;
	}

	public Customer(String customerId, String password) {
		super();
		this.customerID = customerId;
		this.password = password;
	}

	public String getCustid() {
		return customerID;
	}

	public void setCustid(String custid) {
		this.customerID = custid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public long getCreditCardno() {
		return creditCardno;
	}

	public void setCreditCardno(int creditCardno) {
		this.creditCardno = creditCardno;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardExpiryDate() {
		return cardExpiryDate;
	}

	public void setCardExpiryDate(String cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}

}
