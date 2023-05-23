package org.joozis.db;

import java.sql.Connection;
import java.sql.Statement;

import org.joonzis.ex.DBConnect;

public class Ex04_update {
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		
		try {
			conn = DBConnect.getConnection();
		
			st = conn.createStatement();
			
			String sql = "";
			sql = "update sample set name = '박씨' where no = 1";
			
		
			int result = st.executeUpdate(sql);
			
			if(result > 0) {
				System.out.println("업데이트 성공");
				
			}else {
				System.out.println("업데이트 실패");
				
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
