<%@page import="java.net.Inet4Address"%>
<%@page import="org.joonzis.ex.BDAO"%>
<%@page import="org.joonzis.ex.BVO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String realPath = request.getServletContext().getRealPath("/upload");
			
	MultipartRequest mr = new MultipartRequest(
			request,
			realPath,
			1024 * 1024 * 10, 
			"utf-8",
			new DefaultFileRenamePolicy()
			);
	BVO vo = new BVO();
	vo.setWriter(mr.getParameter("writer"));
	vo.setTitle(mr.getParameter("title"));
	vo.setPw(mr.getParameter("pw"));
	vo.setContent(mr.getParameter("content"));
	vo.setHit(0);
	/* vo.setIp(request.getRemoteAddr()); // ipv 6  */
	String ip = Inet4Address.getLocalHost().getHostAddress(); // ipv 4
	vo.setIp(ip);
	// 첨부파일 유무에 따라서 filename 값을 결정하자
	if(mr.getFile("filename")!= null){
		vo.setFilename(mr.getFilesystemName("filename"));
	}else{
		vo.setFilename("");
	}
	
	int result = BDAO.getinsert(vo);
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
				alert("게시글이 작성되었습니다.");
				location.href="index.jsp";
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("게시글이 작성을 실패했습니다.");
				history.go(-1);
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>