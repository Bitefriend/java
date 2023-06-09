<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function send(f) {
		f.action = '/chapter17_mvc2/Controller';
		f.submit();
	}
</script>
</head>
<body>
	<div>
		<form method="post">
			<table>
				<tbody>
					<tr>
						<th>이름</th>
						<td> <input type="text" name="name"></td>
					</tr>
					<tr>
						<th>나이</th>
						<td> <input type="number" name="age"></td>
					</tr>
					<tr>
						<th>연락처</th>
						<td> <input type="text" name="phone"></td>
					</tr>
					<tr>
						<th>주소</th>
						<td> <input type="text" name="addr"></td>
					</tr>
					<tr>
						<th>자기소개</th>
						<td><textarea rows="3" cols="50" name="self"></textarea></td>
					</tr>
					<tr>
						<td colspan="2">
						<input type="button" value="전송" onclick="send(this.form)"> 
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>