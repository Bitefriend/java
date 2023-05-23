<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		성적 입력화면 (form)
		국어 : kor 
		영어 : eng
		수학 : mat 
		action : Ex04_JSTL2.jsp
	 -->
	 	<form action="Ex04_JSTL2.jsp">
	 		<p> 국어 : <input type="number" name="kor"></p>
	 		<p> 영어 : <input type="number" name="eng"></p>
	 		<p> 수학 : <input type="number" name="mat"></p>
	 		<input type="submit" value="제출">
	 	</form>
	 
</body>
</html>