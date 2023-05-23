package org.joozis.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.joonzis.ex.DBConnect;


public class Ex03_insert {
	public static void main(String[] args) {
		Connection conn = null;

		PreparedStatement ps = null;
		try {
			conn = DBConnect.getConnection();
			

			String sql = "";
			sql = "insert into sample (no, name, reg_date) "
					+ " values(sample_seq.nextval, ?, sysdate)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1,"김씨");
			int result = ps.executeUpdate();
			
	
			if(result > 0) {
				System.out.println("레코드의 삽입 성공!");
				
			}else {
				System.out.println("레코드의 삽입 실패!");
				
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
				if(ps!= null) {ps.close();}
				if(conn !=null) {conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
