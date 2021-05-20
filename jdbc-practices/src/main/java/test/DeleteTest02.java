package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTest02 {
	public static void main(String[] args) {
		
		Boolean result = delete(2L);
	    System.out.println(result ? "성공:" : "실패");
		if(result) {
			System.out.println("성공");
		}
	}
	
    public static Boolean delete(Long no)
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
			
			// 3. Statement

			
			// 4 .sql문을 실행
			String sql ="delete "
					+ "from "
					+ "dept "
					+ "where no = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1,no);

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
