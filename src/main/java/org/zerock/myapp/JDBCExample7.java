package org.zerock.myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Date;

import lombok.extern.log4j.Log4j2;


@Log4j2
public class JDBCExample7 {
	
	// Step1. JDBC 4개 필수정보 선언
	static String driver = "oracle.jdbc.OracleDriver";			// JDBC Driver 안에 포함된 구동기 클래스명
	static String jdbcUrl = "jdbc:log4jdbc:oracle:thin:@localhost:1521/xepdb1";			// 연결할 DB서버의 주소
	static String dbUser = "hr";			// 접속할 계정명
	static String dbPass = "oracle";			// 계정의 암호


	// 수행시킬 SQL문장이 여러개 일 때에는, 어떻게 코딩해야 좋을까!?
	// (1) 각 SQL문장마다, 아래의 try-catch + try-with-resources 를 반복해서 사용
	// (2) 아래의 try-catch + try-with-resources 를 그대로 재사용하고,
	//     대신, 각 실행할 SQL문장만 바꿔서 실행 (***********************)
	public static void main(String[] args) throws SQLException {
		log.trace("main({}) invoked.", Arrays.toString(args));

		Connection conn;
		
		Statement stmt1;
		Statement stmt2;
		Statement stmt3;
		
		PreparedStatement pstmt2;
		PreparedStatement pstmt3;
		
		ResultSet rs1;
		ResultSet rs2;
		
		try {			
			conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPass);
			// 트랜잭션 관리를 위해서는, AUTOCOMMIT을 OFF 시켜놓고 해야 한다!! (***)
			conn.setAutoCommit(false);	// AUTOCOMMIT OFF
//			conn.setAutoCommit(true);	// AUTOCOMMIT ON (default)
			
			// ---------------
			// 1st. SQL
			// ---------------
			stmt1 = conn.createStatement();
			String sql1 = "SELECT current_date FROM dual";
			rs1 = stmt1.executeQuery(sql1);

			// ---------------
			// 2nd. SQL
			// ---------------
			String sql2 = "SELECT * FROM departments WHERE department_id > ?";
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setInt(1, 50);
			
			rs2 = pstmt2.executeQuery();

			// ---------------
			// 3rd. SQL
			// ---------------
			String sql3 = "SELECT * FROM departments WHERE manager_id IN (?, ?, ?)";
			pstmt3 = conn.prepareStatement(sql3);
			pstmt3.setInt(1, 200);
			pstmt3.setInt(2, 201);
			pstmt3.setInt(3, 203);

			ResultSet rs3 = pstmt3.executeQuery();
			
			// 소괄호를 한번 더 개선해 보세요!!!
//			try (conn; stmt1; rs1; pstmt2; rs2; pstmt3; rs3;) {	// 1st. method
			try (conn;) { // 2nd. method
				// -----------
				// 1st. SQL문의 결과 출력
				// -----------
				try (stmt1; rs1) {
					rs1.next(); // 결과셋에서 다음 행으로 이동시킴(***)
					
					Date now = rs1.getDate("current_date");
					log.info("1. now: {}", now);
				} // try-with-resources
				
				// -----------
				// 2nd. SQL문의 결과 출력
				// -----------
				try (pstmt2; rs2;) {
					while(rs2.next()) { 				
						int departmentId = rs2.getInt("DEPARTMENT_ID");
						String departmentName = rs2.getString("DEPARTMENT_NAME");
						int managerId = rs2.getInt("MANAGER_ID");
						int locationId = rs2.getInt("LOCATION_ID");
						
						String department = 
							"%s, %s, %s, %s"
							.formatted(departmentId, departmentName, managerId, locationId);
						
						log.info("2. department({})", department);
					} // while
				} // try-with-resources
				
				// -----------
				// 3rd. SQL문의 결과 출력
				// -----------
				try (pstmt3; rs3) {
					while(rs3.next()) { 				
						int departmentId = rs3.getInt("DEPARTMENT_ID");
						String departmentName = rs3.getString("DEPARTMENT_NAME");
						int managerId = rs3.getInt("MANAGER_ID");
						int locationId = rs3.getInt("LOCATION_ID");
						
						String department = 
							"%s, %s, %s, %s"
							.formatted(departmentId, departmentName, managerId, locationId);
						
						log.info("3. department({})", department);
					} // while
				} // try-with-resources
				
				conn.commit();		// 트랜잭션을 정상종료: 모든 변경을 영구적으로 파일에 기록
			} catch(SQLException e) {
				conn.rollback();
				
				throw e;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} // try-catch
	} // main

} // end class

