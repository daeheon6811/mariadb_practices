package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.CategoryVo;

public class CategoryDao {
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mysql://192.168.80.119:3307/bookmall?charset=utf8";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
			System.out.println("ok:");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} 
		
		return conn;
	}
	public Boolean insert(CategoryVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			conn = getConnection();
			
			String sql = "insert into category values(null , ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			
			int count = pstmt.executeUpdate();
			result = count == 1;
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 자원정리(clean-up)
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	// 주문 목록 조회
		public List<CategoryVo> findAll() {
			List<CategoryVo> result = new ArrayList<>();

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conn = getConnection();
				
				String sql ="select a.no , a.name from category a";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while(rs.next()) {
					int no = rs.getInt(1);
					String name = rs.getString(2);
					CategoryVo vo = new CategoryVo();
					vo.setNo(no);
					vo.setName(name);
					result.add(vo);			
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			} finally {
				try {
					if(rs != null) {
						rs.close();
					}
					if(pstmt != null) {
						pstmt.close();
					}
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			return result;
		}	
}
