<%@page import="menus.MenuDao"%>
<%@page import="menus.MenuDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	MenuDao dao = new MenuDao();
	ArrayList<MenuDto> list = dao.getMenuList();
	
	String html = "";
	for(int i = 0; i < list.size(); i++){
		MenuDto menu = list.get(i);
		html += "<tr>";
		html += "<td>" + menu.getMenu_id()   + "</td>";
		html += "<td>" + menu.getMenu_name() + "</td>";
		html += "<td>" + menu.getMenu_seq()  + "</td>";
		html += "<td><a href = 'deleteaction.jsp?menu_id=" + menu.getMenu_id() + "'>삭제</a></td>";
		html += "<td><a href = 'updatemenu.jsp?menu_id=" + menu.getMenu_id() + "'>수정</a></td>";
		html += "</tr>";
	}
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴 만들기</title>
</head>
<body>
	<h2>메뉴 목록</h2>
	<table border = "1" width = "978" align = "center">
	<%
//		MenuDao dao = new MenuDao();
//		ArrayList<MenuDto> list = dao.getMenuList();
	%>	
	<%
//		for(int i = 0; i < list.size(); i++){		
//			MenuDto dto = list.get(i);
	%>
		
	<%
//		}
	%>	
	<tr style = "text-align : center">
		<td>menu_id</td>
		<td>menu_name</td>
		<td>menu_seq</td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td colspan = "5" align = "right">
			<a href = "addmenu.jsp">메뉴 추가</a>
		</td>	
	</tr>	
		
	<%= html %>	
	</table>
</body>
</html>