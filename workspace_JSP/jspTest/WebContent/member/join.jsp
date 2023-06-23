<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function join(f) {
		if (f.mid.value == "") {
			alert("아이디 입력");
			f.mid.focus();
			return;
		}
		if (f.mpw.value == "") {
			alert("비번 입력");
			f.mpw.focus();
			return;
		}
		if (f.mpwCk.value == "") {
			alert("비번확인 입력");
			f.mpwCk.focus();
			return;
		}
		if (f.mname.value == "") {
			alert("이름 입력");
			f.mname.focus();
			return;
		}
		f.action = "/jspTest/MemberController";
		f.submit();
	}
	function view_all() {
		location.href='/jspTest/MainController?cmd=allList';
	}
</script>
<style type="text/css">

</style>
</head>
<body>
	<div>
		<h2>회원가입</h2>
		<form method="post">
			<table>
				<tbody>
					<tr>
						<th>아이디</th>
						<td><input type="text" name="mid"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="mpw"></td>
					</tr>
					<tr>
						<th>비밀번호 확인</th>
						<td><input type="password" name="mpwCk"></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" name="mname"></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="text" name="mtel"></td>
					</tr>
					<tr>
						<th>나이</th>
						<td><input type="number" name="mage"></td>
					</tr>
					<tr>
						<td colspan="2" id="btn">
							<input type="button" value="회원가입 " onclick="join(this.form)">&nbsp;
							<input type="reset" value="다시 작성"> &nbsp;&nbsp;
							<input type="button" value="목록으로 이동" onclick="view_all()">
							<input type="hidden" name="cmd" value="join">
						</td>
					</tr>
				</tbody>
			</table>
			
		</form>
	</div>
</body>
</html>