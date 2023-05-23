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
	<!-- 
		1. JSTL을 이용하여 변수 (avg) 생성
		
		2. JSTL을 이용하여 변수 (grade) 생성
		90점 이상 A
		80점 이상 B
		...
		60점 미만 F
		
		3. JSTL을 이용하여 합, 불 출력 (pass생성)
		
		4. 출력 데이터 
		국어 : 00점
		영어 : 00점
		수학 : 00점
		평균 : 00
		학점 : A
		합격여부 : 합격
	 -->
	국어 : ${param.kor }<br>
	영어 : ${param.eng }<br>
	수학 : ${param.mat }<br>
	<c:set var="grade" value="" />
	<c:set var="pass" value="" />
	
	<c:set var="avg" value="${(param.kor + param.eng + param.mat) / 3.0 }"/>
	평균 : <c:out value="${avg }"/><br>
	<c:choose>
	<c:when test="${avg >= 90}">
		 <c:set var="grade" value="A" />
		 학점 : <c:out value="${grade }"/><br>

	</c:when>
	<c:when test="${avg >= 80}">
		 <c:set var="grade" value="B" />
		 학점 : <c:out value="${grade }"/><br>
	</c:when>
	<c:when test="${avg >= 70}">
		 <c:set var="grade" value="C" />
		  학점 : <c:out value="${grade }"/><br>
	</c:when>
	<c:when test="${avg >= 60}">
		 <c:set var="grade" value="D" />
		 학점 : <c:out value="${grade }"/><br>
	</c:when>
	<c:when test="${avg < 60}">
		 <c:set var="grade" value="F" />
		 학점 : <c:out value="${grade }"/><br>
	</c:when>
	</c:choose>
	
	
	 <c:if test="${avg > 60}">
	 	<c:set var="pass" value="합격" />
	 	합격 여부 : <c:out value="${pass }"/>
	</c:if>
	 <c:if test="${avg < 60 }">
	 	<c:set var="pass" value="불합격" />
		합격여부 : <c:out value="${pass }"/>
		</c:if>

	 
</body>
</html>