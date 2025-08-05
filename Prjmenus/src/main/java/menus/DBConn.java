package menus;

import java.sql.*;

public class DBConn {
	
	// 연결 문자열
	private String driver   = "oracle.jdbc.OracleDriver";
	private String dburl    = "jdbc:oracle:thin:@localhost:1521:xe";
	private String dbuid    = "test";
	private String dbpwd    = "1234";
	
	private Connection conn = null;
	
	public Connection getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dburl, dbuid, dbpwd);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 설정을 확인하세요");
		} catch (SQLException e) {
			System.out.println("DB 연결 에러");
		}
		return conn;
	}
	// db 연결
}
