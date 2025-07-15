package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import domain.Medicine;
import util.DBUtil;

public class MedicineDAO {
	
	private static MedicineDAO model = new MedicineDAO();
	
	private MedicineDAO() {} 
	
	public static MedicineDAO getModel() {
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
	
	public static boolean updateAmountMedicine(String medicineName, int newAmount) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt =null;
		try  {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("update medicine set amount=? where name=?");
			
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
	
	public static boolean updatePriceMedicine(String medicineName, int newPrice) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt =null;
		try  {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("update medicine set price=? where name=?");
			
			pstmt.setInt(1, newPrice);
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
	
	public static boolean updatePriceAmountMedicine(String medicineName, int newPrice, int newAmount) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt =null;
		try  {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("update medicine set price=?, amount=? where name=?");
			
			pstmt.setInt(1, newPrice);
			pstmt.setInt(2, newAmount);
			pstmt.setString(3, medicineName);
		
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(conn, pstmt);
		}
		return false;
	}
	
	
	public static HashMap<String,Medicine> getAllMedicines() throws Exception {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		HashMap<String, Medicine> all = null;	
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from medicine");
			all = new HashMap<>();	
			
			while(rs.next()) {
				all.get(new Medicine(rs.getString("name"), rs.getInt("price"), rs.getInt("amount")));
			}
		} finally {
			DBUtil.close(conn, stmt, rs);
		}
		return all;
	}
	
	public static Medicine getNameMedicine(String name) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		Medicine med = null;	
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select * from medicine where name=?");
			pstmt.setString(1, name);		
			
			rs = pstmt.executeQuery();		
			
			while(rs.next()) {
				 med = new Medicine(rs.getString("name"),rs.getInt("price"), rs.getInt("amount"));
			}
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return med;
	}
	
	public static boolean deleteMedicine(String name) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt =null;
		try  {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("delete from medicine where name = ?");
			
			pstmt.setString(1, name);
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(conn, pstmt);
		}
		return false;
	}
	
}
