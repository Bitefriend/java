<%@page import="org.joonzis.ex.GuestBookVO"%>
<%@page import="org.joonzis.ex.GuestBookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <%
    	GuestBookVO vo = (GuestBookVO)session.getAttribute("vo"); 
    	int idx = vo.getIdx();
    	
    
    	int result = GuestBookDao.deleteByIdx(idx);
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
					alert("방명록이 삭제되었습니다");
					location.href="index.jsp";
				</script>
			</c:when>
			<c:otherwise>
				<script type="text/javascript">
					alert("방명록이 삭제되지 않았습니다.");
					history.go(-1);
				</script>
			</c:otherwise>
		</c:choose>
</body>
</html>