<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("utf-8");
   		 String currentPage = request.getParameter("currentPage"); 
    %>
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
		border : 1px solid #1e90ff;
		padding : 10px;
	}
	th{
		width : 100px;
		background-color:  #0078ff;
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
		} else if(f.pw.value != "${bvo.pw}"){
			alert("비밀번호 확인");
			f.pw.focus();
			return;
		} else if(f.pw.value == "${bvo.pw}"){
			if(!confirm("진짜 삭제?")){
				alert("삭제ㄴ");
			}else{
				f.action = "remove.jsp";
				f.submit();
			}
			return;
		}
	}
</script>
</head>
<body>
<div>
	<h2>${bvo.b_idx }의 게시판 삭제 확인</h2>
		<form action="post">
			<table>
				<tbody>
					<tr>
						<th>작성자</th>
						<td>${bvo.writer }</td>
					</tr>
					<tr>
						<th>제목</th>
						<td>${bvo.title }</td>
					</tr>
					<tr>
						<th>비밀번호 확인</th>
						<td><input type="password" name="pw" size="80" value = "${bvo.pw }"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="button" value="방명록 삭제" onclick="remove(this.form)">
							<input type="button" value="목록으로 이동" onclick="location.href='index.jsp'">
							<input type="button" value="게시글로 이동" onclick="history.go(-1)">
							<input type="reset" value="다시작성" >
					</tr>
				</tbody>
			</table>
			<input type="hidden" name="b_idx" value="${bvo.b_idx}">
		</form>
		
	</div>
</body>
</html>