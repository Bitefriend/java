<%@page import="java.util.List"%>
<%@page import="org.joonzis.ex.CVO"%>
<%@page import="org.joonzis.ex.BVO"%>
<%@page import="org.joonzis.ex.BDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <%
 	
    	request.setCharacterEncoding("utf-8");
    	int b_idx = Integer.parseInt(request.getParameter("b_idx"));
    	String currentPage = request.getParameter("currentPage");
    	// dao에서 데이터 가져오기
    	
    	BVO bvo = BDAO.selectById(b_idx);
    	//수정 삭제 기능에서 사용하기 편함
    	session.setAttribute("bvo", bvo);
    	session.setAttribute("currentPage", currentPage);
    	
    	// -----------------조회 수 처리 ----------------
    	/* 
    		처음으로 view를 열었을 때에만 조회수가 증가
    		게시물을 열 때 session에 open이라는 값을 저장 
    		session에 open 값이 있으면 조회수를 증가시키지 않고, open 값이 없을 때에만 조회 수 증가
    	*/
    	String open = ( String)session.getAttribute("open");
    	if(open == null){
    		//open이 null이면 해당 게시물을 처음 열었다는 의미
    		session.setAttribute("open", "yes"); // value 값은 의미없음
    		int hit = bvo.getHit() + 1;
    		bvo.setHit(hit);
    		BDAO.getUpdateHit(bvo);
    	}
    	
    	/* -----------------댓글 보기--------------- */
   
    	
    	List<CVO> cvo = BDAO.cvoView(b_idx);
    	pageContext.setAttribute("cvo", cvo);
    	/* int result = BDAO.cvoView(cvo);
    	session.setAttribute("result", result); */
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
 h2 {
      color : #0078ff;   
   }
 table {
      width: 100%;
		border-collapse: collapse;
		text-align: left;
   }
   
   td, th {
      border : 1px solid #1e90ff;
      padding: 10px;
   }
   th{
  		width : 100px;
	  	background-color: #0078ff;
	  	color : #fff;
	  	text-align: center;
   }
 
</style>
<script type="text/javascript">
function insert_comment(f) {
	if(f.writer.value == ''){
		alert("작성자를 입력하세요.");
		return	;
	}
	f.action = "insert_comment.jsp";
	f.submit();
}
</script>
</head>
<body>
<div>
	<h2>${bvo.writer }의 게시글</h2>
		<form action="post">
		<table>
			<tbody>
				<tr>
					<th>작성자</th>
					<td>${bvo.writer }</td>
					<th>IP</th>
					<td>${bvo.ip }</td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="3">${bvo.title }</td>
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
					<td colspan="3">${bvo.reg_date }</td>
				</tr>
				<tr>
					<td colspan="4" id = "btn">
						<input type="button" value="게시글 수정" onclick="location.href='update_page.jsp'">
						<input type="button" value="게시글 삭제" onclick="location.href='remove_page.jsp'">
						<input type="button" value="목록으로 이동" onclick="location.href='index.jsp?currentPage=${param.currentPage}'">
						
					</td>
				</tr>
			</tbody>
		</table>
		</form>
		
		
		
		<br> <hr> <br>
		
		<!-- 댓글 입력 폼 -->
		<form method="post">
			<table>
				<tbody>
					<tr>
						<th>댓글 작성자 </th>
						<td><input type="text"name="writer"></td>
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
			<input type="hidden" name="b_idx" value="${bvo.b_idx }">
			<input type="hidden" name="currentPage" value="<%=currentPage%>">
		
		</form>
		
		<br> <hr> <br>
		
		
		<%
		
		%>
		
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
						<input type="button" value="댓글 삭제" onclick="location.href = 'remove_comment.jsp?c_idx=${cvo.c_idx}&b_idx=${cvo.b_idx }&currentPage=${currentPage}'">
						</td>

					</tr>
					</c:forEach>
					</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</form>
		
		
		
		
		
		
		
	</div>
</body>
</html>