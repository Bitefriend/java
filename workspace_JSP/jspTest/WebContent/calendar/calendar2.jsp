<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>달력</title>
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
	 /* 중앙 */
	
</style>
<script type="text/javascript">
	onload = function(){
		var btn = document.querySelector("#btn");
	btn.onclick = function(f) {
		location.href = '/jspTest/VolController?cmd=vol_insert_page';
	}
	}
	function goLoginPage() {
		location.href='/jspTest/MemberController?cmd=loginPage';
	}
	function goJoinPage() {
		location.href='/jspTest/MemberController?cmd=joinPage';
	}
	function goLogOut() {
		location.href='/jspTest/MemberController?cmd=logout';
	}
</script>
<script type="text/javascript">
	var dragging = false;
	var days = document.querySelectorAll('.day');
	var offset = 0;
	
	function activateDay() {
	  var activeElement = document.activeElement;
	  var activeAItem = document.querySelector('.active-a');
	  var activeBItem = document.querySelector('.active-b');
	  
	  if (activeAItem && activeBItem) {
	    clearActiveDays();
	    clearRange();
	    activeElement.classList.add('active-a');
	    return;
	  }
	  
	  if (activeAItem) activeElement.classList.add('active-b');
	  else activeElement.classList.add('active-a');
	}
	
	function clearActiveDays() {
	  var activeAItem = document.querySelector('.active-a');
	  var activeBItem = document.querySelector('.active-b');
	  
	  if (activeAItem) activeAItem.classList.remove('active-a');
	  if (activeBItem) activeBItem.classList.remove('active-b');
	}
	
	function clearRange() {
	  days.forEach(item => {
	    item.classList.remove('range');
	  });
	}
	
	function calculateRange() {
	  var activeAIndex, activeBIndex;
	
	  days.forEach((item, index) => {
	    if (item.classList.contains('active-a')) activeAIndex = index;
	    if (item.classList.contains('active-b')) activeBIndex = index;
	  });
	
	  if (activeAIndex < activeBIndex) {
	    for (var i = activeAIndex; i <= activeBIndex; i++) {
	      days[i].classList.add('range');
	    }
	  }
	
	  if (activeAIndex > activeBIndex) {
	    for (var i = activeAIndex; i >= activeBIndex; i--) {
	      days[i].classList.add('range');
	    }
	  }
	}
	
	function startMove(item) {
	  dragging = true;
	  
	  var activeAItem = document.querySelector('.active-a');
	  var activeBItem = document.querySelector('.active-b');
	  
	  if (!activeBItem && activeAItem) {
	    item.classList.add('active-b');
	    calculateRange();
	  } else {
	    clearActiveDays();
	    clearRange();
	    item.classList.add('active-a');
	  }
	}
	
	function move(item) {
	  if (dragging) {
	    var activeA = document.querySelector('.active-a');
	    var prevActiveB = document.querySelector('.active-b');
	
	    clearRange();
	
	    if (prevActiveB) prevActiveB.classList.remove('active-b');
	    if (!item.classList.contains('active-a')) item.classList.add('active-b');
	
	    var activeB = document.querySelector('.active-b');
	
	    calculateRange();
	  }
	}
	
	function endMove(item) {
	  dragging = false;
	}
	
	window.addEventListener('mouseup', e => {
	  dragging = false;
	});
	
	days.forEach((item, index) => {
	  var dayNumber = item.querySelector('.day-number').innerHTML;
	  
	  if (dayNumber === '1' && !item.classList.contains('next-mon')) {
	    offset = index;
	  }
	  
	  item.addEventListener('mousedown', e => {
	    startMove(item);
	  });
	  
	  item.addEventListener('mousemove', e => {
	    move(item);
	  });
	  
	  item.addEventListener('mouseup', e => {
	    endMove(item);
	  });
	});
	
	window.addEventListener('keyup', e => {
	  var key = e.keyCode;
	  
	  switch (key) {
	    case 13:
	      activateDay();
	      calculateRange();
	      break;
	  }
	});
	
	document.querySelector('.reset').addEventListener('click', e => {
	  clearActiveDays();
	  clearRange();
	});
</script>
<style type="text/css">
	*,
	*::before,
	*::after {
	  padding: 0;
	  margin: 0;
	  box-sizing: border-box
	}
	
	body {
	  display: flex;
	  min-height: 100vh;
	  padding: 5vh 5vw;
	  color: #37474f;
	  line-height: 1.5;
	  font-family: Lato, sans-serif;
	  background-color: #cfd8dc;
	}
	
	.note {
	  font-size: calc(0.5vw + 0.75rem);
	  text-align: center;
	  opacity: 0.5;
	}
	
	.button {
	  display: inline-block;
	  padding: 0.5em 1em;
	  color: #fff;
	  font-weight: bold;
	  font-size: 0.6875em;
	  text-align: center;
	  text-transform: uppercase;
	  letter-spacing: 0.0625em;
	  background-color: #37474F;
	  border-radius: 1.5em;
	  cursor: pointer;
	}
	
	.calendar-wrap {
	  width: 100%;
	  padding: 0.75em;
	  margin: auto;
	  font-size: 4vw;
	  background-color: #fff;
	  border-radius: 1.5em;
	  user-select: none;
	  box-shadow:
	    0 0.0625em 0.25em rgba(0,20,50,0.2),
	    0 0.5em 0.5em 0.125em rgba(0,20,50,0.1);
	}
	
	@media (min-width: 500px) {
	  .calendar-wrap {
	    width: 450px;
	    font-size: 1.25rem;
	  }
	}
	
	.month-year {
	  margin-bottom: 0.75em;
	  font-weight: normal;
	  font-size: 1.25em;
	  text-align: center;
	}
	
	.calendar {
	  table-layout: fixed;
	  width: 100%;
	  margin-bottom: 0.75em;
	  overflow: hidden;
	  border-collapse: collapse;
	  -webkit-tap-highlight-color: transparent;
	}
	
	.day-title {
	  width: 4em;
	  height: 4em;
	  vertical-align: top;
	  font-weight: bold;
	  font-size: 0.75em;
	  text-transform: uppercase;
	  letter-spacing: 0.0625em;
	  box-shadow:
	    inset 0 -0.875em #fff,
	    inset 0 -1em rgba(0,20,50,0.1);
	}
	
	.day {
	  position: relative;
	  height: 3em;
	}
	
	.day:focus {
	  outline: none;
	}
	
	.day:focus .day-number::after {
	  content: '';
	  position: absolute;
	  z-index: -1;
	  top: 50%;
	  left: 50%;
	  width: 80%;
	  height: 80%;
	  transform: translate(-50%,-50%);
	  border: 0.25em solid #0288d1;
	  border-radius: 50%;
	}
	
	.day.active-a:focus .day-number::after,
	.day.active-b:focus .day-number::after {
	  width: 100%;
	  height: 100%;
	}
	
	.day.today:focus .day-number::after {
	  width: 102%;
	  height: 102%;
	}
	
	.day:hover span.day-number {
	  color: #0288d1;
	}
	
	.day:first-child,
	.day:last-child {
	  color: rgba(0,0,0,0.5);
	}
	
	.day.range {
	  color: #0288d1;
	  background-color: #e1f5fe;
	}
	
	.day.range.active-a,
	.day:not(.range) + .day.range.active-b {
	  background-color: transparent;
	  box-shadow: inset -1.5em 0 #e1f5fe;
	}
	
	.day.range.active-b,
	.day.range + .day.range.active-a {
	  background-color: transparent;
	  box-shadow: inset 1.5em 0 #e1f5fe;
	}
	
	.day.range.active-a:first-child,
	.day.range.active-b:first-child {
	  box-shadow: none;
	}
	
	.day.range.active-a:first-child + .day.range,
	.day.range.active-b:first-child + .day.range {
	  box-shadow: -1.5em 0 #e1f5fe;
	}
	
	.day.range.active-a:first-child + .day:not(.range),
	.day.range.active-b:first-child + .day:not(.range) {
	  box-shadow: -4.5em 0 #e1f5fe;
	}
	
	.day.range.active-a:first-child + .day.range.active-b {
	  box-shadow:
	    -1.5em 0 #e1f5fe,
	    inset 1.5em 0 #e1f5fe;
	}
	
	.day-number {
	  position: relative;
	  z-index: 1;
	  display: flex;
	  justify-content: center;
	  align-items: center;
	  height: 3em;
	  border-radius: 50%;
	}
	
	.day.active-a span.day-number,
	.day.active-b span.day-number {
	  color: #fff;
	  background-color: #03A9F4;
	}
	
	.day.prev-mon .day-number,
	.day.next-mon .day-number {
	  color: rgba(0,0,0,0.3);
	}
	
	.day.prev-mon[class*="active"] .day-number,
	.day.next-mon[class*="active"] .day-number {
	  color: rgba(255,255,255,0.5);
	  background-color: #81D4FA;
	}
	
	.day.today span.day-number {
	  color: #fff;
	  border: 0.25em solid transparent;
	  box-shadow: inset 0 0 0 2em #37474F;
	}
	
	.calendar-wrap .reset {
	  display: block;
	}
	</style>
</head>
<body>
<div class="wrap">
			<c:if test="${not empty member }">
				<button onclick="goLogOut();">로그아웃</button><br>
				<div>안녕하세요
				<h3>${member.mid} 님!</h3>
				</div>
			</c:if>
			<c:if test="${empty member }">
				<button onclick="goLoginPage();">로그인</button><br>
				<button onclick="goJoinPage();">회원가입</button>
			</c:if>
	
		<!-- 왼쪽 메뉴 바 생성 -->
		<div class = "header-menu">
			<ul>
				
			  <li><a href="/jspTest/MainController?cmd=allList">홈</a></li>
			  <li><a href="/jspTest/ScoreController?cmd=score_allList">학점 확인</a></li>
			  <li><a class="home" href="/jspTest/MainController?cmd=calendar">시간표</a></li>
			  <li><a href="/jspTest/FreeController?cmd=free_write">자유게시판</a></li>
			  <li><a href="/jspTest/VolController?cmd=volunteer_main">자기소개서</a></li>
			</ul>
		</div>
	</div>
<div class="calendar-wrap">
  <h2 class="month-year">January 2020</h2>

  <table class="calendar">
    <thead>
      <tr>
        <th class="day-title" scope="col">Sun</th>
        <th class="day-title" scope="col">Mon</th>
        <th class="day-title" scope="col">Tue</th>
        <th class="day-title" scope="col">Wed</th>
        <th class="day-title" scope="col">Thu</th>
        <th class="day-title" scope="col">Fri</th>
        <th class="day-title" scope="col">Sat</th>
      </tr>
    </thead>
    <tbody>
      <tr class="week">
        <td class="day prev-mon" tabindex="0"><span class="day-number">29</span></td>
        <td class="day prev-mon" tabindex="0"><span class="day-number">30</span></td>
        <td class="day prev-mon" tabindex="0"><span class="day-number">31</span></td>
        <td class="day" tabindex="0"><span class="day-number">1</span></td>
        <td class="day today" tabindex="0"><span class="day-number">2</span></td>
        <td class="day" tabindex="0"><span class="day-number">3</span></td>
        <td class="day" tabindex="0"><span class="day-number">4</span></td>
      </tr>
      <tr class="week">
        <td class="day" tabindex="0"><span class="day-number">5</span></td>
        <td class="day" tabindex="0"><span class="day-number">6</span></td>
        <td class="day" tabindex="0"><span class="day-number">7</span></td>
        <td class="day" tabindex="0"><span class="day-number">8</span></td>
        <td class="day" tabindex="0"><span class="day-number">9</span></td>
        <td class="day" tabindex="0"><span class="day-number">10</span></td>
        <td class="day" tabindex="0"><span class="day-number">11</span></td>
      </tr>
      <tr class="week">
        <td class="day" tabindex="0"><span class="day-number">12</span></td>
        <td class="day" tabindex="0"><span class="day-number">13</span></td>
        <td class="day" tabindex="0"><span class="day-number">14</span></td>
        <td class="day" tabindex="0"><span class="day-number">15</span></td>
        <td class="day" tabindex="0"><span class="day-number">16</span></td>
        <td class="day" tabindex="0"><span class="day-number">17</span></td>
        <td class="day" tabindex="0"><span class="day-number">18</span></td>
      </tr>
      <tr class="week">
        <td class="day" tabindex="0"><span class="day-number">19</span></td>
        <td class="day" tabindex="0"><span class="day-number">20</span></td>
        <td class="day" tabindex="0"><span class="day-number">21</span></td>
        <td class="day" tabindex="0"><span class="day-number">22</span></td>
        <td class="day" tabindex="0"><span class="day-number">23</span></td>
        <td class="day" tabindex="0"><span class="day-number">24</span></td>
        <td class="day" tabindex="0"><span class="day-number">25</span></td>
      </tr>
      <tr class="week">
        <td class="day" tabindex="0"><span class="day-number">26</span></td>
        <td class="day" tabindex="0"><span class="day-number">27</span></td>
        <td class="day" tabindex="0"><span class="day-number">28</span></td>
        <td class="day" tabindex="0"><span class="day-number">29</span></td>
        <td class="day" tabindex="0"><span class="day-number">30</span></td>
        <td class="day" tabindex="0"><span class="day-number">31</span></td>
        <td class="day next-mon" tabindex="0"><span class="day-number">1</span></td>
      </tr>
    </tbody>
  </table>
  
  <a class="button reset">Clear date-range</a>
</div>
</body>
</html>