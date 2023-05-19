<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String age = request.getParameter("age");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>페이지 이동 중간 페이지</h1>
	<div>이름 = <%=name %></div>
	<div>나이 = <%=age %></div>
	
	<br><hr><br>
	
	<!-- 1. <a> 태그로 이동하기  -->
	<%-- 피라미터 전달 x --%>
	<a href= "Ex06_03_page_move.jsp">피라미터 x</a>
	
	<%-- 피라미터 전달 o --%>
	<a href= "Ex06_03_page_move.jsp?name=<%=name%>&age=<%=age%>">피라미터 o</a>
	
	<br><hr><br>
	
	<%--2. location 객체로 이동하기 --%>
	<button onclick ="location.href='Ex06_03_page_move.jsp'">파라미터 x</button>"
	<button onclick="location.href='Ex06_03_page_move.jsp?name=<%=name %>&age=<%=age %>'">파라미터 x</button>
	
	<br><hr><br>
	
	<%--3. 포워드로 이동 --%>
	<% 
		//request.getRequestDispatcher("Ex06_03_page_move.jsp").forward(request, response);
	%>
	
	<%--4.리다이렉트로 이동 --%>
	<%
		response.sendRedirect("Ex06_03_page_move.jsp");
	%>
</body>
</html>