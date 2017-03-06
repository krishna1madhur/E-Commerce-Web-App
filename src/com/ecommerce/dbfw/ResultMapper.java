package com.ecommerce.dbfw;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultMapper {
	Object mapRow(ResultSet rs) throws SQLException;
}
