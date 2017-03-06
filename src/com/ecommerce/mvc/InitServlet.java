package com.ecommerce.mvc;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Servlet implementation class for Servlet: InitServlet
 * 
 */
public class InitServlet extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public InitServlet() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#init()
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ServletContext context = config.getServletContext();
		String realPath = context.getRealPath("/");
//		String logFile = realPath + "WEB-INF\\log4j.properties";
//		PropertyConfigurator.configure(logFile);

	}
}