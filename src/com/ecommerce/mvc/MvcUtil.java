package com.ecommerce.mvc;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class MvcUtil {


	private MvcUtil() {
		super();
	}

	private static boolean checkInterface(Class clazz, String interfaceName) {
		boolean found = false;
		Class[] interfaces = clazz.getInterfaces();
		for (int i = 0; i < interfaces.length; i++) {
			if (interfaces[i].getName().equals(interfaceName)) {
				found = true;
				break;
			}
		}
		return found;
	}

	public static Map buildHandlers(String propsFile) throws MvcException {
		Map handlers = new HashMap();
		Properties props = new Properties();
		FileInputStream proStr = null;
		try {
			proStr = new FileInputStream(propsFile);
			props.load(proStr);
			Enumeration enKeys = props.propertyNames();
			while (enKeys.hasMoreElements()) {
				String key = (String) enKeys.nextElement();
				
				String clazz = props.getProperty(key);
				
				Class handClazz = Class.forName(clazz);
				if (checkInterface(handClazz,
						"com.ecommerce.mvc.HttpRequestHandler")) {
					Object handler = handClazz.newInstance();
					handlers.put(key, handler);
				} else {
					throw new MvcException(
							"Class does not implement com.nttdata.mvc.IHttpRequestHandler interface");
				}
			}
		} catch (IOException e) {
			throw new MvcException(e.getMessage());

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new MvcException(e.getMessage());
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new MvcException(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new MvcException(e.getMessage());
		} finally {
			try {
				proStr.close();
			} catch (IOException e) {
				throw new MvcException(e.getMessage());
			}
		}
		return handlers;
	}
}
