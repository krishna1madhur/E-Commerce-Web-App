package com.ecommerce.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import com.ecommerce.dao.OrderDAO;
import com.ecommerce.dao.EcommerceDAOException;
import com.ecommerce.dao.ProductDAO;
import com.ecommerce.dao.UserDAO;
import com.ecommerce.dbcon.DBConnectionException;
import com.ecommerce.dbfw.DBFWException;
import com.ecommerce.domain.Cart;
import com.ecommerce.domain.Customer;

public class EcommerceFacade {


	public static boolean validateUser(String userId, String password)
			throws EcommerceException, DBFWException {
		boolean isValid = false;
		try {
			isValid = UserDAO.validateUser(userId, password);
			
		} catch (EcommerceDAOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			throw new EcommerceException(e.getMessage());
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return isValid;
	}

	public static boolean registerUser(Customer customerObject)
			throws EcommerceException {
		boolean isValid = false;
		int value = 0;
		try {
			value = UserDAO.registerUser(customerObject);
			
		} catch (EcommerceDAOException e) {

			e.printStackTrace();
			
			throw new EcommerceException(e.getMessage());
		} catch (DBConnectionException e) {

			e.printStackTrace();
			
			throw new EcommerceException(e.getMessage());
		} catch (SQLException e) {

			e.printStackTrace();
			
			throw new EcommerceException(e.getMessage());
		} catch (IOException e) {

			e.printStackTrace();
			
			throw new EcommerceException(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
			throw new EcommerceException(e.getMessage());
		}
		if (value > 0) {
			isValid = true;
		}
		return isValid;
	}

	public static List<Object> getCategories() throws EcommerceDAOException,
			DBConnectionException {
		List<Object> category = null;

		category = ProductDAO.getCategories();

		return category;
	}

	public static List<Object> getCatById(final int categId)
			throws EcommerceDAOException, DBConnectionException {
		List<Object> categByID = null;

		categByID = ProductDAO.getCatById(categId);

		return categByID;
	}

	public static List<Object> getProductList(final int categId)
			throws EcommerceDAOException, DBConnectionException {
		List<Object> prodList = null;

		prodList = ProductDAO.getProductList(categId);

		return prodList;
	}

	// Get Details of Product from categID,productId.
	public static List<Object> getProduct(final int categId, final int productId)
			throws EcommerceDAOException, DBConnectionException {
		List<Object> prodByID = null;

		prodByID = ProductDAO.getProduct(categId, productId);

		return prodByID;

	}

	// Get Details of Item from categID,productId,itemId.
	public static List<Object> getItem(final int categId, final int productId,
			final int itemId) throws EcommerceDAOException,
			DBConnectionException {
		List<Object> itemByID = null;
		itemByID = ProductDAO.getItem(categId, productId, itemId);
		return itemByID;
	}

	// To Place Order and Insert into Purchase_Detail Table.
	public static Integer placeOrder(Cart shoppingCart, int orderId)
			throws EcommerceDAOException, FileNotFoundException, IOException,
			ClassNotFoundException, DBConnectionException {
		int count = 0;
		count = OrderDAO.placeOrder(shoppingCart, orderId);
		
		return count;
	}

	// To Return Purchase Details by OrderID
	public static Cart getPurchaseDetails(final int orderId)
			throws EcommerceDAOException, DBConnectionException {
		Cart cartObject = null;
		cartObject = OrderDAO.getPurchaseDetails(orderId);
		return cartObject;
	}

	// Generate order ID
	public static int generateOrderId() throws IOException,
			ClassNotFoundException, DBConnectionException, EcommerceException {
		int orderid = 0;
		try {
			orderid = OrderDAO.generateOrderId();
		} catch (EcommerceDAOException e) {
			
			throw new EcommerceException(e.getMessage());
		}
		return orderid;
	}

	public static List<Object> getOrderbyID(final int orderid)
			throws DBConnectionException, EcommerceDAOException {
		List<Object> listOrd = null;
		listOrd = OrderDAO.getOrderbyID(orderid);
		return listOrd;
	}

	public static List<Object> getItemList(final int categId,
			final int productId) throws EcommerceDAOException,
			DBConnectionException {
		List<Object> itemList = null;
		itemList = ProductDAO.getItemList(categId, productId);
		return itemList;
	}
}
