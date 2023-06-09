<%@page import="java.io.File"%>
<%@page import="org.joonzis.ex.BDAO"%>
<%@page import="org.joonzis.ex.BVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    	BVO bvo = (BVO)session.getAttribute("bvo"); 
    	int b_idx = bvo.getB_idx();
    	
		
    	String realPath = application.getRealPath("/upload");
    	String filename = bvo.getFilename();
    	
    	File removeFile = new File(realPath + "/" + filename);
    	
    	if(removeFile.exists()){ // 기존 첨부파일 유무확인
    		removeFile.delete(); //첨부파일 삭제
    	}
    
    	int result = BDAO.deleteByIdx(b_idx);
    	pageContext.setAttribute("result", result);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
			<c:when test="${result gt 0 }">
				<script type="text/javascript">
					alert("게시판이 삭제되었습니다");
					location.href="index.jsp";
				</script>
			</c:when>
			<c:otherwise>
				<script type="text/javascript">
					alert("게시판이 삭제되지 않았습니다.");
					history.go(-1);
				</script>
			</c:otherwise>
		</c:choose>
</body>
</html>