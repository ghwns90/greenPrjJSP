<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 정보 삭제 
	
	// 넘어온 정보를 변수에 받는다
	request.setCharacterEncoding("utf-8");

	String name   = request.getParameter("name");
	String id     = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String email  = request.getParameter("email");
	// db 연결
	String driver = "oracle.jdbc.OracleDriver";
	String dburl  = "jdbc:oracle:thin:@localhost:1521:xe";
	String dbuid  = "test";
	String dbpwd  = "1234";
	// db 에 저장한다
	Class.forName(driver);
	Connection conn		    = DriverManager.getConnection(dburl, dbuid, dbpwd);
	
	String sql = "";
	sql       += "DELETE FROM TUSER";
	sql       += " WHERE id = ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, Integer.parseInt(id));
	
	
	pstmt.executeUpdate(); // executeUpdate() : insert, delete, update
	
	pstmt.close();
	conn.close();
	
	// 돌아간다
	String loc = "http://localhost:8080/PrjJSP01/user/userlist.jsp?name=all";
	response.sendRedirect(loc);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

</body>
</html>