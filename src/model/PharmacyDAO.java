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
import java.util.HashMap;

import org.junit.Test;

import domain.Medicine;
import util.DBUtil;

public class PharmacyDAO {
	
	private static PharmacyDAO model = new PharmacyDAO();
	
	private PharmacyDAO() {} 
	
	public static PharmacyDAO getModel() {
		return model;
	}
	
	
	public static boolean insertMedicine(Medicine med) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt =null;
		try  {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("insert into medicine values (?,?,?)");
			
			pstmt.setString(1, med.getName());
			pstmt.setInt(2, med.getPrice());
			pstmt.setInt(3, med.getAmount());
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(conn, pstmt);
		}
		
		return false;
	}
	
	public static boolean updateMedicine(String medicineName, int newAmount) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt =null;
		try  {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("update medicine set newAmount=? where name=?");
			
			pstmt.setInt(1, newAmount);
			pstmt.setString(2, medicineName);
		
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(conn, pstmt);
		}
		
		return false;
	}
	
	
	public HashMap<String,Medicine> getAllMedicines() throws Exception {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		HashMap<String, Medicine> all = null;	// 10개씩 메모리 증가하는 동적 메모리 생성
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from medicine");
			all = new HashMap<>();	// 10개씩 메모리 증가하는 동적 메모리 생성
			
			while(rs.next()) {
				all.get(new Medicine(rs.getString("name"), rs.getInt("price"), rs.getInt("amount")));
			}
		} finally {
			DBUtil.close(conn, stmt, rs);
		}
		return all;
	}
	
	
	public static HashMap<String,Medicine> getNameMedicine(String name) throws Exception {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		HashMap<String,Medicine> all = null;	// 10개씩 메모리 증가하는 동적 메모리 생성
		try {
			conn = DBUtil.getConnection();
			
			// select만 가능한 객체 생성
			pstmt = conn.prepareStatement("select * from medicine where name=?");
			pstmt.setString(1, name);		// 첫 번째 물음표에 deptno값 대입 의미
			
			rs = pstmt.executeQuery();		// 실제 db에 select 실행
			
			all = new HashMap<>();	// 10개씩 메모리 증가하는 동적 메모리 생성
			
			while(rs.next()) {
				all.get(new Medicine( ));
			}
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return all;
	}
	

	
	
}
