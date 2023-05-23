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
			sql = "update member set pw = ? , name = ? , age = ? , addr = ? where id = ?";
			
		
			ps=conn.prepareStatement(sql);
			
			ps.setString(1,pw);
			ps.setString(2,name);
			ps.setInt(3,age);
			ps.setString(4,addr);
			ps.setString(5,id);
			ps.executeUpdate();
			
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
				if(st !=null) {st.close();}
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
<script type="text/javascript">
	function update(f) {
		action
	}
</script>
</head>
<body>

</body>
</html>