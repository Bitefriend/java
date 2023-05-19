<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>include1.jsp 페이지</h1>
	
	<br><br><hr>
	
	<!-- Ex01_include1.jsp 페이지에 Ex01_include2.jsp 페이지를 포함 -->
	
	<!-- 1. include 지시어 -->
	<%@ include file = "Ex01_include2.jsp" %> <!-- 2번페이지 불러서 넣는 지시어 -->

	<!-- 2. include 액션 태그 -->
	<jsp:include page="Ex01_include2.jsp">
		<jsp:param value="김씨" name="name"/>
		<jsp:param value="20" name="age"/>
		<jsp:param value="서울" name="addr"/>
	</jsp:include>



</body>
</html>