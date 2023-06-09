<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");

	String b_idx = request.getParameter("b_idx");
	String currentPage = request.getParameter("currentPage");
	
	// b_idx를 이용해서 데이터 가져오기
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div {
		width: 800px;
		margin: auto;
		text-align: center;
	}
	table {
		width: 800px;
		text-align: left;
		border-collapse: collapse;		
	}
	
	td,th {
		border : 1px solid #1e90ff;
		padding: 10px;	
	}
	
	
	th {
		width: 130px;
		text-align: center;
		background-color: #0078ff;
		color: white;
	}
	
	#btn {
	text-align: center;
	}
	
	h1 {
		color : #0078ff;	
	}
		
	.insertComment th {
		border : 1px solid #1e90ff;
		width: 130px;
		text-align: center;
		background-color: #00a5ff;
		color: white;
	}

	.viewComment th {
		border : 1px solid #1e90ff;
		width: 130px;
		text-align: center;
		background-color: #87cefa;
		color: white;
	}
	.viewComment td{
		text-align: center;
	} 
	
	.viewComment #num  {
		width:50px;
	}
	.viewComment #writer  {
		width:100px;
	}
	.viewComment #con  {
		width:250px;
	}
	.viewComment #date  {
		width:100px;
	}
	.viewComment #del  {
		width:50px;
	}
	textarea {
		resize: none;
	}
</style>
</head>
<body>
	<div>
		<h1>${bvo.b_idx } 번 게시글</h1>
		<form method="post">
			<table class="bbs">
				<tbody>
					<tr>
						<th>작성자</th>
						<td>${bvo.writer }</td>
						<th>IP</th>
						<td>${bvo.ip}</td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="3">${bvo.title }</td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td colspan="3">
							<c:choose>
								<c:when test="${bvo.filename eq null }">
									첨부파일 없음
								</c:when>
								<c:otherwise>
									<a 다운로드 걸어주기>${bvo.filename }</a>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3">${bvo.content }</td>
					</tr>
					<tr>
						<td colspan="4" id="btn">
							<input type="button" value="게시글 수정하기" onclick="update_page(this.form)">
							<input type="button" value="게시글 삭제하기" onclick="remove_page(this.form)">
							<input type="button" value="목록으로 이동" onclick="view_all(this.form)">
							<input type="hidden" name="currentPage" value="<%=currentPage %>">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>





</body>
</html>





