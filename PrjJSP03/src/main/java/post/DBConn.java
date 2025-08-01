package post;

import java.sql.*;

public class DBConn {

	// 연결 문자열 : Connection String
	private static String driver = "oracle.jdbc.OracleDriver";
	private static String dburl    = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String dbuid  = "zipcode";
	private static String dbpwd  = "1234";
	
	private Connection conn = null;
	
	public Connection getConnection() {
				
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dburl, dbuid, dbpwd);
		} catch (SQLException e) {			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			return conn;
		}
	}
	
}
