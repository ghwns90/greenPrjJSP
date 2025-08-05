<%@page import="menus.MenuDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    // addmenu.jsp 가 보내준 data를 받는다
    String menu_id 		= request.getParameter("menu_id");
    String menu_name 	= request.getParameter("menu_name");
    String menu_seq_in  = request.getParameter("menu_seq");
    
    int menu_seq        = Integer.parseInt( menu_seq_in );
    
    // 저장한다
    MenuDao dao = new MenuDao();
    dao.addMenu(menu_id, menu_name, menu_seq);
    
    // 목록으로 돌아간다
    String loc = "menulist.jsp";
    
   	// 2초 후에 url로 자동으로 이동하게 된다
   	// Javascript 에서는 setTimeout을 동일하게 사용
    response.setHeader("Refresh", "2; url=menulist.jsp");

    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>저장됨 기다리셈</h2>
</body>
</html>