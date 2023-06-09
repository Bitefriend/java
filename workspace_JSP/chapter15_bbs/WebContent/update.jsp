<%@page import="java.io.File"%>
<%@page import="java.net.Inet4Address"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="org.joonzis.ex.BDAO"%>
<%@page import="org.joonzis.ex.BVO"%>
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
	
	request.setCharacterEncoding("utf-8");
	
	BVO bvo = new BVO();
	/* vo.setWriter(request.getParameter("writer"));
	vo.setPw(request.getParameter("pw")); */
	bvo.setTitle(mr.getParameter("title"));
	bvo.setContent(mr.getParameter("content"));
	bvo.setB_idx(Integer.parseInt(mr.getParameter("b_idx")));
	bvo.setIp(Inet4Address.getLocalHost().getHostAddress()); 
	
	
	/*
		첨부파일 수정
		1. 기존 첨부가 있는 경우
			1) 새 첨부가 없으면 기존 첨부 그대로 사용
			2) 새 첨부가 있으면 기존 첨부 삭제 후 새 첨부 사용
		2. 기존 첨부가 없는 경우
			1) 새 첨부 사용
	*/
	
	File newfile = mr.getFile("filename");		 // 새 첨부파일
	String oldfile = mr.getParameter("ordfile"); // 기존 첨부파일
	if(newfile != null){						//새 첨부파일 o
		if(oldfile != null){					// 기존 첨부파일 o
			File removeFile = new File(realPath + "/" + oldfile);
			if(removeFile.exists()){ 			// 기존 첨부파일 유무 확인
				removeFile.delete();			// 기존 첨부파일 삭제
			}
		}
		bvo.setFilename(newfile.getName());	 // 새 첨부파일 이름 저장
	}else{ 									//새 첨부파일 x
		if(oldfile != null){ // 기존 첨부파일 o
			bvo.setFilename(oldfile);
		}else{ 								// 기존 첨부파일 x 새 첨부파일 x
			 bvo.setFilename("");
		}
	}
	
	/* if(mr.getFile("filename")!= null){
		bvo.setFilename(mr.getFilesystemName("filename"));
	}else{
		bvo.setFilename("");
	} */
	
	int result = BDAO.updateByIdx(bvo);
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
				alert("게시글이 수정되었습니다.");
				location.href="index.jsp";
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("게시글이 수정에 실패했습니다.");
				history.go(-1);
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>