<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 입력</title>
<script type="text/javascript">
function insertBVO(f) {
		//작성자 , 제목 , 내용 데이터 필수 입력 확인
		
		if (f.spw.value == "" || f.sname.value == "" || f.stitle.value == "" ||f.content.value == "") {
			alert("작성 할 정보를 모두 입력하세요.");
			f.sname.focus();
			return;
		}
		//submit
		f.action = "/jspTest/MainController";
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
		<h2>공지사항 작성</h2>
		<form method="post" enctype="multipart/form-data">
			<table>
				<tbody>
					<tr>
					
						<th>작성자</th>
						<td> <input type="text" name="sname" size="80" value="${member.mid}" readonly="readonly"></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" name="stitle" size="80"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td> <input type="password" name="spw" size="80"></td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td> <input type="file" name="filename"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td> <textarea rows="10" cols="80" name="content"></textarea></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="button" value="게시글 저장" onclick= "insertBVO(this.form)">
							<input type="reset" value="다시 작성 ">
						</td>
					</tr>
				</tbody>
			</table>
					<input type="hidden" name="cmd" value="insert">
		</form>
	</div>
</body>
</html>