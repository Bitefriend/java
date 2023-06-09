<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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
	tr:nth-of-type(7) {
		text-align: center;
	}
</style>
<script type="text/javascript">
function updatecom(f) {
	if (f.pw.value != "${vo.pw}") {
		alert("비밀번호 확인하세용");
		f.pw.focus();
		return
	}else if(f.title.value == ''|| f.email.value == ''|| f.content.value == ''){
		alert("빈칸 없이 입력해주세요");
		return
	}
	f.action = "update.jsp";
	f.submit();
}

</script>
</head>
<body>
<div>
	<h2>${vo.writer }방명록 수정</h2>
		<form action="update.jsp" method="post">
			<table>
				<tbody>
					<tr>
						<th>글 번호</th>
						<td> <input type="hidden" name="idx" value="${vo.idx}"> ${vo.idx }</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td> <input type="hidden" name="writer" value="${vo.writer} "> ${vo.writer }</td>
					</tr>
					<tr>
						<th>제목</th>
						<td> <input type="text" name="title" size="80"value="${vo.title }"></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td> <input type="text" name="email" size="80"value="${vo.email }"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td> <input type="password" name="pw" size="80"></td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td> <input type="file" name="filename"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td> <textarea rows="10" cols="80" name="content" >${vo.content }</textarea></td>
						<%-- <td> <input type="hidden" name="idx" value="${vo.idx }"> </td> --%>
					</tr>
					
					<tr>
						<td colspan="2">
							<input type="button" value="방명록 저장" onclick= "updatecom(this.form)">
							<input type="reset" value="다시 작성 ">
							<input type="button" value="목록으로 이동" onclick="location.href='index.jsp'">
						</td>
						
					</tr>
					
				</tbody>
			</table>
			
		</form>
	</div>

</body>
</html>