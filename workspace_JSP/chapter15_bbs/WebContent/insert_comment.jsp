<%@page import="org.joonzis.ex.CVO"%>
<%@page import="java.net.Inet4Address"%>
<%@page import="org.joonzis.ex.BDAO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    	/* 
    		BDAO.getInsertComment 메소드
    		결과 확인 없이 view 화면으로 이동
    	*/
    	request.setCharacterEncoding("utf-8");
    	CVO cvo = new CVO();
    	
    	cvo.setWriter(request.getParameter("writer"));
    	cvo.setPw(request.getParameter("pw"));
    	cvo.setContent(request.getParameter("content"));
    	cvo.setB_idx(Integer.parseInt(request.getParameter("b_idx")));
    	String ip = Inet4Address.getLocalHost().getHostAddress(); // ipv 4
    	cvo.setIp(ip);
    	int result = BDAO.cinsertComment(cvo);
    	session.setAttribute("result", result);
    	
    	
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
				alert("댓글이 작성되었습니다.");
				location.href= "view.jsp?b_idx=${param.b_idx}&currentPage=${currentPage}";
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("댓글이 작성을 실패했습니다.");
				history.go(-1);
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>