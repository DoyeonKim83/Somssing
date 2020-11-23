package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Community;

public class MatchingDao {

	public MatchingDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}	
	
	}
	
	private static Connection getConnection() {

        String url = // "jdbc:oracle:thin:@localhost:1521:xe";
				"jdbc:oracle:thin:@202.20.119.117:1521:orcl";	
    	String user = "dbprog0105";
    	String passwd = "som05";

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}	 
		return conn;
	}
	
	public static List<Community> printComList() {
		Connection conn = null;
		PreparedStatement pStmt = null;	
		ResultSet rs = null;
		List<Community> list = new ArrayList<>();
		Community comm;
		
		String query = "select comm_id, content, comm_time, user_id"
				+ " from Community c join Post p using (comm_id)"
				+ " order by comm_id desc";
		
		try {
			conn = getConnection();
			pStmt = conn.prepareStatement(query);
			rs = pStmt.executeQuery();
			
			while (rs.next()) {
				int comm_id = rs.getInt("comm_id");
				String content = rs.getString("content");
				String comm_time = rs.getString("comm_time");
				String user_id = rs.getString("user_id");
				comm = new Community(comm_id, content, comm_time, user_id);
				list.add(comm);	
			}
			System.out.println(" printComList() 수행 완료 ");
			return list;
			
		}catch (SQLException ex) {
			ex.printStackTrace();
		} finally {	
			if (rs != null) 
				try { 
					rs.close(); 
				} catch (SQLException ex) { ex.printStackTrace(); }
			if (pStmt != null) 
				try { 
					pStmt.close(); 
				} catch (SQLException ex) { ex.printStackTrace(); }
			if (conn != null) 
				try { 
					conn.close(); 
				} catch (SQLException ex) { ex.printStackTrace(); }
		}
 

        return null;
	}
	
	public static Community checkPost(int comm_id) {
		Connection conn = null;
		PreparedStatement pStmt = null;			
		ResultSet rs = null;
		Community comm = null;
		
		String query = "select comm_id, content, comm_time, user_id"
				+ " from Community c join Post p using (comm_id)"
				+ " where comm_id = ?";
		try {
			conn = getConnection();
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, comm_id);
			rs = pStmt.executeQuery();
			if (rs.next()) {
				String content = rs.getString("content");
				String comm_time = rs.getString("comm_time");
				String user_id = rs.getString("user_id");
				comm = new Community(comm_id, content, comm_time, user_id);
			}
			System.out.println("checkCom 수행 완료 ");
			return comm;
			
		}catch (SQLException ex) {
			ex.printStackTrace();
		} finally {		// �ڿ� �ݳ�
			if (rs != null) 
				try { 
					rs.close(); 
				} catch (SQLException ex) { ex.printStackTrace(); }
			if (pStmt != null) 
				try { 
					pStmt.close(); 
				} catch (SQLException ex) { ex.printStackTrace(); }
			if (conn != null) 
				try { 
					conn.close(); 
				} catch (SQLException ex) { ex.printStackTrace(); }
		}
		return null;	
	
	}
	
	public static void updatePost(int comm_id, String new_content) {		
		Connection conn = null;
		PreparedStatement pStmt = null;			
		ResultSet rs = null;
		
		String query = "update Community set content = ?"
				+ " where comm_id = ?";			
	
		try {
			conn = getConnection();
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, new_content);
			pStmt.setInt(2, comm_id);
			
			rs = pStmt.executeQuery();	
			System.out.println("updatePost 수행 완료 ");
			
		}catch (SQLException ex) {
			ex.printStackTrace();
		} finally {	
			if (rs != null) 
				try { 
					rs.close(); 
				} catch (SQLException ex) { ex.printStackTrace(); }
			if (pStmt != null) 
				try { 
					pStmt.close(); 
				} catch (SQLException ex) { ex.printStackTrace(); }
			if (conn != null) 
				try { 
					conn.close(); 
				} catch (SQLException ex) { ex.printStackTrace(); }
		}
    	
	}
	
}
