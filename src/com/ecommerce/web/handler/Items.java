package com.ecommerce.web.handler;

import java.io.IOException;
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
import com.ecommerce.domain.Item;
import com.ecommerce.domain.Product;
import com.ecommerce.service.EcommerceFacade;

public class Items implements HttpRequestHandler {



	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatch = null;
		HttpSession session = request.getSession(true);
		int categId = Integer.parseInt(request.getParameter("text_categoryId"));
		int productId = Integer
				.parseInt(request.getParameter("text_productId"));
		String userId = request.getParameter("cust_id").toString();
		
		List<Object> categList = null;
		List<Object> prodList1 = null;
		List<Object> itemList = null;
		Product product = null;
		Item item = null;
		Iterator<Object> iterate = null;
		try {
			categList = EcommerceFacade.getCatById(categId);
			prodList1 = EcommerceFacade.getProduct(categId, productId);
			iterate = prodList1.iterator();
			while (iterate.hasNext()) {
				product = (Product) iterate.next();
				
			}

			itemList = EcommerceFacade.getItemList(categId, productId);
			iterate = itemList.iterator();
			while (iterate.hasNext()) {
				item = (Item) iterate.next();
				
			}

			dispatch = request.getRequestDispatcher("Items.jsp");
			session.setAttribute("categList", categList);
			session.setAttribute("prodList1", prodList1);
			session.setAttribute("itemList", itemList);
			session.setAttribute("userId", userId);
			dispatch.forward(request, response);
		} catch (EcommerceDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
