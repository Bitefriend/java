<%@page import="org.joozis.db.DBConnect"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw"); 
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age")); 
 	String addr = request.getParameter("addr");   
 	
    Connection conn = null;
	Statement st = null;
	PreparedStatement ps = null;
	try {
		conn = DBConnect.getConnection();
		
		String sql = "";
		sql = "delete from  member where id = ? and pw = ? and name = ? and age = ? and addr = ? ";
		
	
		ps=conn.prepareStatement(sql);
		
		ps.setString(1,id);
		ps.setString(2,pw);
		ps.setString(3,name);
		ps.setInt(4,age);
		ps.setString(5,addr);
		
		int result = ps.executeUpdate();
	
		conn.commit();
		
	} catch (Exception e) {
		e.printStackTrace();
		
		try {
			if(conn !=null) {
				conn.rollback();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}finally {
		
		try {
			if(st !=null) 
			{st.close();}
			if(conn !=null) {conn.close();}
			response.sendRedirect("view_all.jsp");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>