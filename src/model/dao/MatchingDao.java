package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.Community;




public class MatchingDao {
	
	
	private static ConnectionManager cm = new ConnectionManager();

	
	public static java.sql.Date getCurrentDatetime() {
	       java.util.Date today = new java.util.Date();
	       return new java.sql.Date(today.getTime());
	}
	
	public static int insertCommunity(Community com) {
		Connection conn = null;
		PreparedStatement pStmt = null;			// PreparedStatment ���� ���� ����
		ResultSet rs = null;
		Community comNew;
		
		//String seqQuery = "select seq_comm.nextval from dual";
		
		String query = "insert into Community (comm_id, content, comm_time, title) values (seq_comm.nextval, ?, ?, ?)";
		
		String query2 = "insert into post (user_id, comm_id)"
				+ " values(?, seq_comm.currval)";
		
		String query3 = "select seq_comm.currval from dual";
		try {
			conn = cm.getConnection(); 
			
			
			pStmt = conn.prepareStatement(query);
				
			pStmt.setString(1, com.getContent());			
			java.sql.Date date = getCurrentDatetime();
			pStmt.setDate(2, date);
			pStmt.setString(3, com.getTitle());
			rs = pStmt.executeQuery();	
			
			
			pStmt = conn.prepareStatement(query2);
			pStmt.setString(1, com.getUser_id());
			rs = pStmt.executeQuery();
			
			pStmt = conn.prepareStatement(query3);
			rs=pStmt.executeQuery();
			int comm_id = 0;
			if (rs.next()) {
				comm_id = rs.getInt(1);
			}	
			
			System.out.println("insertCommunity() 수행완료 ");
			return comm_id;
			
			
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
 

       return 0;
	}
	
	public static List<Community> printComList() {
		Connection conn = null;
		PreparedStatement pStmt = null;			
		ResultSet rs = null;
		List<Community> list = new ArrayList<>();
		Community comm;
		
		String query = "select comm_id, content, comm_time, user_id, title"
				+ " from Community c join Post p using (comm_id)"
				+ " order by comm_id desc";

		
		try {
			conn = cm.getConnection();
			pStmt = conn.prepareStatement(query);
			rs = pStmt.executeQuery();
			
			
			while (rs.next()) {
				int comm_id = rs.getInt("comm_id");
				String content = rs.getString("content");
				Date comm_time = rs.getDate("comm_time");
				String user_id = rs.getString("user_id");
				String title = rs.getString("title");
				comm = new Community(comm_id, content, title, comm_time, user_id);
				list.add(comm);	
			}
			System.out.println(" printComList() 수행완료 ");
			return list;
			
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
	
	public static Community checkPost(int comm_id) {
		Connection conn = null;
		PreparedStatement pStmt = null;			
		ResultSet rs = null;
		Community comm = null;
		
		String query = "select comm_id, content, comm_time, title, user_id"
				+ " from Community c join Post p using (comm_id)"
				+ " where comm_id = ?";
		try {
			conn = cm.getConnection();
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, comm_id);
			rs = pStmt.executeQuery();
			if (rs.next()) {
				String content = rs.getString("content");
				Date comm_time = rs.getDate("comm_time");
				String title = rs.getString("title");
				String user_id = rs.getString("user_id");
				comm = new Community(comm_id, content, title, comm_time, user_id);
			}
			System.out.println("checkCom 수행완료 ");
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
	
	public static void updatePost(int comm_id, String new_title, String new_content) {
		
		Connection conn = null;
		PreparedStatement pStmt = null;			// PreparedStatment ���� ���� ����
		ResultSet rs = null;
		
		String query = "update Community set content = ?, title = ?"
				+ " where comm_id = ?";			
	
		try {
			conn = cm.getConnection();
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, new_content);
			pStmt.setString(2, new_title);
			pStmt.setInt(3, comm_id);
			
			rs = pStmt.executeQuery();	
			System.out.println("updatePost 수행완료 ");
			
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
    	
	}
	
	public static boolean deletePost(int comm_id) {
		
		Connection conn = null;
		PreparedStatement pStmt = null;		
		ResultSet rs = null;
		
		String query = "delete from post where comm_id=?";
		String query2 = "delete from community where comm_id=?";

		try {
			conn = cm.getConnection();
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, comm_id);			
			rs = pStmt.executeQuery();	
		
			pStmt = conn.prepareStatement(query2);
			pStmt.setInt(1, comm_id);			
			rs = pStmt.executeQuery();	
			System.out.println("deletePost 수행완료 ");
			return true;
			
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
		return false;
    	
	}
	
	
}
