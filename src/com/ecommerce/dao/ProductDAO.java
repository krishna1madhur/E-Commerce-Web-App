package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


import com.ecommerce.dbcon.ConnectionHolder;
import com.ecommerce.dbcon.DBConnectionException;
import com.ecommerce.dbfw.DBFWException;
import com.ecommerce.dbfw.DBHelper;
import com.ecommerce.dbfw.ParamMapper;

public class ProductDAO {


	// Get List of Categories.
	public static List<Object> getCategories() throws EcommerceDAOException,
			DBConnectionException {
		List<Object> categList;
		ConnectionHolder connhldr = null;
		Connection con = null;
		try {
			connhldr = ConnectionHolder.getInstance();
			con = connhldr.getConnection();
			categList = DBHelper.executeSelect(con, SqlMapper.GETALLCATEG,
					SqlMapper.CATEG_OBJECT);
		} catch (DBConnectionException e) {
			
			throw new EcommerceDAOException(e.getMessage());
		} catch (DBFWException e) {
			
			throw new EcommerceDAOException(e.getMessage());
		} finally {
			try {
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				
			}
		}
		return categList;
	}

	// Get Details of Category from categID.
	public static List<Object> getCatById(final int categId)
			throws EcommerceDAOException, DBConnectionException {
		List<Object> categByID;
		ConnectionHolder connhldr = null;
		Connection con = null;
		final ParamMapper MAP_ID = new ParamMapper() {
			@Override
			public void mapParams(final PreparedStatement pstmt)
					throws SQLException {
				pstmt.setInt(1, categId);
			}
		};
		try {
			connhldr = ConnectionHolder.getInstance();
			con = connhldr.getConnection();
			categByID = DBHelper.executeSelect(con, SqlMapper.CATEGBYID,
					SqlMapper.CATEG_OBJECT, MAP_ID);
		} catch (DBConnectionException e) {
			
			throw new EcommerceDAOException(e.getMessage());
		} catch (DBFWException e) {
			
			throw new EcommerceDAOException(e.getMessage());
		} finally {
			try {
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				
			}
		}
		return categByID;
	}

	// Get List of Products by CategID.
	public static List<Object> getProductList(final int categId)
			throws EcommerceDAOException, DBConnectionException {
		List<Object> prodList;
		ConnectionHolder connhlder = null;
		Connection con = null;
		final ParamMapper MAP_ID = new ParamMapper() {
			@Override
			public void mapParams(final PreparedStatement pstmt)
					throws SQLException {
				pstmt.setInt(1, categId);
			}
		};
		try {
			connhlder = ConnectionHolder.getInstance();
			con = connhlder.getConnection();
			prodList = DBHelper.executeSelect(con, SqlMapper.GETALLPROD,
					SqlMapper.PROD_OBJECT, MAP_ID);
		} catch (DBConnectionException e) {
			
			throw new EcommerceDAOException(e.getMessage());
		} catch (DBFWException e) {
			
			throw new EcommerceDAOException(e.getMessage());
		} finally {
			try {
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				
			}
		}
		return prodList;
	}

	// Get Details of Product from categID,productId.
	public static List<Object> getProduct(final int categId, final int productId)
			throws EcommerceDAOException, DBConnectionException {
		List<Object> prodByID;
		ConnectionHolder connhldr = null;
		Connection con = null;
		final ParamMapper MAP_ID = new ParamMapper() {
			@Override
			public void mapParams(final PreparedStatement pstmt)
					throws SQLException {
				pstmt.setInt(1, categId);
				pstmt.setInt(2, productId);
			}
		};
		try {
			connhldr = ConnectionHolder.getInstance();
			con = connhldr.getConnection();
			prodByID = DBHelper.executeSelect(con, SqlMapper.PRODBYID,
					SqlMapper.PROD_OBJ, MAP_ID);
		} catch (DBConnectionException e) {
			
			throw new EcommerceDAOException(e.getMessage());
		} catch (DBFWException e) {
			
			throw new EcommerceDAOException(e.getMessage());
		} finally {
			try {
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				
			}
		}
		return prodByID;
	}

	// Get Item List Based on categId and ProductID.
	public static List<Object> getItemList(final int categId,
			final int productId) throws EcommerceDAOException,
			DBConnectionException {
		List<Object> itemList;
		ConnectionHolder connhldr = null;
		Connection con = null;
		final ParamMapper MAP_ID = new ParamMapper() {
			@Override
			public void mapParams(final PreparedStatement pstmt)
					throws SQLException {
				pstmt.setInt(1, categId);
				pstmt.setInt(2, productId);
			}
		};
		try {
			connhldr = ConnectionHolder.getInstance();
			con = connhldr.getConnection();
			itemList = DBHelper.executeSelect(con, SqlMapper.GETALLITEMS,
					SqlMapper.ITEM_OBJECT, MAP_ID);
		} catch (DBConnectionException e) {
			
			throw new EcommerceDAOException(e.getMessage());
		} catch (DBFWException e) {
			
			throw new EcommerceDAOException(e.getMessage());
		} finally {
			try {
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				
			}
		}
		return itemList;
	}

	// Get Details of Item from categID,productId,itemId.
	public static List<Object> getItem(final int categId, final int productId,
			final int itemId) throws EcommerceDAOException,
			DBConnectionException {
		List<Object> itemByID;
		ConnectionHolder connhldr = null;
		Connection con = null;
		final ParamMapper MAP_ID = new ParamMapper() {
			@Override
			public void mapParams(final PreparedStatement pstmt)
					throws SQLException {
				pstmt.setInt(1, categId);
				pstmt.setInt(2, productId);
				pstmt.setInt(3, itemId);
			}
		};
		try {
			connhldr = ConnectionHolder.getInstance();
			con = connhldr.getConnection();
			itemByID = DBHelper.executeSelect(con, SqlMapper.ITEMBYID,
					SqlMapper.ITEM_OBJ, MAP_ID);
		} catch (DBConnectionException e) {
			
			throw new EcommerceDAOException(e.getMessage());
		} catch (DBFWException e) {
			
			throw new EcommerceDAOException(e.getMessage());
		} finally {
			try {
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				
			}
		}
		return itemByID;
	}

}
