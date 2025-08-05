<%@page import="menus.MenuDto"%>
<%@page import="menus.MenuDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	String menu_id   = request.getParameter("menu_id");
	MenuDao dao      = new MenuDao();
	MenuDto dto      = dao.getMenu(menu_id);
	String menu_name = dto.getMenu_name();
	int    menu_seq  = dto.getMenu_seq();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 메뉴 추가</h2>
	<form action = "updateaction.jsp" method = "GET">
		<table>
			<tr>
				<td>메뉴 아이디</td><td><input type = "text" name = "menu_id" value ="<%= menu_id %>" readonly/></td>
			</tr>
			<tr>
				<td>메뉴 이름</td><td><input type = "text" name = "menu_name" value = "<%= menu_name %>"/></td>
			</tr>
			<tr>
				<td>메뉴 순번</td><td><input type = "text" name = "menu_seq" value = "<%= menu_seq %>"/></td>
			</tr>
			<tr>
				<td colspan = "2">
					<input type="submit" value = "등록" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>