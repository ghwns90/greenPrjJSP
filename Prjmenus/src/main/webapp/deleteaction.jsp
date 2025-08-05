<%@page import="menus.MenuDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String menu_id = request.getParameter("menu_id");

	MenuDao dao = new MenuDao();
	dao.deleteMenu(menu_id);
	
	String loc = "menulist.jsp";
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