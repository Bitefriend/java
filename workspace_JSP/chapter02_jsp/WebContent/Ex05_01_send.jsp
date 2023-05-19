<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function send(f) {
		document.getElementById("ha").value = document.getElementById("ho").value;
		f.action = '/chapter02_jsp/Ex05_02_receive.jsp';
		f.submit(); // 함수
	}
</script>
</head>
<body>
	<form method="get">
		<fieldset>
			<legend>개인 정보</legend>
			<p>이름 <input type="text" name="name"></p>
			<p>나이 <input type="number" name="age"></p>
			<p>전화 <input type="tel" name="phone"></p>
			<p>성별 
				<input type="radio" name="gender" value="남자" checked="checked">남
				<input type="radio" name="gender" value="여자">여
			</p>
			<p> 취미
				<input type="checkbox" name="hobbies" value="영화">영화
				<input type="checkbox" name="hobbies" value="게임">게임
				<input type="checkbox" name="hobbies" value="독서">독서
				<input type="checkbox" name="hobbies" value="여행	">여행
				<input type="checkbox" name="hobbies" id="ha" value="">기타
				<input type="text" id="ho" >
			</p>
			<p>주소
				<select name = "addr">
					<option value="서울">서울</option>
					<option value="경기">경기</option>
					<option value="제주">제주</option>
					<option value="부산">부산</option>
				</select>
			</p>
			<p>좋아하는 음식</p>
			<p>
				<select name = "foods" size = "4" multiple = "multiple">
					<option value="한식">한식</option>
					<option value="중식">중식</option>
					<option value="일식">일식</option>
					<option value="양식">양식</option>
				</select>
			</p>
			<input type="button" value="보내기"onclick="send(this.form)"> 
			<input type="reset" value="작성취소"onclick="send(this.form)"> 
			
		</fieldset>
	</form>
</body>
</html>