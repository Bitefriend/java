package org.joozis.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Oracle JDBC를 프로젝트에 등록
 * 1. 프로젝트 우클릭
 * 2. Build Path - Configure Build Path
 * 3. Libraries 탭
 * 4. Add External JARs
 * 5. ojdbc6.jar 파일을 찾아서 서택
 */

public class EX01_Connection {
	public static void main(String[] args) {
		
		//1. Connection 인스턴스
		Connection conn = null;
		try {
			//2. Oracle jdbc 드라이브 로드      Class.forName("드라이버 종루);
			Class.forName("oracle.jdbc.driver.OracleDriver"); //외우자
			// Class.forName("com.mysql.jdbc.Driver");      					// MySQL
			//Class.forName(com.microsoft.jdbc.sqlserver.SQLServerDriver");     // MS-SQL
			
			//3. 접속 정보 생성
			String user= "scott";
			String password = "tiger";
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 외우자
			/*
			 * Oracle :		jdbc:oracle://localhost:1521:SID
			 * MySQL  : 	jdbc:mysql://localhost:3306:DB명
			 * MS-SQL : 	jdbc:Microsoft:sqlserver://localhost:1433;databasename=DB명
			 */
			//4. DriverManager :자바를 오라클 jdbc에 연결 시켜주는 클래스
			conn = DriverManager.getConnection(url, user, password);
			
			// 5. 연결 확인 메세지
			System.out.println("DB연결 성공");
			
			//6. 접속 종료
			conn.close();

		} catch (ClassNotFoundException e) {
			System.out.println("jdbc 드라이버 오류");
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}
}
}
