package org.joozis.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.joozis.db.DBConnection;

public class Ex01_insert {
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement ps = null; // sql의 값을 변수 처리 할 수 있따.
		
		try {
			conn = DBConnection.getConnection();
			
			String sql = "insert into person(name,age,region)"
						+ "values(?,?,?)"; // 나중에 setter로 채울 수 있다.
			ps=conn.prepareStatement(sql); // 미리 sql 생성해야함
			
			// ?에 데이터 set
			ps.setString(1, "김씨");
			ps.setInt(2, 50);
			ps.setString(3, "부산");
			
			int result = ps.executeUpdate();
			
			if(result == 1) {
				System.out.println("입력 완료");
			}else {
				System.out.println("입력 실패");
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
