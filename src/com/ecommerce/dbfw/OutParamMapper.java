package com.ecommerce.dbfw;

import java.sql.CallableStatement;
import java.sql.SQLException;

public interface OutParamMapper {
	public Object mapOutParam(CallableStatement callStmt) throws SQLException;
}
