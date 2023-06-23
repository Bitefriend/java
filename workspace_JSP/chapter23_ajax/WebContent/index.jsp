<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">

	// 1. CSV : 콤마로 구분된 일반 텍스트 파일
	// 김, 30, 서울
	function getCSV() {
		$.ajax({
			url : "MemberController?cmd=csv",				// 읽어올 경로
			dataType : "text",					// 읽어올 정보의 타입
			type : "post",						// 요청 방식
			success : function(data){			// 성공 시 할 일
				var result = '';
				var members = data.split("/");
				var member;
				for (var i = 0; i < members.length; i++) {
					result += "<tr>";
					member = members[i].split(",");
					for (var j = 0; j < member.length; j++) {
						result += "<td>" + member[j] + "</td>";
					}
					result += "</tr>";
				}
				$("#content").html(result);
				$("#typeCheck").text("CSV 가져오기");
			},
			error : function(){				// 에러 발생 시 할 일
				alert("실패");
			}
		});
	}
	function getXmlTag() {
		$.ajax({
			url : "MemberController?cmd=xmlTag",				// 읽어올 경로
			dataType : "text",								// 읽어올 정보의 타입
			type : "post",								// 요청 방식
			success : function(data){					// 성공 시 할 일
				console.log(data)
				
				var result = '';
				$(data).find("member").each(function(){
					result += '<tr>';
					result += '<td>' + $(this).find("idx").text() + "</td>";
					result += '<td>' + $(this).find("id").text() + "</td>";
					result += '<td>' + $(this).find("pw").text() + "</td>";
					result += '<td>' + $(this).find("name").text() + "</td>";
					result += '<td>' + $(this).find("email").text() + "</td>";
					result += '<td>' + $(this).find("phone").text() + "</td>";
					result += '<td>' + $(this).find("addr").text() + "</td>";
					result += '</tr>';
				})
			$("#content").html(result);
			$("#typeCheck").text("XML(태그) 가져오기");
		},
		error : function(){				// 에러 발생 시 할 일
			alert("실패");
		}
	})
	}
	function getXmlProp() {
		$.ajax({
			url : "MemberController?cmd=xmlProp",				// 읽어올 경로
			dataType : "text",					// 읽어올 정보의 타입
			type : "post",						// 요청 방식
			success : function(data){			// 성공 시 할 일
				var result = '';
				$(data).find("member").each(function(){
					result += '<tr>';
					result += '<td>' + $(this).attr("idx") + "</td>";
					result += '<td>' + $(this).attr("id") + "</td>";
					result += '<td>' + $(this).attr("pw") + "</td>";
					result += '<td>' + $(this).attr("name") + "</td>";
					result += '<td>' + $(this).attr("email") + "</td>";
					result += '<td>' + $(this).attr("phone") + "</td>";
					result += '<td>' + $(this).attr("addr") + "</td>";
					result += '</tr>';
			})
			$("#content").html(result);
			$("#typeCheck").text("XML(속성) 가져오기");
		},
		error : function(){				// 에러 발생 시 할 일
			alert("실패");
		}
	})
	}
	function getJSON() {
		$.ajax({
			url : "MemberController?cmd=json",				// 읽어올 경로
			dataType : "json",					// 읽어올 정보의 타입
			type : "post",						// 요청 방식
			success : function(data){			// 성공 시 할 일
				var result = '';
				for (var i = 0; i < data.length; i++) {
					
					result += '<tr>';
					result += '<td>' + data[i].idx + "</td>";
					result += '<td>' + data[i].id + "</td>";
					result += '<td>' + data[i].pw + "</td>";
					result += '<td>' + data[i].name + "</td>";
					result += '<td>' + data[i].email + "</td>";
					result += '<td>' + data[i].phone + "</td>";
					result += '<td>' + data[i].addr + "</td>";
					result += '</tr>';
				}
				
			
			$("#content").html(result);
			$("#typeCheck").text("JSON 가져오기");
		},
		error : function(){				// 에러 발생 시 할 일
			alert("실패");
		}
	})
	}
	
</script>
</head>
<body>
	<div>
		<h1>ajax 처리하기</h1>
		<button style="color: purple;" onclick="getCSV()">CSV 가져오기</button>
		<button style="color: purple;" onclick="getXmlTag()">XML(태그) 가져오기</button>
		<button style="color: purple;" onclick="getXmlProp()">XML(속성) 가져오기</button>
		<button style="color: purple;" onclick="getJSON()">JSON 가져오기</button><br>
		
		<br> <hr> <br>
		
		<!-- member 데이터 -->
		
		<table border="1">
			<thead>
				<tr>
					<th>번호</th>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이름</th>
					<th>이메일</th>
					<th>연락처</th>
					<th>주소</th>
				</tr>
			</thead>
			<tbody id="content">
				<!-- ajax로 채워질 부분 -->
			</tbody>
		</table>
		
		<br> <hr> <br>
		
		<div id="typeCheck"></div>
	</div>
</body>
</html>