package org.joozis.ex;

import java.sql.Connection;
import java.sql.Statement;

import org.joozis.db.DBConnection;

public class Ex02_update {
	public static void main(String[] args) {
		// 스콧의 나이를 21살로 변경
		// 성공 시 - "업데이트 성공"
		// 실패 시 - "업데이트 실패" 출력
		
		
		Connection conn = null;
		Statement st = null;
		
		try {
			conn = DBConnection.getConnection();
		
			st = conn.createStatement();
			
			String sql = "";
			sql = "update person set age = 21 where name = '스콧'";
			
		
			int result = st.executeUpdate(sql);
			
			// 삽입성공 : 1, 실패 : 0;
			//업데이트 시 숫자 병경해야함
			if(result > 0) {
				System.out.println("업데이트 성공");
				
			}else {
				System.out.println("업데이트 실패");
				
			}
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			//롤백
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
