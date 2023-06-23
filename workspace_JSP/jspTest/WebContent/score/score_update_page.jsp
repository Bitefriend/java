<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <%
		 String currentPage = request.getParameter("currentPage"); 

    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학점 바꿔</title>
<style type="text/css">
	div{
		width: 800px;
		margin: auto;
		text-align: center;
	}
	table{
		width: 100%;
		border-collapse: collapse;
		text-align: left;
	}
	td, th{
		border : 1px solid #1e90ff;
		padding : 10px;
	}
	th{
		width : 100px;
		background-color: #0078ff;
		color : #fff;
		text-align: center;
	}
	tr:nth-of-type(7) {
		text-align: center;
	}
</style>
<script type="text/javascript">
function updatecom(f) {

	f.action = "/jspTest/ScoreController";
	f.submit();
}

</script>
</head>
<body>
<div>
	<h2>${svo.ss_idx }번 성적 수정</h2>
		<form method="post">
		<!-- enctype="multipart/form-data" -->
			<table>
				<tbody>
					<tr>
						<th>학번</th>
						<td> <input type="hidden" name="ss_idx" value="${svo.ss_idx}"> ${svo.ss_idx }</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td> <input type="hidden" name="m_idx" value="${member.m_idx} "> ${member.m_idx }</td>
					</tr>
					<tr>
						<th>중간고사</th>
						<td> <input type="number" name="sub1" size="80"value="${svo.sub1 }"></td>
					</tr>
					<tr>
						<th>기말고사</th>
						<td> <input type="number" name="sub2" size="80" value="${svo.sub2 }"></td>
						<td> <input type="hidden" name="ss_idx" value="${svo.ss_idx }"> </td>
					</tr>
					<tr>
						<th>과제</th>
						<td> <input type="number" name="sub3" size="80"value="${svo.sub3 }"></td>
					</tr>
					<tr>
						<th>발표</th>
						<td> <input type="number" name="sub4" size="80"value="${svo.sub4 }"></td>
					</tr>
					<tr>
						<th>평균</th>
						<td> <input type="number" name="avg" size="80"value="${svo.avg }"></td>
					</tr>
					<tr>
						<th>과목</th>
						<td> <input type="text" name="subNmae" size="80"value="${svo.subName }"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="button" value="성적 저장" onclick= "updatecom(this.form)">
							<input type="reset" value="다시 작성 ">
							<input type="button" value="목록으로 이동" onclick="location.href='score.jsp'">
							<input type="button" value="게시글로 이동" onclick= "history.back()">
						</td>
					</tr>
				</tbody>
			</table>
			<input type="hidden" name="cmd" value="update">
		</form>
	</div>
</body>
</html>