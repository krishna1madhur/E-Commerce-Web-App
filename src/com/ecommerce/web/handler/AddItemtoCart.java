package com.ecommerce.web.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.ecommerce.mvc.HttpRequestHandler;
import com.ecommerce.dao.EcommerceDAOException;
import com.ecommerce.dbcon.DBConnectionException;
import com.ecommerce.domain.Cart;
import com.ecommerce.domain.Customer;
import com.ecommerce.domain.Item;
import com.ecommerce.service.EcommerceException;
import com.ecommerce.service.EcommerceFacade;

public class AddItemtoCart implements HttpRequestHandler {



	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatch = null;
		HttpSession session = request.getSession(true);
		Customer cust = null;
		int categId = Integer.parseInt(request.getParameter("text_categoryId"));
		int productId = Integer
				.parseInt(request.getParameter("text_productId"));
		int itemId = Integer.parseInt(request.getParameter("text_itemId"));
		int quantity = Integer.parseInt(request.getParameter("text_quantity"));
		String itemName = null;
		int itemPrice = 0;
		int totalPrice = 0;
		int orderId = 0;
		int insert = 0;
		String cust_id1 = null;

		Iterator<Object> iterate = null;
		List<Object> itemList = null;
		// List<Item> item = null;
		Item handler_itemObj = null;
		Item itemObj = null;

		try {
			itemList = EcommerceFacade.getItem(categId, productId, itemId);
			session.setAttribute("itemList", itemList);
			iterate = itemList.iterator();
			cust_id1 = request.getParameter("cust_id1").toString();
			while (iterate.hasNext()) {
				itemObj = (Item) iterate.next();

				// List<Item> next = (List<Item>) iterate.next();
				// item = next;
			}

			// itemName = item.get(0).getItemName();
			// request.setAttribute("itemName", itemName);

			// itemPrice = (int) item.get(0).getItemPrice();

			itemPrice = (int) itemObj.getItemPrice();
			itemName = (String) itemObj.getItemName();
			session.setAttribute("cust_id1", cust_id1);
			session.setAttribute("itemPrice", itemPrice);
			session.setAttribute("quantity", quantity);
			session.setAttribute("itemId", itemId);
			session.setAttribute("categId", categId);
			session.setAttribute("prodId", productId);
			session.setAttribute("itemName", itemName);
			// custId = cust.getCustid();

			// Starting Adding to Cart.
			handler_itemObj = (Item) itemList.get(0);
			ArrayList handlerT = Cart.addCartItem(itemObj, quantity);
			// Cart shoppingCart = new Cart((String) session
			// .getAttribute("custid"), handlerT);

			Cart shoppingCart = new Cart(cust_id1, handlerT);

			if (session.getAttribute("orderid") == null) {
				orderId = EcommerceFacade.generateOrderId();
				session.setAttribute("orderid", orderId);
			}

			// Insert the records into the Purchase Details Table
			insert = EcommerceFacade.placeOrder(shoppingCart, orderId);

			if (insert > 0) {
				if (session.getAttribute("totalPrice") == null) {
					totalPrice = quantity * itemPrice;
					session.setAttribute("orderid", orderId);
					session.setAttribute("totalPrice", totalPrice);

				} else {
					session.setAttribute("totalPrice", totalPrice
							+ (quantity * itemPrice));

				}
			}

			dispatch = request.getRequestDispatcher("PurchaseSummary.jsp");
			dispatch.forward(request, response);

		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (EcommerceDAOException e) {
			
			e.printStackTrace();
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (EcommerceException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}

	}
}
