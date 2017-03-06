package com.ecommerce.dbcon;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public final class ConnectionHolder {
	private ConnectionHolder() {

	}

	private static ConnectionHolder instance = null;
	private DataSource ds = null;

	// public static final Logger LOG = Logger.getLogger(ConnectionHolder);

	private void initAppServerDataSource() throws DBConnectionException {
		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/MyDB");

		} catch (NamingException e) {
			throw new DBConnectionException("Unable to get datasource", e);
		}
	}

	public Connection getConnection() throws DBConnectionException {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			final String exception = "unable to obtain a connection";
			throw new DBConnectionException(exception, e);
		}
	}

	public static ConnectionHolder getInstance() throws DBConnectionException {
		synchronized (ConnectionHolder.class) {
			if (instance == null) {
				instance = new ConnectionHolder();
				instance.initAppServerDataSource();
			}
		}
		return instance;
	}

	// Method is called while closing the application
		public void dispose() throws DBConnectionException {
			BasicDataSource bds = (BasicDataSource) ds;
			try {
				bds.close();
			} catch (SQLException e) {
				final String exception = "Unable to close the connection";
				// logger.debug(exception, e);
				throw new DBConnectionException(exception);
			}
		}
}
