<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 	request.setCharacterEncoding("utf-8");   /// 한글 안깨지게하기 (받는쪽에서 인코딩 필수!)
 	
 	String name = request.getParameter("name");
 	int age = Integer.parseInt(request.getParameter("age")); //  형 변환 해줘야함 int 등 ;
 	String[] pet = request.getParameterValues("pet"); // checkbox이기 떄문에 ParameterValues로 받아야함
 	String info = request.getParameter("info");
 	
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>이름 : <%= name %></li>
		<li>나이 : <%= age %></li>
		<li>반려동물 :
			<% if(pet != null ){%>
				<% for(int i = 0; i < pet.length; i++){ %>
				<li> 동물 : <%= pet[i] %></li>
				<%}%>
			<%}else{%>
					없음
			<%}%>
		</li>	
		<li>자기소개 : <%= info %></li>
		
	</ul>
</body>
</html>