<%@page import="my.Calc"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String in_v1 = request.getParameter("v1");
	String in_v2 = request.getParameter("v2");
	String op    = request.getParameter("op");
	
	int v1       = Integer.parseInt(in_v1);
	int v2       = Integer.parseInt(in_v2);
	
	Calc c1 = new Calc();
	
	int v = 0;
	
	switch(op){
	case "+" : v = c1.add(v1,v2); break;
	case "-" : v = c1.subtract(v1, v2); break;
	case "*" : v = c1.multiply(v1, v2); break;
	case "/" : v = c1.divide(v1, v2); break;
	}
	
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 계산 결과 </h2>
	<p> v1 : <%= v1 %></p>
	<p> v2 : <%= v2 %></p>
	<p>결과 : <%= v %></p>
</body>
</html>