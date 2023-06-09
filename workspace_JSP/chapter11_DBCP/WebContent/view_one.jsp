
<%@page import="org.joozis.ex.GreenDao"%>
<%@page import="org.joozis.ex.GreenVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="index.jsp"/>
	<br> <hr> <br>
    <%
   		request.setCharacterEncoding("utf-8");
    	String id = request.getParameter("id");	
    	
    	
    	GreenVO result = GreenDao.getInstance().getPerList(id);
    	pageContext.setAttribute("result", result);
    %>
			<h1>Green 테이블의 개별 데이터</h1>
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
								<td>${result.idx }</td>
								<td>${result.id }</td>
								<td>${result.pw }</td>
								<td>${result.name }</td>							
								<td>${result.age }</td>
								<td>${result.addr }</td>																	
								<td>${result.reg_date }</td>																	
							</tr>
						</c:otherwise>
					</c:choose>	
				</tbody>
			</table>
</body>
</html>