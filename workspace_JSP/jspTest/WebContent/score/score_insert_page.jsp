<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function insertSVO(f) {
		//작성자 , 제목 , 내용 데이터 필수 입력 확인
		
		if (f.sub1.value == "" || f.sub2.value == "" || f.sub3.value == "" ||f.sub4.value == "") {
			alert("성적입력하시오.");
			f.sub1.focus();
			return;
		}
		if (f.subName.value == "") {
			alert("과목이름 입력하세요.");
			f.subName.focus();
			return;
		}
		if (f.avg.value == "") {
			alert("평균점수 입력하세요.");
			f.sname.focus();
			return;
		}
		//submit
		f.action = "/jspTest/ScoreController";
		f.submit();
		
		
	}
</script>
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
</head>
<body>
<div>
		<h2>학점 입력폼</h2>
		<form method="post">
			<table>
				<tbody>
					
					<tr>
						<th>작성자</th>
						<td> <input type="number" name="m_idx" size="80" value="${member.m_idx}" readonly="readonly"></td>
						<td> <input type="number" name="midx" size="80"></td>
					</tr>
					<tr>
						<th>과목이름</th>
						<td><input type="text" name="subName" size="80"></td>
					</tr>
					<tr>
						<th>중간고사</th>
						<td> <input type="number" name="sub1" size="80"></td>
					</tr>
					<tr>
						<th>기말고사</th>
						<td> <input type="number" name="sub2" size="80"></td>
					</tr>
					<tr>
						<th>과제</th>
						<td> <input type="number" name="sub3" size="80"></td>
					</tr>
					<tr>
						<th>발표</th>
						<td> <input type="number" name="sub4" size="80"></td>
					</tr>
					<tr>
						<th>평균</th>
						<td> <input type="number" name="avg" size="80"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="button" value="성적 저장" onclick= "insertSVO(this.form)">
							<input type="reset" value="다시 작성 ">
							<input type="button" value="목록으로 이동" onclick="location.href='/jspTest/ScoreController?cmd=score_allList'">
							<input type="hidden" name="ss_idx" value="ss_idx">
						</td>
					</tr>
				</tbody>
			</table>
					<input type="hidden" name="cmd" value="insert">
		</form>
	</div>
</body>
</html>