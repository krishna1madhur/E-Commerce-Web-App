package com.ecommerce.mvc;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: MvcController
 * 
 */
public class MvcController extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	private Map handlers;

	public MvcController() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = request.getServletPath();

		// String key = url.substring(url.lastIndexOf('/') + 1, url
		// .lastIndexOf('.'));
		String key = url.substring(7, url.lastIndexOf('.'));

		HttpRequestHandler handler = (HttpRequestHandler) handlers.get(key);
		if (handler != null) {
			handler.handle(request, response);
		} else {
			throw new ServletException("No matching handler");
		}
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#init()
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);

		String mvcProps = getServletContext().getRealPath(
				"/WEB-INF/mvc.properties");
		try {
			this.handlers = MvcUtil.buildHandlers(mvcProps);
		} catch (MvcException e) {
			throw new ServletException(
					"Unable to configure controller servlet", e);
		}
	}
}