package org.joozis.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.joozis.db.DBConnection;

public class Ex04_select {
public static void main(String[] args) {
	//person 테이블 전체 데이터 출력
			Connection conn = null;
			PreparedStatement ps = null; // sql의 값을 변수 처리 할 수 있따.
			ResultSet rs = null;
			
			try {
				conn = DBConnection.getConnection();
				String sql = "select * from person";
				ps=conn.prepareStatement(sql);
				rs = ps.executeQuery();

				while(rs.next()) {
					System.out.print(rs.getString(1) + ", ");
					System.out.print(rs.getInt(2) + ", ");
					System.out.println(rs.getString("region"));
				}
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
