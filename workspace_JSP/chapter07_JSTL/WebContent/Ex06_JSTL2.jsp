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
	<!-- 1. 최소값, 최대값, 최소 값 ~ 최대 값 화면에 출력 -->
		<c:forEach var="i" begin="${param.num1 }" end="${param.num2 }" step="1">
		
		최소값 ~ 최대값 : ${i } <br>
		</c:forEach>
		<c:choose>
		<c:when test="${param.num1 gt param.num2 }">
		최소값 : ${param.num2 }
		최대값 : ${param.num1 }
		<c:set var="start" value="${param.num2 }"/>
		<c:set var="end" value="${param.num1 }"/>
		</c:when><br>
		<c:otherwise>
		최소값 : ${param.num1 }
		최대값 : ${param.num2 }
		<c:set var="start" value="${param.num1 }"/>
		<c:set var="end" value="${param.num2 }"/>
		</c:otherwise>
		최대값 :  <c:if test="${param.num1 - param.num2 lt 0 }">${param.num2 }</c:if><br>
		</c:choose>
	
	<!-- 2. 향상 forEach 이용하여 음식 종류들 출력 -->
	
		<c:forEach var="foods" items="${paramValues.foods }">
			음식 종류 : ${foods }<br>
		</c:forEach>
</body>
</html>