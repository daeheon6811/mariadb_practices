package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest02 {
	
	public static void main(String[] args) {
		insert("영업");
		insert("개발");
		insert("기획");
	}
	
    public static Boolean insert(String name)
	{
		Connection conn = null;
		PreparedStatement pstmt =null;
		boolean result = false;
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			// 2. 연결하기
			String url = "jdbc:mysql://192.168.80.119:3307/employees";
			conn = DriverManager.getConnection(url, "hr", "hr");
			
			// 3. SQL문을 준비
			// 5. sql 실행
						String sql ="insert "
								+ "into "
								+ "dept "
								+ "values(null, ?)";				
						pstmt = conn.prepareStatement(sql);
			// 4 .바인딩(Binding)
			pstmt.setString(1,name);			
			int count = pstmt.executeUpdate();
			
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
				if (pstmt != null) {
					pstmt.close();
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
