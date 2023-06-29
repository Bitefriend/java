<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../include/header.jsp" %>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Tables</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">게시글 목록
				<button id="regBtn" class="btn btn-xs pull-right btn-primary" >새 게시글 등록</button>
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>#번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>수정일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="board" items="${list }">
							<tr>
								<td><c:out value="${board.bno}"></c:out></td>
								<td><c:out value="${board.title }"></c:out></td>
								<td><c:out value="${board.writer}"></c:out></td>
								<td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd"/></td>
								<td><fmt:formatDate value="${board.updatedate}" pattern="yyyy-MM-dd"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<!-- regBtn -->
<script type="text/javascript">
	history.replaceState({}, null, location.pathname)
	var button = document.querySelector("regBtn");
	$(function(){
		$("#regBtn").click(function(){
			//새 게시글 버튼 글릭 시 삽입 화면으로 이동
			location.href = "/board/register"
			
		})
	})
		// 결과 창 출력을 위한 코드
		var result = '<c:out value = "${result}"/>';
		
		//rttr 객체를 통해 받아온 값이 빈 값이 아닐 떄 (데이터 변경) 알림 메소드 실행
		if(result != ''){
			checkResult(result);
		}
		//뒤로가기 버튼을 누를때 문제가 될 수 있으므로
		// history 객체를 조작({정보를 담은 객체}, 뒤로가기 버튼 문자열 형태의 제목, 바꿀url)
		history.replaceState({}, null, null);
		function checkResult(result) {
			if(result ===''|| history.state){ // 뒤로가기 방지
				return;
			}
			if(result ==='ok'){//삽입
				alert("게시글이 삽입되었습니다");
				return;
			} 
			if(result ==='success'){//수정 or 삭제
				alert("처리가 완료되었습니다");
				return;
			} 
			
		}

</script>

<%@ include file="../include/footer.jsp" %>