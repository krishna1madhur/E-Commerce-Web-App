package com.ecommerce.web.handler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.ecommerce.mvc.HttpRequestHandler;
import com.ecommerce.domain.Customer;
import com.ecommerce.service.EcommerceException;
import com.ecommerce.service.EcommerceFacade;

public class RegisterUser implements HttpRequestHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean isSuccess = false;
		RequestDispatcher dispatch = null;
		HttpSession session = request.getSession(true);
		String custId = request.getParameter("text_custID");
		
		String password = request.getParameter("password_password");
		
		String firstname = request.getParameter("text_firstName");
		
		String lastname = request.getParameter("text_lastName");
		
		String dob = request.getParameter("text_dateOfBirth");
		

		String address = request.getParameter("text_address");
		
		long contactNo = Long.parseLong(request.getParameter("text_contactNo"));
		
		Long ccardNo = Long
				.parseLong(request.getParameter("text_creditCardNo"));
		
		String cardType = request.getParameter("text_cardType");
		
		String cardExpiryDate = request
				.getParameter("text_creditcardExpiryDate");

		

		Customer customer = new Customer(custId, password, firstname, lastname,
				dob, address, contactNo, ccardNo, cardType, cardExpiryDate);

		try {
			isSuccess = EcommerceFacade.registerUser(customer);
			
			if (isSuccess == true) {
				session.setAttribute("errorMsg", "Successfully Registered");
				dispatch = request.getRequestDispatcher("Search.jsp");
				session.setAttribute("custid", custId);
				dispatch.forward(request, response);
			} else {
				session.setAttribute("errorMsg", "Invalid format entered");
				request.getRequestDispatcher("RegisterNewUser.jsp").forward(
						request, response);
			}
		} catch (EcommerceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.setAttribute("errorMsg", e.getMessage());
			request.getRequestDispatcher("RegisterNewUser.jsp").forward(
					request, response);
		}

	}
}
