<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function send(f) {
		if(f.id.value == '' || f.pw.value == ''|| f.name.value == ''||f.email.value == ''){
			alert("제대로 기입됐는지 확인 ");
			return;
		}
		var cnt = 0;
		 for (var i = 0; i < f.hobbies.length; i++) {
			if(f.hobbies[i].checked == true){
				cnt ++
			}else if(cnt ==0){
				alert("선택");
				return;
			}
		}
		 
		f.action = '/chapter03_servlet/Ex07_request';
		f.submit();
	}
</script>
</head>
<body>
		<form method="get">
		<fieldset>
			<legend>회원가입</legend>
			<p>아이디 <input type="text" name="id"></p>
			<p>비밀번호 <input type="number" name="pw"></p>
			<p>이름 <input type="text" name="name"></p>
			<p>이메일 <input type="email" name="email"></p>
			<p>성별 
				<input type="radio" name="gender" value="남자" checked="checked">남
				<input type="radio" name="gender" value="여자">여
			</p>
			<p> 취미
				<input type="checkbox" name="hobbies" value="영화">영화
				<input type="checkbox" name="hobbies" value="게임">게임
				<input type="checkbox" name="hobbies" value="독서">독서
				<input type="checkbox" name="hobbies" value="여행	">여행
				<input type="checkbox" name="hobbies" value="없음	">없음
			</p>
			<input type="button" value="보내기"onclick="send(this.form)"> 
			<input type="reset" value="작성취소"onclick="send(this.form)"> 
		</fieldset>
	</form>
</body>
</html>