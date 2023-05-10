package org.joozis.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.joozis.db.DBConnection;

public class Ex02_update {
	public static void main(String[] args) {
		// 김씨의 나이를 100살로, 지역을 마포로 변경
		
		Connection conn = null;
		PreparedStatement ps = null; // sql의 값을 변수 처리 할 수 있따.
		
		try {
			conn = DBConnection.getConnection();
			
			String sql = "update person"
						+ "set age = ? , region = ? where name = '김씨'"; // 나중에 setter로 채울 수 있다.
			ps=conn.prepareStatement(sql); // 미리 sql 생성해야함
			
			// ?에 데이터 set
			ps.setInt(1, 100);
			ps.setString(2, "마산");
			
			int result = ps.executeUpdate();
			
			if(result > 0) {
				System.out.println("변경 완료");
			}else {
				System.out.println("경경 실패");
			}
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				if(conn != null) {
					conn.rollback();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}finally {
			try {
				if(ps != null) {ps.close();}
				if(conn != null) {conn.close();}
				
			} catch (Exception e2) {
				e2.printStackTrace();
				
			}
		}
	}

	

}
