package com.ecommerce.web.handler;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.dao.EcommerceDAOException;
import com.ecommerce.dbcon.DBConnectionException;
import com.ecommerce.dbfw.DBFWException;
import com.ecommerce.mvc.HttpRequestHandler;
import com.ecommerce.service.EcommerceException;
import com.ecommerce.service.EcommerceFacade;

public class ValidateUser implements HttpRequestHandler {



	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatch = null;
		HttpSession session = request.getSession(true);
		String userName = request.getParameter("text_userName");
		String password = request.getParameter("password_password");
		List<Object> categList = null;
		// Customer cust = null;

		try {
			boolean isSuccess = EcommerceFacade.validateUser(userName, password);

			if (isSuccess == true) {
				categList = EcommerceFacade.getCategories();
				// cust.setCustid(userName);
				dispatch = request.getRequestDispatcher("Search.jsp");
				session.setAttribute("custid", userName);
				session.setAttribute("categList", categList);
				dispatch.forward(request, response);
			} else {
				session.setAttribute("errMsg", "Invalid User");
				dispatch = request.getRequestDispatcher("Login.jsp");
				dispatch.forward(request, response);
			}
		} catch (EcommerceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBFWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e.getMessage());

		} catch (EcommerceDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}

	}
}
