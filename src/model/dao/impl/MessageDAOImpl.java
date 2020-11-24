package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.MessageSend;
import model.dao.ConnectionManager;
import model.dao.MessageDao;


public class MessageDAOImpl implements MessageDao {
	
	
	private ConnectionManager cm = new ConnectionManager();
	
	public static java.sql.Date getCurrentDatetime() {
	       java.util.Date today = new java.util.Date();
	       return new java.sql.Date(today.getTime());
	}

	public List<MessageSend> getMessageSentList(String user_id) {
		
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		String query = "SELECT msg_id, msg_content, send_time, receiver_id, sender_id "
				+ "FROM MESSAGE "
				+ "WHERE sender_id = ?";

		
		try {
			conn = cm.getConnection();
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, user_id);
			rs = pStmt.executeQuery();
			
			List<MessageSend> list = new ArrayList<MessageSend>();
			while (rs.next()) {
				int msg_id = rs.getInt("msg_id");
				String msg_content = rs.getString("msg_content");
				Date send_time = rs.getDate("send_time");
				String receiver_id = rs.getString("receiver_id");
				String sender_id = rs.getString("sender_id");
	
				MessageSend msg_sent = new MessageSend(msg_id, msg_content, send_time, receiver_id, sender_id);
				list.add(msg_sent);	
			}
			return list;
		}
		catch (SQLException ex) {
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

	public List<MessageSend> getMessageReceiveList(String user_id) {
		
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;

		String query = "SELECT msg_id, msg_content, send_time, receiver_id, sender_id "
				+ "FROM MESSAGE "
				+ "WHERE receiver_id = ?";
				
				try { 
					conn = cm.getConnection();
					pStmt = conn.prepareStatement(query);
					pStmt.setString(1, user_id);
					rs = pStmt.executeQuery();			
					List<MessageSend> list = new ArrayList<MessageSend>();
					while (rs.next()) {	
						int msg_id = rs.getInt("msg_id");
						String msg_content = rs.getString("msg_content");
						Date send_time = rs.getDate("send_time");
						String receiver_id = rs.getString("receiver_id");
						String sender_id = rs.getString("sender_id");
			
						MessageSend msg_rece = new MessageSend(msg_id, msg_content, send_time, receiver_id, sender_id);
						list.add(msg_rece);
					}
					return list;		
				} catch (Exception ex) {
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
	
	public boolean insertMessageSend(MessageSend msg_send) {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		String query = "INSERT INTO MESSAGE (MSG_ID, MSG_CONTENT, SEND_TIME, RECEIVER_ID, SENDER_ID) " +
				 "VALUES (msg_seq.nextval, ?, ?, ?, ?)";
		//String query = "insert into Community (comm_id, content, comm_time, title) values (seq_comm.nextval, ?, ?, ?)";
		try {
			conn = cm.getConnection();
			
			pStmt = conn.prepareStatement(query);
		
			pStmt.setString(1, msg_send.getMsg_content());
			java.sql.Date date = getCurrentDatetime();
			pStmt.setDate(2, date);
			pStmt.setString(3, msg_send.getReceiver_id());
			pStmt.setString(4, msg_send.getSender_id());
			//System.out.println(msg_send.getMsg_id()+msg_send.getMsg_content()+msg_send.getReceiver_id()+msg_send.getSender_id()+msg_send.getSender_id());
			
			rs = pStmt.executeQuery();
			
			System.out.println("insertMessageSend ¿Ï·á");
			conn.commit();
			return true;
			
		} catch (SQLException ex) {
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
	
	
		return false;
	}
	
}