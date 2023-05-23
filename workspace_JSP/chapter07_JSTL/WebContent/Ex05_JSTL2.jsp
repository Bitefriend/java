<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>향상 for문 형식의 forEach</h1>
		<%
			String[] name = {"김", "이", "박", "최", "정"};
			pageContext.setAttribute("NAMES", name);
		%>
		
		<c:forEach var="name" items="${NAMES }">
			${name }<br>
		</c:forEach>
</body>
</html>