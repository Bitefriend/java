<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <%
		 String currentPage = request.getParameter("currentPage"); 

    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 수정</title>
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
		background-color: #0078ff;
		color : #fff;
		text-align: center;
	}
	tr:nth-of-type(7) {
		text-align: center;
	}
</style>
<script type="text/javascript">
function updatecom(f) {
	if (f.spw.value != "${bvo.spw}") {
		alert("비밀번호 확인하세용");
		f.spw.focus();
		return
	}/* else if(f.stitle.value == ''|| f.content.value == ''){
		alert("빈칸 없이 입력해주세요");
		f.stitle.focus();
		return
	} */
	f.action = "/jspTest/MainController";
	/* currentPage=${currentPage} */
	f.submit();
}

</script>
</head>
<body>
<div>
	<h2>${bvo.s_idx }번 공지사항 수정</h2>
		<form method="post" enctype="multipart/form-data">
			<table>
				<tbody>
					<tr>
						<th>글 번호</th>
						<td> <input type="hidden" name="s_idx" value="${bvo.s_idx}"> ${bvo.s_idx }</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td> <input type="hidden" name="sname" value="${bvo.sname} "> ${bvo.sname }</td>
					</tr>
					<tr>
						<th>조회수</th>
						<td>${bvo.hit }</td>
					</tr>
					<tr>
						<th>제목</th>
						<td> <input type="text" name="stitle" size="80"value="${bvo.stitle }"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td> <input type="password" name="spw" size="80"></td>
					</tr>
					 <tr>
						<th>첨부파일</th>
						<td> 
						<input type="file" name="filename">
							<c:choose>
								<c:when test="${bvo.filename eq null }">
									[ 기존 첨부 파일 : 없음 ]
								</c:when>
								<c:otherwise>
									[ 기존 첨부파일 : ${bvo.filename } ]
									<input type="hidden"  name="oldfile" value="${bvo.filename }">
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td> <textarea rows="10" cols="80" name="content" >${bvo.content }</textarea></td>
						<td> <input type="hidden" name="s_idx" value="${bvo.s_idx }"> </td>
					</tr>
					
					<tr>
						<td colspan="2">
							<input type="button" value="방명록 저장" onclick= "updatecom(this.form)">
							<input type="reset" value="다시 작성 ">
							<input type="button" value="목록으로 이동" onclick="location.href='/jspTest/MainController?cmd=allList'">
							<input type="button" value="게시글로 이동" onclick= "history.back()">
						</td>
					</tr>
				</tbody>
			</table>
			<input type="hidden" name="cmd" value="update">
		</form>
	</div>
</body>
</html>