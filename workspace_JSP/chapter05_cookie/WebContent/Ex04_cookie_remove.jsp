<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <!-- 
 	쿠키 삭제는 기존 쿠키의 유효시간을 0으로 한다.
 	
 	1. 이름이 name인 쿠키 삭제
 	
  -->
  <% 
	Cookie[] cookieBox = request.getCookies();

  	if(cookieBox != null && cookieBox.length > 0){
		for(int i = 0; i<cookieBox.length; i++){
			if(cookieBox[i].getName().equals("name")){
				Cookie cookies = new Cookie("name","");
				cookies.setMaxAge(0);
				response.addCookie(cookies);
				out.print("쿠키 값 삭제함");
				}
			}
		}else{
			out.print("쿠기없슴");
		}
  %>
</body>
</html>