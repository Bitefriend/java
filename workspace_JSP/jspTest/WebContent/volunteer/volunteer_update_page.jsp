<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자기소개서 수정</title>
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
	if (f.vtitle1.value == '') {
		alert("질문 하나 이상 작성 확인하세용");
		f.vtitle1.focus();
		return
	}/* else if(f.stitle.value == ''|| f.content.value == ''){
		alert("빈칸 없이 입력해주세요");
		f.stitle.focus();
		return
	} */
	f.action = "/jspTest/VolController";
	/* currentPage=${currentPage} */
	f.submit();
}

</script>
</head>
<body>
<div>
	<h2>${member.m_idx }번 자유게시판 수정</h2>
		<form method="post" enctype="multipart/form-data">
			<table>
				<tbody>
					<tr>
						<th>작성자 번호</th>
						<td> <input type="hidden" name="m_idx" value="${member.m_idx}"> ${member.m_idx }</td>
					</tr>
					<tr>
						<th>글 번호</th>
						<td> <input type="hidden" name="v_idx" value="${vvo.v_idx}"> ${vvo.v_idx }</td>
					</tr>
					<tr>
						<th>첫 질문</th>
						<td> <input type="text" name="vtitle1" value="${vvo.vtitle1} "></td>
					</tr>
					<tr>
						<th>첫 답변</th>
						<td> <textarea rows="10" cols="80" name="content1" >${vvo.content1 }</textarea></td>
					</tr>
					
					<tr>
						<th>두번째 질문</th>
						<td> <input type="text" name="vtitle2" value="${vvo.vtitle2} "></td>
					</tr>
					<tr>
						<th>두번째 답변</th>
						<td> <textarea rows="10" cols="80" name="content2" >${vvo.content2 }</textarea></td>
					</tr>
					<tr>
						<th>세번째 질문</th>
						<td> <input type="text" name="vtitle3" value="${vvo.vtitle3} "></td>
					</tr>
					<tr>
						<th>세번째 답변</th>
						<td> <textarea rows="10" cols="80" name="content3" >${vvo.content3 }</textarea></td>
					</tr>
					<tr>
						<th>TIP</th>
						<td> <input type="text" name="tip" value="${vvo.tip} "></td>
					</tr>
					<tr>
						<th>조회수</th>
						<td>${vvo.hit }</td>
						<td> <input type="hidden" name="f_idx" value="${vvo.v_idx }"> </td>
					</tr>
					 <tr>
						<th>첨부파일</th>
						<td> 
						<input type="file" name="filefree">
							<c:choose>
								<c:when test="${vvo.filefree eq null }">
									[ 기존 첨부 파일 : 없음 ]
								</c:when>
								<c:otherwise>
									[ 기존 첨부파일 : ${vvo.filefree } ]
									<input type="hidden"  name="oldfile" value="${vvo.filefree }">
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="button" value="방명록 저장" onclick= "updatecom(this.form)">
							<input type="reset" value="다시 작성 ">
							<input type="button" value="목록으로 이동" onclick="location.href='volunteer/volunteer_main.jsp'">
							<input type="button" value="게시글로 이동" onclick= "history.back()">
							<input type="hidden" name="cmd" value="vol_update">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>