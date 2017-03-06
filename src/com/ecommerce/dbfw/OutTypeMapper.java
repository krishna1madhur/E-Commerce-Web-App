package com.ecommerce.dbfw;

import java.sql.CallableStatement;
import java.sql.SQLException;

public interface OutTypeMapper {
	public void mapOutType(CallableStatement callStmt) throws SQLException;
}
