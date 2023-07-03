<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp" %>


<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">게시글 수정-삭제 화면</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">게시글 수정-삭제 화면</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<form action="/board/modify" method="post" role="form">
					<div class="form-group">
						<label>글 번호</label>
						<input class="form-control" name="bno" value="${vo.bno }" readonly="readonly">
					</div>
					<div class="form-group">
						<label>글 제목</label>
						<input class="form-control" name="title" value="${vo.title }">
					</div>
					<div class="form-group">
						<label>글 내용</label>
						<textarea class="form-control" rows="3" name="content">${vo.content }</textarea>
					</div>
					<div class="form-group">
						<label>작성자</label>
						<input class="form-control" name="writer" value="${vo.writer }"readonly="readonly">
					</div>
					<button type="submit" data-oper="modify" class="btn btn-primary">등록</button>
					<button type="submit" data-oper="remove" class="btn btn-outline btn-success">삭제</button>
					<button type="submit" data-oper="list" class="btn btn-outline btn-danger">목록으로 이동</button>
					<input type="hidden" name="pageNum" value="${cri.pageNum }">
					<input type="hidden" name="amount" value="${cri.amount }">
				</form>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<script type="text/javascript">
	$(function(){
		
		var formObj = $("form");
		
		$("button").on('click', function(e){
			e.preventDefault();
			
			var operation = $(this).data("oper");
			
			if(operation === 'remove'){
				formObj.attr('action', '/board/remove');	
			}else if(operation ==='list'){
				formObj.attr('action', '/board/list');
				formObj.attr('method', 'get')
				
				var pageNumTag = $("input[name='pageNum']").clone();
				var amountTag = $("input[name='amount']").clone();
				
				formObj.empty(); // 해당 요소 내부 초기화
				
				formObj.append(pageNumTag);
				formObj.append(amountTag);
			}
			formObj.submit();
		})
	})
</script>


<%@include file="../include/footer.jsp" %>