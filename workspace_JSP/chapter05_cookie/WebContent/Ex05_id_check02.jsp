<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    
   	Cookie cookie = null;
    String id = request.getParameter("id");
    String save_id = request.getParameter("save_id");
    
    // 아이디 기억하기를 체크 및 체크 해제 했을 때
    if(save_id != null){
    	cookie = new Cookie("save_id", id);
    	cookie.setMaxAge(60*60*24);
    	response.addCookie(cookie);
    }else{
    	//기존에 만들었던 "save_id" 쿠키 확인 후 삭
		Cookie[] cookieBox = request.getCookies();
    	
    	if(cookieBox != null && cookieBox.length > 0){
    		for(int i = 0; i<cookieBox.length; i++){
    			if(cookieBox[i].getName().equals("save_id")){
    				Cookie cookies = new Cookie("save_id","");
    				cookies.setMaxAge(0);
    				response.addCookie(cookies);
    				out.print("쿠키 값 삭제함");
    				break;
    			}
    		}
    	}
    }	
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Ex05_id_check.jsp">
		<input type="submit" value="로그인 화면 돌아가기">
	</form>
</body>
</html>