<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	// webContent 아래 upload 폴더의 실제 경로 알아내기
    	String realPath = request.getServletContext().getRealPath("/upload");
    	// String realPath = applicateion.getRealPath("/upload")도 가능
    			
    	// request 대신 MultipartRequest 클래스 사용
    	MultipartRequest mr = new MultipartRequest(
    			request,
    			realPath,
    			1024 * 1024 * 10, // 바이트 단위 ( 1024=1kb) (1024kb = 1mb)
    			"utf-8",
    			new DefaultFileRenamePolicy()
    			//동일한 이름의 파일이 업로드 되면 어떤 방식으로 저장할 것이니지
    			// 기본 값 : 파일 뒤에 번호를 붙힘
    			);
    	File file = mr.getFile("filename");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<ul>
			<li> 실제 저장 경로 : <%=realPath %></li>
			<li> 업로더 : <%=mr.getParameter("uploader") %></li>
			<li> 원본 파일 명 : <%=mr.getOriginalFileName("filename") %></li>
			<li> 저장 파일 명 : <%=mr.getFilesystemName("filename") %></li>
			<!-- 실제로 서버에 저장된 이름 -->
			
			<!-- File 클래스를 통해 확인 -->
			<li>파일 명 : <%= file.getName() %></li>
			<li>파일 크기 : <%= file.length() %></li>
			<li>파일 수정 날짜 : <%= file.lastModified() %></li>
			<%SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 hh시 mm분"); %>
			<li>파일 수정 날짜 : <%=sdf.format(file.lastModified()) %></li>
		</ul>
	</div>
	<br> <br>
	
	<a href="download.jsp?path=upload&filename=<% mr.getFilesystemName("filename"); %> ">다운로드</a>
</body>
</html>