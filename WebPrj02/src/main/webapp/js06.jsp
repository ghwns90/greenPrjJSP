<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%	// JSP 영역 : java
    	// 넘어온 정보 받아서 잘라낸다
    	// http://localhost:8080/WebPrj02/js06.jsp?id=sky&pwd=1234
    	String id  = request.getParameter("id");
    	String pwd = request.getParameter("pwd");
    
    	
    %>
    
    
   <!-- HTML 영역 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<body>
	<h2>로그인 정보</h2>
	<div>아이디 : <%= id %></div>
	<div>암호 : <%= pwd %></div>
	<div><a href="javascript:history.back()">뒤로</a></div>
</body>
</html>