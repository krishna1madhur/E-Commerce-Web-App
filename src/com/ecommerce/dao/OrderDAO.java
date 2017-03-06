package com.ecommerce.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import com.ecommerce.dbcon.ConnectionHolder;
import com.ecommerce.dbcon.DBConnectionException;
import com.ecommerce.dbfw.DBFWException;
import com.ecommerce.dbfw.DBHelper;
import com.ecommerce.dbfw.ParamMapper;
import com.ecommerce.domain.Cart;

public class OrderDAO {


	// To Place Order and Insert into Purchase_Detail Table.
	public static Integer placeOrder(Cart shoppingCart, int orderId)
			throws EcommerceDAOException, FileNotFoundException, IOException,
			ClassNotFoundException, DBConnectionException {
		int count = 0;
		final Integer orderID;
		final String custId = shoppingCart.getCustId();
		
		if (orderId == 0) {
			orderID = Integer.valueOf(generateOrderId());
		} else {
			orderID = orderId;
		}
		
		final int itemId = Cart.cartitem.getItem().getItemId();
		
		final int prodId = Cart.cartitem.getItem().getProductId();
		
		final int categId = Cart.cartitem.getItem().getCategoryId();
		
		final int quant = Cart.cartitem.getQuantity();
		
		ConnectionHolder ch = null;
		Connection con = null;
		ParamMapper MAP_ID = new ParamMapper() {
			@Override
			public void mapParams(PreparedStatement ps) throws SQLException {
				ps.setInt(1, orderID);
				ps.setString(2, custId);
				ps.setInt(3, itemId);
				ps.setInt(4, prodId);
				ps.setInt(5, categId);
				ps.setInt(6, quant);
			}
		};
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			try {
				count = DBHelper.executeUpdate(con, SqlMapper.INSERTPURDET,
						MAP_ID);
				
			} catch (Exception e) {
				

				return 0;
			}
		} catch (DBConnectionException e) {
			
			throw new EcommerceDAOException(e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();

			} catch (SQLException e) {
			}
		}
		return count;
	}

	// To Return Purchase Details by OrderID
	public static Cart getPurchaseDetails(final int orderId)
			throws EcommerceDAOException, DBConnectionException {
		Cart cartObject = null;
		List<Object> listcart;
		ConnectionHolder ch = null;
		Connection con = null;
		ParamMapper MAP_ID = new ParamMapper() {
			@Override
			public void mapParams(PreparedStatement ps) throws SQLException {
				ps.setInt(1, orderId);
			}
		};
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			listcart = DBHelper.executeSelect(con, SqlMapper.PURDETBYID,
					SqlMapper.PURDET_OBJ, MAP_ID);
			cartObject = (Cart) listcart.get(0);
		} catch (DBConnectionException e) {
			
			throw new EcommerceDAOException(e.getMessage());
		} catch (DBFWException e) {
			
			throw new EcommerceDAOException(e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();

			} catch (SQLException e) {
				
			}
		}
		return cartObject;
	}

	public static int generateOrderId() throws IOException,
			ClassNotFoundException, DBConnectionException, EcommerceDAOException {
		int orderid = 0;
		ConnectionHolder ch = null;
		Connection con = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			PreparedStatement pstmt = con
					.prepareStatement("select orderid_18300.nextval from dual");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				orderid = rs.getInt(1);
			}

		} catch (SQLException e) {
			
			throw new EcommerceDAOException(e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();

			} catch (SQLException e) {
				
			}
		}
		return orderid;
	}

	public static List<Object> getOrderbyID(final int orderid)
			throws DBConnectionException, EcommerceDAOException {
		ConnectionHolder ch = null;
		Connection con = null;
		List<Object> listord = null;
		ParamMapper MAP_ID = new ParamMapper() {
			@Override
			public void mapParams(PreparedStatement ps) throws SQLException {
				ps.setInt(1, orderid);
			}
		};
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			listord = DBHelper.executeSelect(con, SqlMapper.TestORD,
					SqlMapper.TestORD_OBJ, MAP_ID);
		} catch (DBFWException e) {
			
			throw new EcommerceDAOException(e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();

			} catch (SQLException e) {
				
			}
		}
		return listord;
	}

}
