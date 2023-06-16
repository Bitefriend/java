<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	//페이지로드
	$(function(){
		$("#btn").click(function(){
			
			let msg = '<ul>';
			// get 방식의 페이지 로드
			$.get("xml_data.xml", function(data){
				// data매개변수 : xml_data.xml 파일을 읽은 내용
				
				// jQuery.find()
				// 어떤 요소의 하위 요소 중 특정 요소를 찾을 때 사용
				$(data).find("person").each(function(){
					let name = $(this).find("name").text();
					let age = $(this).find("age").text();
					
					msg += "<li>이름 : " + name + "</li>";
					msg += "<li>나이 : " + age + "</li>";
				});
				
				$("#content").html(msg);
				
			});
			
			
			msg += '</ul>';
		});
	});
</script>
</head>
<body>
	<button id="btn">가져오기</button>
	<br> <br>
	
	<div>
		<h1 style="color : maroon;">xmlReader.jsp</h1>
		<div id="content"></div>
	</div>
</body>
</html>