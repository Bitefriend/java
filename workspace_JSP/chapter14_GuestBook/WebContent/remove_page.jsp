
<%@page import="org.joonzis.ex.GuestBookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div{
		width: 800px;
		margin: auto;
		text-align: center;
	}
	table{
		width: 100%;
		border-collapse: collapse;
		text-align: left;
	}
	td, th{
		border : 1px solid black;
		padding : 10px;
	}
	th{
		width : 100px;
		background-color: purple;
		color : #fff;
		text-align: center;
	}
	tr:nth-of-type(3) {
		text-align: center;
	}
</style>
<script type="text/javascript">
	function remove(f) {

		 if ( f.pw.value == ""){
			alert("비밀번호를 입력하시오");
			f.pw.focus();
			return;
		} else if(f.pw.value != "${vo.pw}"){
			alert("비밀번호 확인");
			f.pw.focus();
			return;
		} else if(f.pw.value == "${vo.pw}"){
			if(!confirm("진짜 삭제?")){
				alert("삭제ㄴ");
			}else{
				f.action = "remove.jsp";
				f.submit();
				
			}
			return;
		} 
		//submit
		f.action = "remove.jsp";
		f.submit();
	}
	
</script>
</head>
<body>
	<div>
		<h2>${vo.writer }의 방명록 삭제 확인</h2>
		<form action="post">
			<table>
				<tbody>
					<tr>
						<th>제목</th>
						<td>${vo.title }</td>
					</tr>
					<tr>
						<th>비밀번호 확인</th>
						<td><input type="password" name="pw" size="80" value = "${vo.pw }"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="button" value="방명록 삭제" onclick="remove(this.form)">
							<input type="button" value="목록으로 이동" onclick="location.href='index.jsp'">
						</td>
					</tr>
				</tbody>
			</table>
			<input type="hidden" name="idx" value="${vo.idx}">
		</form>
		
	</div>
</body>
</html>