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
import com.ecommerce.domain.Product;
import com.ecommerce.service.EcommerceFacade;

public class ProductDescription implements HttpRequestHandler {



	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatch = null;
		HttpSession session = request.getSession(true);
		int categId = Integer.parseInt(request.getParameter("text_categoryId"));
		String userIdN = null;

		
		List<Object> categList = null;
		List<Object> prodList = null;

		Product product = null;
		Iterator<Object> iterate = null;

		try {
			categList = EcommerceFacade.getCatById(categId);

			prodList = EcommerceFacade.getProductList(categId);
			userIdN = (String) request.getParameter("user_name");
			
			iterate = prodList.iterator();
			while (iterate.hasNext()) {
				product = (Product) iterate.next();
				
						
			}
			dispatch = request.getRequestDispatcher("ProductDescription.jsp");
			session.setAttribute("userIdN", userIdN);
			session.setAttribute("categList", categList);
			session.setAttribute("prodList", prodList);
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
