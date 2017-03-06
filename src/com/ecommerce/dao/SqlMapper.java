package com.ecommerce.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecommerce.dbfw.ResultMapper;
import com.ecommerce.domain.Cart;
import com.ecommerce.domain.Category;
import com.ecommerce.domain.Customer;
import com.ecommerce.domain.Item;
import com.ecommerce.domain.Order;
import com.ecommerce.domain.Product;

public class SqlMapper {

	// User Login Validation
	public static String VALIDUSER = "select * from user_18300 where custid =  ? and password = ?";
	public static ResultMapper USER_OBJECT = new ResultMapper() {
		public Object mapRow(ResultSet rs) throws SQLException {
			String custId = rs.getString(1);
			String password = rs.getString(2);
			Customer customer = new Customer(custId, password);
			return customer;
			// return new Customer(rs.getString(1), rs.getString(2));
		}
	};

	// Get OrderID from Sequence
	public static String GETORDERSEQ = "selct orderid_18300.nextval from dual";
	public static ResultMapper OREDERID_OBJ = new ResultMapper() {
		public Object mapRow(ResultSet rs) throws SQLException {
			int orederId = rs.getInt(1);
			return orederId;
		}
	};

	// To Get List of Categories
	public static String GETALLCATEG = "select * from categories_18300";
	public static ResultMapper CATEG_OBJECT = new ResultMapper() {
		public Object mapRow(ResultSet rs) throws SQLException {
			int categId = rs.getInt(1);
			String name = rs.getString(2);
			String desc = rs.getString(3);
			Category categ = new Category(categId, name, desc);
			return categ;
		}
	};

	// To get list of products
	public static String GETALLPROD = "select * from category_products_18300 where categid = ?";
	public static ResultMapper PROD_OBJECT = new ResultMapper() {
		public Object mapRow(ResultSet rs) throws SQLException {
			int prodId = rs.getInt(1);
			int categId = rs.getInt(2);
			String name = rs.getString(3);
			String desc = rs.getString(4);
			Product prod = new Product(prodId, categId, name, desc);
			return prod;
		}
	};

	// To get list of items
	public static String GETALLITEMS = "select * from product_line_items_18300 where categid = ? and prodid = ?";
	public static ResultMapper ITEM_OBJECT = new ResultMapper() {
		public Object mapRow(ResultSet rs) throws SQLException {
			int itemId = rs.getInt(1);
			int prodId = rs.getInt(2);
			int categId = rs.getInt(3);
			String name = rs.getString(4);
			String desc = rs.getString(5);
			int price = rs.getInt(6);
			Item item = new Item(itemId, prodId, categId, name, desc, price);
			return item;
		}
	};

	// get category details by categ id
	public static String CATEGBYID = "select * from categories_18300 where categid = ?";
	public static ResultMapper CATEG_OBJ = new ResultMapper() {
		public Object mapRow(ResultSet rs) throws SQLException {
			int categId = rs.getInt(1);
			String categName = rs.getString(2);
			String categDesc = rs.getString(3);
			Category catg = new Category(categId, categName, categDesc);
			return catg;
		}
	};

	// Get product details by category id and product id
	public static String PRODBYID = "select * from category_products_18300 where categid = ? and prodid = ?";
	public static ResultMapper PROD_OBJ = new ResultMapper() {
		public Object mapRow(ResultSet rs) throws SQLException {
			int prodId = rs.getInt(1);
			int catId = rs.getInt(2);
			String prodDesc = rs.getString(3);
			String prodName = rs.getString(4);
			Product product = new Product(prodId, catId, prodDesc, prodName);
			return product;
		}
	};

	// Get item details by category id, item id and product id
	public static String ITEMBYID = "select * from product_line_items_18300 where categid = ? and prodid = ? and itemid = ?";
	public static ResultMapper ITEM_OBJ = new ResultMapper() {
		public Object mapRow(ResultSet rs) throws SQLException {
			int itemId = rs.getInt(1);
			int prodId = rs.getInt(2);
			int catgId = rs.getInt(3);
			String itemName = rs.getString(4);
			String itemDesc = rs.getString(5);
			int price = rs.getInt(6);
			Item item = new Item(itemId, prodId, catgId, itemName, itemDesc,
					price);
			return item;

		}
	};

	// Get purchase details by Order id
	public static String PURDETBYID = "select * from purchase_detail_18300 where orderid = ? ";
	public static ResultMapper PURDET_OBJ = new ResultMapper() {
		public Object mapRow(ResultSet rs) throws SQLException {
			int orderId = rs.getInt(1);
			String custId = rs.getString(2);
			int itemId = rs.getInt(3);
			int prodId = rs.getInt(4);
			int catgId = rs.getInt(5);
			int qnt = rs.getInt(6);
			Item item = new Item(itemId, prodId, catgId);
			Cart cart = new Cart(item, qnt, orderId, custId, Cart.addCartItem(
					item, qnt));
			return cart;
		}
	};

	//
	public static String TestORD = "select * from purchase_detail_18300 where orderid = ? ";
	public static ResultMapper TestORD_OBJ = new ResultMapper() {
		public Object mapRow(ResultSet rs) throws SQLException {
			int orderid = rs.getInt(1);
			String custid = rs.getString(2);
			int itemid = rs.getInt(3);
			int prodid = rs.getInt(4);
			int catid = rs.getInt(5);
			int quant = rs.getInt(6);
			Order ord = new Order(orderid, custid, itemid, prodid,
					catid, quant);
			return ord;
		}
	};

	public static String INSERTCCINFO = "insert into creditcard_info_18300 values(?,?,?)";
	public static String INSERTCUST = "insert into customer_18300 values(?,?,?,?,?,?,?)";
	public static String INSERTUSER = "insert into user_18300 values(?,?)";
	public static String INSERTPURDET = "insert into purchase_detail_18300 values(?,?,?,?,?,?)";
}
