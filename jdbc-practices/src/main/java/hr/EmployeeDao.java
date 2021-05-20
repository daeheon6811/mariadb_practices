package hr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

	private Connection getConnectiono() throws SQLException {
		Connection conn = null;

		try {

			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mysql://192.168.80.119:3307/employees";
			conn = DriverManager.getConnection(url, "hr", "hr");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} 
		return conn;
	}

	public List<EmployeeVo> findbySalray(int min, int max) {

		List<EmployeeVo> result = new ArrayList<EmployeeVo>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			conn = getConnectiono();
			String sql = "select a.emp_no , a.first_name , a.last_name , b.salary from employees a , salaries b where 1 = 1 "
					+ "and a.emp_no = b.emp_no" + " and b.to_date = '9999-01-01'" + " and b.salary between ? and ?"
					+ " order by b.salary asc" + " ;";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, min);
			stmt.setInt(2, max);

			rs = stmt.executeQuery();

			while (rs.next()) {
				Long empNo = rs.getLong(1);
				String fristName = rs.getString(2);
				String LastName = rs.getString(3);
				int salary = rs.getInt(4);

				EmployeeVo vo = new EmployeeVo();
				vo.setEmpNo(empNo);
				vo.setFirstNmae(fristName);
				vo.setLastName(LastName);
				vo.setSalary(salary);

				result.add(vo);

			//	System.out.println("" + empNo + " : " + salary + " : " + fristName + "");
			}

			System.out.println("ok:" + conn);

		}  catch (SQLException e) {
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
				if (rs != null) {
					rs.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;

	}

	

	public List<EmployeeVo> findByName(String name) {
		List<EmployeeVo> result = new ArrayList<EmployeeVo>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			conn = getConnectiono();
			String sql = "select emp_no , " + "first_name , " + "last_name , " + "date_format(hire_date ,'%Y-%m-%d') "
					+ "from employees " + "where 1 = 1 " + "and  first_name like ?" + "and last_name like ?;";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + name + "%");
			stmt.setString(2, "%" + name + "%");

			rs = stmt.executeQuery();

			while (rs.next()) {
				Long empNo = rs.getLong(1);
				String fristName = rs.getString(2);
				String LastName = rs.getString(3);
				String hireDate = rs.getString(4);

				EmployeeVo vo = new EmployeeVo();
				vo.setEmpNo(empNo);
				vo.setFirstNmae(fristName);
				vo.setLastName(LastName);
				vo.setHireDate(hireDate);

				result.add(vo);

				System.out.println("" + empNo + " : " + hireDate + " : " + fristName + "");
			}

			System.out.println("ok:" + conn);

		}  catch (SQLException e) {
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
				if (rs != null) {
					rs.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;

	}

}
