package org.joozis.ex2;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionMain {
	private void main(String[] args) {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			System.out.println("DB연결 성공");
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc 드라이버 오류");
			
		}catch (SQLException e) {
			System.out.println("DB연결 오류");
		}
	}
}
