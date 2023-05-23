package org.joozis.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.joonzis.ex.DBConnect;

public class Ex05_delete {
public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		PreparedStatement ps = null;
		try {
			conn = DBConnect.getConnection();
			
			String sql = "";
			sql = "delete from sample where no=? ";
			
		
			ps=conn.prepareStatement(sql);
			ps.setString(1,"1");
			int result = ps.executeUpdate();
			if(result > 0) {
				System.out.println("삭제 성공");
				
			}else {
				System.out.println("삭제 실패");
				
			}
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
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	
}
}
