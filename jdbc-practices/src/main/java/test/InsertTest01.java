package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InsertTest01 {
	
	public static void main(String[] args) {
		insertDepartment("영업");
		insertDepartment("개발");
		insertDepartment("기획");
	}
	
    public static Boolean insertDepartment(String name)
	{
		Connection conn = null;
		java.sql.Statement stmt =null;
		boolean result = false;
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			// 2. 연결하기
			String url = "jdbc:mysql://192.168.80.119:3307/employees";
			conn = DriverManager.getConnection(url, "hr", "hr");
			
			// 3. Statement
			stmt = conn.createStatement();
			
			// 4 .sql문을 실행
			String sql ="insert "
					+ "into "
					+ "dept "
					+ "values(null, '"+ name +"')";
			
			int count = stmt.executeUpdate(sql);
			
			result = (count == 1);


			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("error::" + e);
		} finally {
			try {
				// 자원정리(clean-up)
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
		// 2.
	}


}
