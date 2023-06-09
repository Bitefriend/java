<%@page import="org.joonzis.ex.BDAO"%>
<%@page import="org.joonzis.ex.CVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
	    request.setCharacterEncoding("utf-8");
		CVO cvo = new CVO();
		cvo.setC_idx(Integer.parseInt(request.getParameter("c_idx")));
		cvo.setB_idx(Integer.parseInt(request.getParameter("b_idx")));
		int c_idx = cvo.getC_idx();
		int result = BDAO.deleteByCom(c_idx);
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
					alert("댓글이 삭제되었습니다");
					location.href="view.jsp?b_idx=${param.b_idx}&currentPage=${currentPage}";
				</script>
			</c:when>
			<c:otherwise>
				<script type="text/javascript">
					alert("댓글이 삭제되지 않았습니다.");
					history.go(-1);
				</script>
			</c:otherwise>
		</c:choose>
</body>
</html>