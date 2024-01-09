package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GeneralDao {
	// インタフェース PreparedStatement が持つ setObject メソッド
	// インタフェース List が持つ get メソッド
	public static void setParams(PreparedStatement statement, List<Object> params) 
	       throws SQLException {
		for (int i = 0; i < params.size(); i++) {
			statement.setObject(i + 1, params.get(i));
		}
	}
	
	// インタフェース PreparedStatement が持つ executeQuery() メソッドの戻り値 Resultset
	// SELECTの処理
	public static ResultSet executeQuery(Connection conn, String sql, List<Object> params) 
		   throws SQLException {
		PreparedStatement statement = conn.prepareStatement(sql);
		// SQL処理で必要な値をセットする
		setParams(statement, params);
		return statement.executeQuery();
	}
	// List<データ型名>
	// UPDATE, DELETE, の処理
	public static void executeUpdate(Connection conn, String sql, List<Object> params)
		   throws SQLException {
		PreparedStatement statement = conn.prepareStatement(sql);
		setParams(statement, params);
		statement.executeQuery();
	}
}
