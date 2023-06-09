<%@page import="org.joonzis.ex.GuestBookVO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="org.joonzis.ex.GuestBookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%
 	
	request.setCharacterEncoding("utf-8");
	
	GuestBookVO vo = new GuestBookVO();
	/* vo.setWriter(request.getParameter("writer"));
	vo.setPw(request.getParameter("pw")); */
	vo.setTitle(request.getParameter("title"));
	vo.setEmail(request.getParameter("email"));
	vo.setContent(request.getParameter("content"));
	vo.setIdx(Integer.parseInt(request.getParameter("idx")));
	
	
	
	int result = GuestBookDao.updateByIdx(vo);
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
				alert("방명록이 수정되었습니다.");
				location.href="index.jsp";
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("방명록이 수정을 실패했습니다.");
				history.go(-1);
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>