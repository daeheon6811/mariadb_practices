package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.OrderVo;

public class OrderDao {
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
	
	

	
	public Boolean allDelete() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			conn = getConnection();
			
			String sql = "delete from order";
			pstmt = conn.prepareStatement(sql);
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
	
	public Boolean insertorders(OrderVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			conn = getConnection();
			
			String sql = "insert into orders values(null, ?, ?, ? , ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPrice());
			pstmt.setString(2, vo.getLocation());
			pstmt.setInt(3, vo.getOrderNo());
			pstmt.setInt(4, vo.getMemberNo());
			
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

	public Boolean insertorderbook(OrderVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			conn = getConnection();
			
			String sql = "insert into orderbook values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNo());
			pstmt.setInt(2, vo.getUnit());
			pstmt.setInt(3, vo.getPrice());
			pstmt.setInt(4, vo.getBookNo());
			
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
	
	public boolean updatelocation(int no , String location) {
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = getConnection();
			
			String sql ="update order set location =? where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,location);
			pstmt.setLong(2,no);
			int count = pstmt.executeUpdate();
			result = (count == 1);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
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
	public List<OrderVo> findAllOrderBook() {
		List<OrderVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql ="SELECT a.order_no , a.unit , a.price , a.book_no "
					+ "from orderbook a , book b where a.book_no = b.no";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				int orderNo = rs.getInt(1);
				int unit = rs.getInt(2);
				int price = rs.getInt(3);
				int bookno = rs.getInt(4);;
				
				OrderVo vo = new OrderVo();
				vo.setOrderNo(orderNo);
				vo.setUnit(unit);
				vo.setPrice(price);
				vo.setOrderNo(orderNo);
				vo.setBookNo(bookno);
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
	
	// 주문 목록 조회
		public List<OrderVo> findAllOrders() {
			List<OrderVo> result = new ArrayList<>();

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conn = getConnection();
				
				String sql ="SELECT a.no , a.price , a.location , b.unit , b.order_no , c.no \r\n"
						+ "from orders a, orderbook b , member c ";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while(rs.next()) {
					int no = rs.getInt(1);
					int price = rs.getInt(2);
					String location = rs.getString(3);
					int unit = rs.getInt(4);
					int orderNo = rs.getInt(5);
					int memberNo = rs.getInt(6);
					
					OrderVo vo = new OrderVo();
					vo.setNo(no);
					vo.setPrice(price);
					vo.setLocation(location);
					vo.setUnit(unit);
					vo.setOrderNo(orderNo);
					vo.setMemberNo(memberNo);
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
