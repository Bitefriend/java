<%@page import="org.joonzis.ex.GreenDao"%>
<%@page import="org.joonzis.ex.GreenVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    

<%
	request.setCharacterEncoding("utf-8");

	 String id = request.getParameter("id");
	
	
	GreenDao dao = GreenDao.getInstance();
	GreenVO vo = new GreenVO();
	vo.setId(id);
	 
	
	int result = dao.getRemove(vo);
	pageContext.setAttribute("result", result);

	 %>
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
	<jsp:include page="index.jsp"/>	
		<c:choose>
			<c:when test="${result gt 0 }">
				 <script type="text/javascript">
					location.href = "view_all.jsp";
				</script>
			</c:when>
			<c:otherwise>
				<script type="text/javascript">
					alert("회원 탈퇴에 실패했습니다.");
					history.go(-1);		// history.back()
				</script>
 		</c:otherwise>
		</c:choose>
	</body>
</html> 