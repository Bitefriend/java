<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL을 이용하여 큰 수 출력하기 (삼항 연산자)</h1>
	${param.num1 } <br>
	${param.num2 } <br>
	${param.num1 > param.num2 ? param.num1 : param.num2 }
</body>
</html>