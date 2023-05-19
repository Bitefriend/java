<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>0~9 사이의 모든 정수 출력하기</h2>
	<%for(int i=0; i<10; i++){%>
		 i 
	<%}	%>
	
	<h2>0~9 사이의 모든 정수 출력하기</h2>

	<%for(int i=0; i<10; i++){%>
		 <%=i %>
	<%}	%>
	
	<h2>1~100사이의 합</h2>
	<%
	int total = 0;
	for(int i=1; i<101; i++){
		total +=i;
		 
	}	
	%>
	1~100사이의 합 + <%=total %>
	
	<h2>1~100사이의 모든 짝수의 합계를 리턴 하는 even() 메소드</h2>
	<%!
		public int even(){
			int total1 = 0;
			for(int i=1; i<101; i++){
				if(i % 2 == 0){
				total1 += i;
				}
			}
			return total1;
		}
		
	%>
		1~100사이의 합 + <%=even()%>
	
	<h2>1~100사이의 모든 홀수의 합계를 리턴 하는 odd() 메소드</h2>
	<%!
		public int odd(){
			int total2 = 0;
			for(int i=1; i<101; i++){
				if(i % 2 == 1){
					total2 += i;
				}
			}
			return total2;
		}
	
	%>
		1~100사이의 합 + <%=odd()%>
	
</body>
</html>