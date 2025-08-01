<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String dong = request.getParameter("dong");
	String html = "";
	if(dong == null){
		
	}else{
		PostDao db = new PostDao();
		db.getPost(dong);
		html += "";
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
</script>
</head>
<body>
	<form action = "" method = "POST">
	동명 <input type="text" name ="dong" />
	<input type="submit" value ="검색" />
	</form>
	<div>
		<%= html %>
	</div>
</body>
</html>