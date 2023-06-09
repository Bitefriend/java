<%@page import="org.joozis.ex.GreenDao"%>
<%@page import="org.joozis.ex.GreenVO"%>

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
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw"); 
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age")); 
	String addr = request.getParameter("addr");
	
	GreenVO dto = new GreenVO();
	dto.setId(id);
	dto.setPw(pw);
	dto.setName(name);
	dto.setAge(age);
	dto.setAddr(addr);
	
	// dao로 dto 전달
	// dao에서 전달받은 dto를 이용하여 데이터 삽입 후 결과 값 리턴
	// 전달 받은 데이터 (삽입 후)를 판단하여 진행 
	
	
	int result = GreenDao.getInstance().getInsert(dto);
	
	pageContext.setAttribute("result", result);
	
	
%>
	<c:choose>
		<c:when test="${result gt 0 }">
			<script type="text/javascript">
				alert("회원이 추가되었습니다.");
				location.href = "view_all.jsp";
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("회원이 추가를 실패했습니다.");
				location.href="view_all.jsp";
			</script>
		</c:otherwise>
	</c:choose>


</body>
</html>