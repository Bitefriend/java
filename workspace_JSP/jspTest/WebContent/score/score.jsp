<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학점</title>
<style type="text/css">
/* 버튼 css */
button{
  background:#1AAB8A;
  color:#fff;
  border:none;
  position:relative;
  height:35px;
  font-size:1.2em;
  padding:0 2em;
  cursor:pointer;
  transition:800ms ease all;
  outline:none;
}
button:hover{
  background:#fff;
  color:#1AAB8A;
}
button:before,button:after{
  content:'';
  position:absolute;
  top:0;
  right:0;
  height:2px;
  width:0;
  background: #1AAB8A;
  transition:400ms ease all;
}
button:after{
  right:inherit;
  top:inherit;
  left:0;
  bottom:0;
}
button:hover:before,button:hover:after{
  width:100%;
  transition:800ms ease all;
}
</style>
<style type="text/css">
		/* 왼쪽 메뉴 게시판 css */
	  ul {
	  list-style-type: none;
	  padding: 0px;
	  margin: 0px;
	  width: 100px;
	  background: #D1B2FF;
	  height: 100%;
	  overflow: auto;
	  position: fixed;
	}
	
	li a {
	  text-decoration: none;
	  padding: 10px;
	  display: block;
	  color: #000;
	  font-weight: bold;
	}
	
	li a:hover {
	  background: #333;
	  color: #fff;
	}
	
	li a.home {
	  background : #333;
	  color: #fff;
	}
	
	.cd1 {
	  margin-left: 120px;
	}
</style>
<style type="text/css">
	div {
      width: 800px;
      margin:auto;
      text-align: center;   
   }
    table {
      width: 800px;
      border-collapse: collapse;   
   }	
</style>
<script type="text/javascript">
	function update_insert(f) {
		f.action = "/jspTest/ScoreController";
		f.submit(); 
	}
	onload = function(){
		var btn = document.querySelector("#btn");
	btn.onclick = function(f) {
		alert("업데이트 예정");
		/* location.href = '/jspTest/ScoreController?cmd=insert_page'; */
	}
	}
	function goLoginPage() {
		location.href='MemberController?cmd=loginPage';
	}
	function goJoinPage() {
		location.href='MemberController?cmd=joinPage';
	}
	function goLogOut() {
		location.href='MemberController?cmd=logout';
	}
</script>
</head>
<body>
	<div>
			<c:if test="${not empty member }">
				<button onclick="goLogOut();">로그아웃</button>
				<div>안녕하세요</div>
				<h3>${member.mid} 님!</h3>
			</c:if>
			<c:if test="${empty member }">
				<button onclick="goLoginPage();">로그인</button>
				<button onclick="goJoinPage();">회원가입</button>
			</c:if>
	<h2>학점</h2>
	<c:if test="${not empty member }">
			<button id="btn">성적 입력하기</button>
		</c:if>
	<div class = header-menu>
	<ul>
	  <li><a href="/jspTest/MainController?cmd=allList">홈</a></li>
	  <li><a class="home" href="/jspTest/MainController?cmd=score">학점 확인</a></li>
	  <li><a href="/jspTest/MainController?cmd=calendar">시간표 확인</a></li>
	  <li><a href="/jspTest/FreeController?cmd=free_write">자유게시판</a></li>
	  <li><a href="/jspTest/MainController?cmd=">자개소개서 공유</a></li>
	</ul>
	</div>
	<form method="post">
		<table>
			<thead>
				<tr>
					<th>학번</th>
					<th>중간고사</th>
					<th>기말고사</th>
					<th>과제</th>
					<th>발표</th>
					<th>상세보기</th>
				</tr>
			</thead>
			<tbody>
				<!-- 학점이 없으면 : "학점이 없습니다" 출력 -->
				<c:choose>
					<c:when test="${empty list }">
						<tr>
							<td colspan="5">학점이 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var = "vo" items="${ list}">
							<tr>
								<td>${vo.midx }</td>
								<td>${vo.sub1 }</td>
								<td>${vo.sub2 }</td>
								<td>${vo.sub3 }</td>
								<td>${vo.sub4 }</td>
								<td><a href="/jspTest/ScoreController?cmd=view&ss_idx=${vo.ss_idx }">성적 상세보기</a></td>

								<td><input type="hidden" name="cmd" value="update_page"></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</form>
	</div>
</body>
</html>