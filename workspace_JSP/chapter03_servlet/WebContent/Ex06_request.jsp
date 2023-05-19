<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//검색 내용이 없으면 " 검색 내용을 입력하세요" 출력
		function send(f) {
			if(f.query.value == ''){
				alert("검색 내용입력 ");
				return;
				}
			f.action = '/chapter03_servlet/Ex06_request';
			f.submit(); // 함수
		}
</script>
</head>
<body>
	<form method="get">
		검색 <input type="text" name="query" id="d">
		<input type="button" value="전송" onclick="send(this.form)">
	</form>
</body>
</html>