<%@page import="org.joozis.ex.GreenVO"%>
<%@page import="org.joozis.ex.GreenDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function update(f) {
		f.action = "update.jsp";
		f.submit();
	}
</script>
</head>
<body>
<jsp:include page="index.jsp"/>
	
	<br> <hr> <br>
<%
	request.setCharacterEncoding("UTF-8");
	GreenVO dto = new GreenVO();
	
   	String id = request.getParameter("id");
   	String pw = request.getParameter("pw"); 
   	
   	dto.setId(id);
   	dto.setPw(pw);
   	
   	GreenVO resultDto = GreenDao.getInstance().getUpdate(dto);
   	pageContext.setAttribute("dto", resultDto);
		

%>
<form action="">
			<h1>member 테이블의 개별 데이터</h1>
			<table>
				<thead>
					<tr>
						<th>회원 번호 </th>
						<th>아이디 </th>
						<th>비밀번호 </th>
						<th>이름 </th>
						<th>나이 </th>
						<th>주소 </th>
						<th>가입일 </th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty result }">
						<tr>
							 <td colspan="7">member가 없습니다.</td>
						</tr>
						</c:when>
						<c:otherwise>
						<tr>
							<td>
								${dto.idx }
								<input type="hidden" name="idx" value="${dto.idx }">
							</td>
							<td>
								${dto.id }
								
							</td>
							<td><input type="password" name="pw" value="${dto.pw }"></td>
							<td><input type="text" name="name" value="${dto.name }"></td>									
							<td><input type="number" name="age" value="${dto.age }"></td>
							<td><input type="text" name="addr" value="${dto.addr }"></td>
							<td>
							${dto.reg_date }
							</td>
						</tr>	
						</c:otherwise>
					</c:choose>				
				</tbody>
				<tfoot>
					<tr>
						<th colspan ="7">
							<input type="button" value="수정" onclick="update(this.form)">&nbsp;&nbsp;
							<input type="reset" value="다시 작성">
						</th>
					</tr>
				</tfoot>
			</table>
			</form>

</body>
</html>