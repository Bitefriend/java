<%@page import="org.joonzis.ex.GreenVO"%>
<%@page import="org.joonzis.ex.GreenDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
	
 	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String addr = request.getParameter("addr");
	String idx = request.getParameter("idx"); 
	
	GreenVO vo = new GreenVO();
	vo.setId(id);
	vo.setPw(pw);
	vo.setName(name);
	vo.setAge(Integer.parseInt(age));
	vo.setAddr(addr);
	vo.setIdx(Integer.parseInt(idx)); 

	GreenDao dao = GreenDao.getInstance();
	int result = dao.getUpdate(vo);	
	pageContext.setAttribute("result", result);
			%>
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
		<c:choose>
			<c:when test="${result gt 0 }">
				<script type="text/javascript">
					location.href="view_all.jsp";
				</script>
		</c:when>
		<c:otherwise>
		<script type="text/javascript">
			alert("회원 수정에 실패했습니다.");
			history.go(-1);								 
		</script>
		
		</c:otherwise>
	</c:choose>
	</body>
</html>