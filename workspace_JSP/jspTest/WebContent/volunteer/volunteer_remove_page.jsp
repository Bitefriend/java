<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자기소개서 삭제</title>
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

		 if ( f.mpw.value == ""){
			alert("비밀번호를 입력하시오");
			f.mpw.focus();
			return;
		} else if(f.mpw.value != "${member.mpw}"){
			alert("비밀번호 확인");
			f.mpw.focus();
			return;
		} else if(f.mpw.value == "${member.mpw}"){
			if(!confirm("진짜 삭제?")){
				alert("삭제ㄴ");
			}else{
				f.action = "/jspTest/VolController";
				f.submit();
			}
			return;
		}
	}
</script>
</head>
<body>
<div>
	<h2>${vvo.v_idx }의 자기소개서 삭제 확인</h2>
		<form action="post">
			<table>
				<tbody>
					<tr>
						<th>작성자</th>
						<td>${vvo.v_idx }</td>
					</tr>
					<tr>
						<th>작성자 번호</th>
						<td>${member.m_idx }</td>
					</tr>
					<tr>
						<th>비밀번호 확인</th>
						<td><input type="password" name="mpw" size="80" value = "${member.mpw }"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="button" value="방명록 삭제" onclick="remove(this.form)">
							<input type="button" value="목록으로 이동" onclick="location.href='volunteer_remove_page.jsp'">
							<input type="button" value="게시글로 이동" onclick="history.go(-1)">
							<input type="reset" value="다시작성" >
							<input type="hidden" name="cmd" value="vol_remove">
					</tr>
				</tbody>
			</table>
			<input type="hidden" name="v_idx" value="${vvo.v_idx}">
		</form>
		
	</div>
</body>
</html>