<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSON 파싱</h1>
	<div id="output"></div>
	<script type="text/javascript">
		//JSON은 문자열 형태로 데이터가 교환됨
		// 따라서, 전송이 끝난 뒤 사용을 위해서는 원래 타입으로 변경해야한다.
		// 주로 AJAX로 데이터를 통신할 경우 사용
		
		//웹 서버에서 클라이언트로 데이터를 전송하는경우 (Server to Client)
		let txt = '{"name":"kim", "age":20, "city":"Busan", "birth":"2023-08-12"}';
		let obj = JSON.parse(txt); // JSON을 파싱하는 parse
		
		document.querySelector("#output").innerHTML = txt;
		
		//date는 변환이 불가능하기 때문에 값을 따로 변환시켜야함
		obj.birth = new Date(obj.birth);
		document.querySelector("#output").innerHTML += obj.name + ", " + obj.birth;
		
	</script>
</body>
</html>