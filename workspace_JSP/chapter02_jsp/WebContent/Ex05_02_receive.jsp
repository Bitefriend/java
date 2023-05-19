<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	request.setCharacterEncoding("utf-8");   
 	
 	String name = request.getParameter("name");
 	int age = Integer.parseInt(request.getParameter("age")); //  형 변환 해줘야함 int 등 ;
 	String phone = request.getParameter("phone"); //  형 변환 해줘야함 int 등 ;
 	String gender = request.getParameter("gender");
 	String[] hobbies = request.getParameterValues("hobbies");
 	String[] addr = request.getParameterValues("addr"); 
 	String[] foods = request.getParameterValues("foods"); 
 	
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
		<li>전화 : <%= phone %></li>
		<li>성별 : <%= gender %></li>
		<li>취미 :
			<% if(hobbies != null){%>
				<% for(int i = 0; i < hobbies.length; i++){ %>
						<%= hobbies[i] %>
				<%}%>
			<%}else{%>
				취미도 없냐
				<%}%>
		</li>
		<li>주소 :
			<% if(addr != null ){%>
			<% for(int i = 0; i < addr.length; i++){ %>
				 	<%= addr[i] %>
				<%}%>
			<%}else{ %>
					주소도 없냐
			<%}%>
		</li> 
		<li>음식 : 
			<% if(foods != null ){%>
			<% for(int i = 0; i < foods.length; i++){ %>
				 	<%= foods[i] %>
				<%}%>
			<%}else{ %>
					좋아하는 것도 없냐
			<%}%>
		</li> 
		</ul>
</body>
</html>