<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<style type="text/css">
div {
      width: 800px;
      margin:auto;
      text-align: center;   
   }
    table {
      width: 800px;
      border-collapse: collapse;   
   }	
</style>
<script type="text/javascript">
function insert_comment(f) {
	if(f.writer.value == ''){
		alert("작성자를 입력하세요.");
		return	;
	}
	f.action = "/jspTest/MainController";
	f.submit();
}
function remove_comment(f) {
	f.action = "/jspTest/MainController";
	f.submit();
}
</script>
</head>
<body>
<div>
	<h2>${bvo.sname }의 공지사항</h2>
		<form action="post">
		<table>
			<tbody>
				<tr>
					<th>작성자</th>
					<td>${bvo.sname }</td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="3">${bvo.stitle }</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<c:choose>
						<c:when test="${bvo.filename eq null }">
							<td colspan="3">첨부파일 없음</td>
						</c:when>
						<c:otherwise>
							<td colspan="3"><a href="download.jsp?path=upload&filename=${bvo.filename}">${bvo.filename }</a></td>	
						</c:otherwise>
					</c:choose>	
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3">${bvo.content }</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td colspan="3">${bvo.join_date }</td>
				</tr>
				<tr>
					<td colspan="4" id = "btn">
						<input type="button" value="게시글 수정" onclick="location.href='/jspTest/MainController?cmd=update_page'">
						<input type="button" value="게시글 삭제" onclick="location.href='/jspTest/MainController?cmd=remove'">
						<input type="button" value="목록으로 이동" onclick="location.href='/jspTest/MainController?cmd=allList&currentPage=${session.currentPage}'">
					</td>
				</tr>
			</tbody>
		</table>
		</form>
		
		<br> <hr> <br>
		
		<%-- <!-- 댓글 입력 폼 -->
		 <form method="post">
			<table>
				<tbody>
					<tr>
						<th>댓글 작성자 </th>
						<td><input type="text"name="writer" value="${member.mid }" readonly="readonly"></td>
						<th>댓글 비밀번호 </th>
						<td> <input type="password" name="pw"></td>
					</tr>
					<tr>
						<th>댓글 내용</th>
						<td colspan="3">
							<textarea rows="3" cols="80"name="content"></textarea>
						</td>
					</tr>
					<tr>
					<td colspan="4" id="btn">
						<input type="button" value="댓글 등록 " onclick="insert_comment(this.form)">
						<input type="reset" value="다시 작성">
					</td>
					</tr>
				</tbody>
			</table>
			<input type="hidden" name="cmd" value="insert_com">
			<input type="hidden" name="m_idx" value="${member.m_idx }">
			<input type="hidden" name="currentPage" value="<%=currentPage%>">
		
		</form>
		
		<br> <hr> <br>
		
		<form method="post">
			<table>
				<thead>
					<tr>
						<th>번호 </th>
						<th>댓글 작성자 </th>
						<th>댓글 내용</th>
						<th>IP</th>
						<th>작성 날짜</th>
						<th>댓글 삭제</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
					<c:when test="${empty cvo }">
						<tr>
							<td colspan="6">작성된 댓글이 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
					<c:forEach var="cvo" items="${cvo }">
					<tr>
						<td>${cvo.c_idx }</td>
						<td>${cvo.writer }</td>
						<td>${cvo.content}</td>
						<td>${cvo.ip}</td>
						<td>${cvo.reg_date}</td>
						<td>
						<input type="button" value="댓글 삭제" onclick="remove_comment(this.form)">
						<input type="hidden" value="${cvo.c_idx }" name="c_idx">
						<input type="hidden" value="${cvo.b_idx }" name="s_idx">
						<input type="hidden" value="remove_comment" name="cmd">
						</td>
					</tr>
					</c:forEach>
					</c:otherwise>
					</c:choose>
				</tbody>
			</table>		
		</form>  --%>
	</div>
</body>
</html>