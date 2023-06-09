package org.joozis.ex;

import java.sql.Connection;
import java.sql.Statement;

import org.joozis.db.DBConnection;

public class Ex01_insert {
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		
		try {
			conn = DBConnection.getConnection();
			
			//statement 생성
			st = conn.createStatement();
			
			// 쿼리 작성 -> 스콧, 나이 99, 사는 곳 인천
			// 세미콜론 주의
			String sql = "";
			sql = "insert into person values('스콧', 99, '인천')";
			
			//쿼리 날리기(DB로 sql 전달)
			//executeUpdate : insert, update, delete문 사용
			// (메소드의 리턴 타입이 int 라서 이렇게 작성)
			// ex) st : 버스, sql: 승객
			int result = st.executeUpdate(sql);
			
			// 삽입성공 : 1, 실패 : 0;
			if(result == 1) {
				System.out.println("레코드의 삽입 성공!");
				
			}else {
				System.out.println("레코드의 삽입실패!");
				
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
				if(st !=null) {st.close();}
				if(conn !=null) {conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
