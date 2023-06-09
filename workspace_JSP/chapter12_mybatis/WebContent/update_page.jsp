<%@page import="org.joonzis.ex.GreenDao"%>
<%@page import="org.joonzis.ex.GreenVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>    	
<%
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		GreenVO vo = new GreenVO();
		/* vo.setId(id);
		vo.setPw(pw); */
		GreenDao dao = GreenDao.getInstance();
		GreenVO vo2 = dao.getUserInfoById(id);
		pageContext.setAttribute("vo2", vo2);
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<script type="text/javascript">
	function update(f) {
		if ( f.pw.value == "" || f.age.value == "" ||f.addr.value == ""||f.name.value == "") {
			alert("수정 할 회원의 정보를 먼저 입력하세요.");
			f.pw.focus();
			return;
		}
		f.action = "update.jsp";
		f.submit();
	}
</script>
</head>
<body>
	
	<jsp:include page="index.jsp" />
	
	<br /><hr /><br />
	

	
	<div>
		<h1>${param.id } 회원의 정보</h1>
		<form method="post">
			<table>
				<tbody>
					<c:if test="${vo2 ne null }">
						<tr>
							<td>순번</td>
							<td>${vo2.idx }<input type="hidden" name="idx" value="${vo2.idx }" /></td>
						</tr>
						<tr>
							<td>아이디</td>
							<td>${vo2.id }<input type="hidden" name="id" value="${vo2.id }" /></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="pw" value="${vo2.pw }" size="50" /></td>
						</tr>
						<tr>
							<td>성명</td>
							<td><input type="text" name="name" value="${vo2.name }" size="50" /></td>
						</tr>
						<tr>
							<td>나이</td>
							<td><input type="text" name="age" value="${vo2.age }" size="50" /></td>
						</tr>
						<tr>
							<td>주소</td>
							<td><input type="text" name="addr" value="${vo2.addr }" size="50" /></td>
						</tr>
						<tr>
							<td>가입일</td>
							<td>${vo2.reg_date }<input type="hidden" name="reg_date" value="${vo2.reg_date }" /></td>
						</tr>
					</c:if>
					<c:if test="${vo2 eq null }">
						<tr>
							<td colspan="2">${param.id } 회원의 정보가 없습니다.</td>
						</tr>
					</c:if>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<c:if test="${vo2 ne null }">
								<input type="button" value="회원 정보 수정" onclick="update(this.form)"/>&nbsp;&nbsp;
								<input type="reset" value="다시 작성" />&nbsp;&nbsp;
							</c:if>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
	
</body>
</html>