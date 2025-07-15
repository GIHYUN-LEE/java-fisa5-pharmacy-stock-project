/* employee table과 1:1 맵핑되는 DB 연동 전담 클래스
 * CRUD
 * Data Access Object[DAO] pattern
 * 
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Test;

import model.domain.Employee;
import util.DBUtil;
import view.FailView;
import view.SuccessView;

public class PharmacyDAO {
	
	private static PharmacyDAO model = new PharmacyDAO();
	
	private PharmacyDAO() {} 
	
	public static PharmacyDAO getModel() {
		return model;
	}
	
	/* 브라우저에 입력 -> controller -> DAO -> db
	 * 방법1 - int empno, String ename, int deptno 데이터 전송해서 저장
	 * 방법2 - int empno, String ename, int deptno 받아서
	 * 				Employee 객체 생성 후 DAO에게 insert
	 * 
	 * spring의 자동 완성 기능
	 * 	- client가 브라우저로 입력하는 데이터를 Controller의 메소드에서 받을 때
	 * 		Employee 객체 처럼 자동 객체화 수행
	 * 
	 */
	public static boolean insertOracle(Employee emp) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt =null;
		try  {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("insert into employee values (?,?,?)");
			
			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getEname());
			pstmt.setInt(3, emp.getDeptno());
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(conn, pstmt);
		}
		
		return false;
	}
	
	public static boolean updateOracle(int empno, int newDeptno) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt =null;
		try  {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("update employee set deptno=? where empno=?");
			
			pstmt.setInt(1, newDeptno);
			pstmt.setInt(2, empno);
		
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(conn, pstmt);
		}
		
		return false;
	}
	
	
	/* 모든 고객 정보 반환
	 * - 가변적인 직원 수 
	 * - 직원별 1:1 Employee객체 생성
	 * - 모든 직원인 모든 Employee객체를 한번에 반환 : ArrayList
	 * - select * from employee
	 * 		empno/ename/deptno
	 */
	public ArrayList<Employee> getEmployees() throws Exception {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Employee> all = null;	// 10개씩 메모리 증가하는 동적 메모리 생성
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from employee");
			all = new ArrayList<>();	// 10개씩 메모리 증가하는 동적 메모리 생성
			
			while(rs.next()) {
				all.add(new Employee(rs.getInt("empno"), rs.getString("ename"), rs.getInt("deptno") ));
			}
		} finally {
			DBUtil.close(conn, stmt, rs);
		}
		return all;
	}
	
	public static ArrayList<Employee> getDeptnoEmployee(int deptno) throws Exception {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		ArrayList<Employee> all = null;	// 10개씩 메모리 증가하는 동적 메모리 생성
		try {
			conn = DBUtil.getConnection();
			
			// select만 가능한 객체 생성
			pstmt = conn.prepareStatement("select * from employee where deptno=?");
			pstmt.setInt(1, deptno);		// 첫 번째 물음표에 deptno값 대입 의미
			
			rs = pstmt.executeQuery();		// 실제 db에 select 실행
			
			all = new ArrayList<>();	// 10개씩 메모리 증가하는 동적 메모리 생성
			
			while(rs.next()) {
				all.add(new Employee(rs.getInt("empno"), rs.getString("ename"), rs.getInt("deptno") ));
			}
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return all;
	}
	

	
	
}
