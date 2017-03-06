package com.ecommerce.dbfw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DBHelper {


	public static List<Object> executeSelect(Connection con,
			final String sqlSt, ResultMapper outMap) throws DBFWException {

		List<Object> resultList = new ArrayList<Object>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sqlSt);
			while (rs.next()) {
				Object obj = outMap.mapRow(rs);
				resultList.add(obj);
			}
		} catch (SQLException e) {

			throw new DBFWException(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				throw new DBFWException(e.getMessage());
			}
		}
		return resultList;
	}

	public static List<Object> executeSelect(Connection con,
			String sqlStatement, ResultMapper outMap, ParamMapper mapParam)
			throws DBFWException {
		PreparedStatement prestmt = null;
		ResultSet rs = null;
		List<Object> result = new ArrayList<Object>();
		try {
			prestmt = con.prepareStatement(sqlStatement);
			mapParam.mapParams(prestmt);
			rs = prestmt.executeQuery();
			while (rs.next()) {
				Object obj = outMap.mapRow(rs);
				result.add(obj);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			throw new DBFWException(e.getMessage());
		}
		return result;
	}

	public static int executeUpdate(Connection con, final String sqlSt,
			ParamMapper inMap) throws DBFWException {
		PreparedStatement preStmt = null;
		int result = 0;
		try {
			preStmt = con.prepareStatement(sqlSt);
			if (inMap != null)
				inMap.mapParams(preStmt);
			result = preStmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
			throw new DBFWException("Failed to execute Update Statement");
		} finally {
			try {
				if (preStmt != null)
					preStmt.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}
}
