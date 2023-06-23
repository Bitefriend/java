<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자기소개서 입력</title>
<script type="text/javascript">
function insertFVO(f) {
		//작성자 , 제목 , 내용 데이터 필수 입력 확인
		if (f.tip.value == "" ||f.vtitle1.value == "" ||f.content1.value == "") {
			alert("작성 할 정보를 모두 입력하세요.");
			f.vtitle1.focus();
			return;
		}
		//submit
		f.action = "/jspTest/VolController";
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
		<h2>자기소개서 작성</h2>
		<form method="post" enctype="multipart/form-data">
			<table>
				<tbody>
					<tr>
						<th>작성자</th>
						<td> <input type="text" name="m_idx" size="80" value="${member.m_idx}" readonly="readonly"></td>
					</tr>
					<tr>
						<th>질문 1</th>
						<td> <input type="text" name="vtitle1" size="80"></td>
					</tr>
					<tr>
						<th>내용 1</th>
						<td> <textarea rows="10" cols="80" name="content1"></textarea></td>
					</tr>
					<tr>
						<th>질문 2</th>
						<td> <input type="text" name="vtitle2" size="80"></td>
					</tr>
					<tr>
						<th>내용 2</th>
						<td> <textarea rows="10" cols="80" name="content2"></textarea></td>
					</tr>
					<tr>
						<th>질문 3</th>
						<td> <input type="text" name="vtitle3" size="80"></td>
					</tr>
					<tr>
						<th>내용 3</th>
						<td> <textarea rows="10" cols="80" name="content3"></textarea></td>
					</tr>
					<tr>
						<th>작성 팁</th>
						<td> <textarea rows="10" cols="80" name="tip"></textarea></td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td> <input type="file" name="filefree"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="button" value="게시글 저장" onclick= "insertFVO(this.form)">
							<input type="reset" value="다시 작성 ">
							<input type="button" value="목록으로 이동" onclick="location.href='/jspTest/VolController?cmd=volunteer_main&currentPage=${session.currentPage}'">
							
							<input type="hidden" name="cmd" value="vol_insert">
							<input type="hidden" name="v_idx" value="v_idx">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>