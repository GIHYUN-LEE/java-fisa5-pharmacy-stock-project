package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.User;
import util.DBUtil;

public class UserDAO {
	private static UserDAO model = new UserDAO();

	private UserDAO() {
	};

	public static UserDAO getModel() {
		return model;
	}

	public ArrayList<User> getUsers() throws Exception {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<User> all = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from user");

			all = new ArrayList<>();
			while (rs.next()) {
				all.add(new User(rs.getString("name"), rs.getString("role")));
			}
		} finally {
			DBUtil.close(conn, stmt, rs);
		}

		return all;
	}

	public static String getUserRole(String name) throws SQLException {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    String role = "";

	    try {
	        conn = DBUtil.getConnection();
	        pstmt = conn.prepareStatement("select role from user WHERE name = ?");
	        pstmt.setString(1, name);

	        rs = pstmt.executeQuery();
	        if (rs.next()) {
	            role = rs.getString("role");
	        }
	    } finally {
	        DBUtil.close(conn, pstmt, rs);
	    }

	    return role;
	}
}
