<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function send(f) {
		if(f.name.value == '' || f.kor.value == ''|| f.eng.value == ''||f.mat.value == ''){
			alert("제대로 기입됐는지 확인 ");
			return;
		} 
		 
		f.action = '/chapter03_servlet/Ex08_request';
		f.submit();
	}
</script>
</head>
<body>
	<form method="get">
	<p>성명 <input type="text" name="name"></p>
	<p>국어 <input type="number" name="kor"></p>
	<p>영어 <input type="number" name="eng"></p>
	<p>수학 <input type="number" name="mat"></p>
	<input type="button" value="결과확인"onclick="send(this.form)"> 
	<input type="reset" value="초기화"onclick="send(this.form)"> 
	</form>
</body>
</html>