
<%@page import="org.joozis.ex.GreenDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%
     
    request.setCharacterEncoding("utf-8");
     
/*  int idx = Integer.parseInt(request.getParameter("idx"));
   	String id = request.getParameter("id");
   	String pw = request.getParameter("pw"); 
   	String name = request.getParameter("name");
   	int age = Integer.parseInt(request.getParameter("age")); 
   	String addr = request.getParameter("addr");
   	
   	GreenDto dto = new GreenDto();
   	
   	dto.setIdx(idx);
   	dto.setId(id);
   	dto.setPw(pw);
   	dto.setName(name);
   	dto.setAge(age);
   	dto.setAddr(addr); */
   	%>
   	<jsp:useBean id = "dto" class="org.joonzis.ex.GreenVO"/>
   	<jsp:setProperty property = "*" name ="dto"/>
   	
   	<%
   		int result = GreenDao.getInstance().getUpdate2(dto);
   		pageContext.setAttribute("result", result);
   	%>
   	
   	<c:choose>
		<c:when test="${result gt 0 }">
			<script type="text/javascript">
				alert("회원이 수정되었습니다.");
				location.href = "view_all.jsp";
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("회원이 수정을 실패했습니다.");
				/* location.href="view_all.jsp"; */
				history.go(-1);
			</script>
		</c:otherwise>
	</c:choose>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>