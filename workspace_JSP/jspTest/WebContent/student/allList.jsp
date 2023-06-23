<%@page import="org.joonzis.vo.StudentVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="org.joonzis.dao.StudentDAO"%>
<%@page import="org.joonzis.model.Paging"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<script type="text/javascript">
	onload = function(){
		var btn = document.querySelector("#btn");
	btn.onclick = function(f) {
		location.href = '/jspTest/MainController?cmd=insert_page';
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
</head>
<body>
	<div class="wrap">
			<c:if test="${not empty member }">
				<button onclick="goLogOut();">로그아웃</button>
				<div>안녕하세요</div>
				<h3>${member.mid} 님!</h3>
			</c:if>
			<c:if test="${empty member }">
				<button class="button" onclick="goLoginPage();">로그인</button>
				<button class="button" onclick="goJoinPage();">회원가입</button>
			</c:if>
		<h2>공지 사항</h2>
		<c:if test="${not empty member }">
			<button id="btn">글쓰기</button>
		</c:if> 
		<!-- 왼쪽 메뉴 바 생성 -->
		<div class = "header-menu">
			<ul>
				
			  <li><a class="home" href="/jspTest/MainController?cmd=allList">홈</a></li>
			  <li><a href="/jspTest/ScoreController?cmd=score_allList">학점 확인</a></li>
			  <li><a href="/jspTest/MainController?cmd=calendar">시간표</a></li>
			  <li><a href="/jspTest/FreeController?cmd=free_write">자유게시판</a></li>
			  <li><a href="/jspTest/VolController?cmd=volunteer_main">자기소개서</a></li>
			</ul>
		</div>
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>내용</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<!-- 게시물이 없으면 : "게시물이 없습니다" 출력 -->
				<c:choose>
					<c:when test="${empty list }">
						<tr>
							<td colspan="5">작성된 게시물이 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="vo" items="${list2 }">
							<tr style="color: red; border: 1px solid #D1B2FF;">
								<th style= "border: 1px solid black">${vo.s_idx }</th>
								<th>${vo.sname }</th>
								<th><a href="MainController?cmd=view&s_idx=${vo.s_idx }">${vo.stitle }</a></th>
								<th>${vo.join_date }</th>
								<th>${vo.hit }</th>
								<th><input type="hidden" name="s_idx" value="${vo.s_idx }"></th>
							</tr>
						
						</c:forEach>

						<c:forEach var="vo" items="${list }">
							<tr>
								<td >${vo.s_idx }</td>
								<td>${vo.sname }</td>
								<td><a href="MainController?cmd=view&s_idx=${vo.s_idx }">${vo.stitle }</a></td>
								<td>${vo.join_date }</td>
								<td>${vo.hit }</td>
								<td><input type="hidden" name="s_idx" value="${vo.s_idx }">
							</tr>
						</c:forEach>
					
					</c:otherwise>
				</c:choose>
			</tbody>
			 <tfoot>
				<tr>
                  <td colspan="5">
                     <!-- 페이징 처리예정      
                     1. 이전 버튼  -->           
                     <c:choose>
                        <c:when test="${pvo.beginBlock <= pvo.pagePerBlock }">
                              <span class ="disable"> ◀ &nbsp; </span>
                        </c:when>
                        <c:otherwise>
                              <a class="view" href="/jspTest/MainController?cmd=allList&currentPage=${pvo.beginBlock - 1 }"> ◀ &nbsp; </a>
                        </c:otherwise>
                     </c:choose>      
                     <!-- 2. 페이지 번호 -->         
                     <c:forEach var="p" begin="${pvo.beginBlock }" end="${pvo.endBlock }" step="1">
                        <c:choose>
                           <c:when test="${p eq pvo.nowpage }">
                              <span class="now">${p }&nbsp;</span>
                           </c:when>
                           <c:otherwise>
                               <a class="view" href="/jspTest/MainController?cmd=allList&currentPage=${p}"> ${p }&nbsp;</a>
                           </c:otherwise>
                        </c:choose>   
                     </c:forEach>        
                    <!--  3. 다음 버튼 -->                  
                     <c:choose>
                        <c:when test="${pvo.endBlock >= pvo.totalPage  }">
                           <span class ="disable"> &nbsp;▶ </span>
                        </c:when>
                        <c:otherwise>
                           <a class="view" href="jspTest/MainController?cmd=allList&currentPage=${pvo.beginBlock + pvo.pagePerBlock }" > &nbsp;▶ </a>
                        </c:otherwise>
                     </c:choose>   
                  </td>
               </tr>
			</tfoot> 
		</table>
	</div>
</body>
</html>