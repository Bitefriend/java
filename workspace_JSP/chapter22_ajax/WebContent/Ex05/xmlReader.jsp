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
			$.ajax({
				url : "xml_data.xml",				// 읽어올 경로
				dataType : "xml",					// 읽어올 정보의 타입
				type : "get",						// 요청 방식
				success : function(result){
					
					var msg = '<ul>';
			
					$(result).find("people").each(function(){
						var name = $(this).find("name").text();
						var age = $(this).find("age").text();
					
						msg += "<li>이름 : " + name + "</li>";
						msg += "<li>나이 : " + age + "</li>";
				});
				msg += '</ul>';
				
				$("#content").html(msg);
				
			},
			error : function(){ // 에러발생 시 할 일	
			}
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