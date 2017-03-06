package com.ecommerce.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;


import com.ecommerce.dbcon.ConnectionHolder;
import com.ecommerce.dbcon.DBConnectionException;
import com.ecommerce.dbfw.DBFWException;
import com.ecommerce.dbfw.DBHelper;
import com.ecommerce.dbfw.ParamMapper;
import com.ecommerce.domain.Customer;

public class UserDAO {


	// Validating User

	public static boolean validateUser(final String userId,
			final String password) throws EcommerceDAOException,
			DBConnectionException {
		boolean isSuccess = false;
		Customer details = null;

		List<Object> validate = null;
		Iterator<Object> iterate = null;
		Connection con = null;
		ConnectionHolder holder = null;
		ParamMapper parmap = new ParamMapper() {
			public void mapParams(PreparedStatement prestmt)
					throws SQLException {
				prestmt.setString(1, userId);
				prestmt.setString(2, password);
			}

		};

		try {
			holder = ConnectionHolder.getInstance();
			con = holder.getConnection();
			validate = DBHelper.executeSelect(con, SqlMapper.VALIDUSER,
					SqlMapper.USER_OBJECT, parmap);

			iterate = validate.iterator();
			while (iterate.hasNext()) {
				details = (Customer) iterate.next();

			}
			if (details != null) {
				isSuccess = true;
			}
		} catch (DBFWException e) {
			
			throw new EcommerceDAOException(e.getMessage());
		} catch (DBConnectionException e) {
			
			throw new EcommerceDAOException(e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();

			} catch (SQLException e) {
				
			}
		}

		return isSuccess;
	}

	// Creating a New User.
	public static int registerUser(final Customer customerObject)
			throws EcommerceDAOException, DBConnectionException, SQLException,
			IOException, ClassNotFoundException {
		ConnectionHolder ch = null;
		Connection con = null;
		int count = 0;
		ParamMapper MAP_ID = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			con.setAutoCommit(false);
			MAP_ID = new ParamMapper() {

				@Override
				public void mapParams(PreparedStatement ps) throws SQLException {
					ps.setString(1, customerObject.getCustid());
					ps.setString(2, customerObject.getPassword());
					
				}
			};
			try {
				count = DBHelper.executeUpdate(con, SqlMapper.INSERTUSER,
						MAP_ID);
			} catch (Exception e) {
				
				count = 0;
				con.rollback();
				throw new EcommerceDAOException(
						"User Already Exists, Please Enter new UserID. ");
			}
			if (count == 1) {
				MAP_ID = new ParamMapper() {

					@Override
					public void mapParams(PreparedStatement ps)
							throws SQLException {
						ps.setLong(1, customerObject.getCreditCardno());
						ps.setString(2, customerObject.getCardType());
						ps.setString(3, customerObject.getCardExpiryDate());
					}
				};
				try {
					count = DBHelper.executeUpdate(con, SqlMapper.INSERTCCINFO,
							MAP_ID);
				} catch (Exception e) {
					
					count = 0;
					con.rollback();
					throw new EcommerceDAOException(
							"UserID Already Exists, Please Enter new UserID. ");

				}
			}
			if (count == 1) {
				MAP_ID = new ParamMapper() {

					@Override
					public void mapParams(PreparedStatement ps)
							throws SQLException {
						ps.setString(1, customerObject.getCustid());
						ps.setString(2, customerObject.getFirstName());
						ps.setString(3, customerObject.getLastName());
						ps.setString(4, customerObject.getDateOfBirth());
						ps.setString(5, customerObject.getAddress());
						ps.setLong(6, customerObject.getContactNumber());
						ps.setLong(7, customerObject.getCreditCardno());
					}
				};
				try {
					count = DBHelper.executeUpdate(con, SqlMapper.INSERTCUST,
							MAP_ID);
				} catch (Exception e) {
					
					count = 0;
					con.rollback();
					throw new EcommerceDAOException(
							"User Already Exists, Please Enter new UserID. ");

				}
				if (count == 1)
					con.commit();
				else
					con.rollback();
			}
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
}
