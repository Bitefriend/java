<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>익명게시판 입력</title>
<script type="text/javascript">
function insertFVO(f) {
		//작성자 , 제목 , 내용 데이터 필수 입력 확인
		
		if (f.fpw.value == "" ||f.fnickname.value == "" ||f.fcontent.value == "") {
			alert("작성 할 정보를 모두 입력하세요.");
			f.fnickname.focus();
			return;
		}
		//submit
		f.action = "/jspTest/FreeController";
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
		<h2>자유게시판 작성</h2>
		<form method="post" enctype="multipart/form-data">
			<table>
				<tbody>
					<tr>
						<th>작성자</th>
						<td> <input type="text" name="m_idx" size="80" value="${member.m_idx}" readonly="readonly">${fvo.midx}</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td> <input type="text" name="fnickname" size="80"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td> <input type="password" name="fpw" size="80"></td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td> <input type="file" name="filefree"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td> <textarea rows="10" cols="80" name="fcontent"></textarea></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="button" value="게시글 저장" onclick= "insertFVO(this.form)">
							<input type="reset" value="다시 작성 ">
							<input type="button" value="목록으로 이동" onclick="location.href='/jspTest/FreeController?cmd=free_write&currentPage=${session.currentPage}'">
							<input type="hidden" name="cmd" value="free_insert">
							<input type="hidden" name="f_idx" value="f_idx">
							<input type="hidden" name="m_idx" value="${member.m_idx }">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>