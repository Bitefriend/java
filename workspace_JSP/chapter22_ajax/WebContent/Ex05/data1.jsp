<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(function(){
			let msg = '<ul>';
		$.ajax({
			url : "xml_data.xml",				// 읽어올 경로
			dataType : "xml",					// 읽어올 정보의 타입
			type : "get",						// 요청 방식
			success : function(result){			// 성공 시 할 일
				
			},
			error : function(){				// 에러 발생 시 할 일
				
				
			}
		});
		msg += '</ul>'
	});
</script>
</head>
<body>

</body>
</html>