package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Rent;
import model.dao.ConnectionManager;
import model.dao.RentDao;




public class RentDAOImpl implements RentDao {
	
	private ConnectionManager cm = new ConnectionManager();
	
	public static java.sql.Date getCurrentDatetime() {
	       java.util.Date today = new java.util.Date();
	       return new java.sql.Date(today.getTime());
	}
	
	public Rent getRentByUserId(String user_id) {
		
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		String query = "SELECT rental_time, return_time, use, user_id, bike_id, rental_name "
				+ "FROM BIKE b, RENT r"
				+ "WHERE user_id = ? and b.bike_id = r.bike_id";
		
		try {
			conn = cm.getConnection();
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, user_id);
			rs = pStmt.executeQuery();
			
			if (rs.next()) {
				Date rental_time = rs.getDate("rental_time");
				Date return_time = rs.getDate("return_time");
				int use = rs.getInt("use");
				String user_Id = rs.getString("user_id");
				String bike_id = rs.getString("bike_id");
				String rental_name = rs.getString("rental_name");

				Rent rt = new Rent(rental_time, return_time, use, user_Id, bike_id, rental_name);
				
				return rt;
			}	
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
		
		return null;
	}
	
	public List<Rent> getRentList(String rental_name) {
		
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		String query = "SELECT rental_time, return_time, use, user_id, bike_id, rental_name "
				+ "FROM BIKE b, RENT r"
				+ "WHERE b.bike_id = r.bike_id";
		
		try {
			conn = cm.getConnection();
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, rental_name);
			rs = pStmt.executeQuery();
			
			List<Rent> list = new ArrayList<Rent>();
			if (rs.next()) {
				Date rental_time = rs.getDate("rental_time");
				Date return_time = rs.getDate("return_time");
				int use = rs.getInt("use");
				String user_id = rs.getString("user_id");
				String bike_id = rs.getString("bike_id");
				String rental_Name = rs.getString("rental_name");
					
				Rent rt = new Rent(rental_time, return_time, use, user_id, bike_id, rental_Name);
				list.add(rt);	
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

	public Rent insertRent(Rent rent) {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		String query =  "INSERT INTO RENT (rental_time, return_time, use, user_id, bike_id, rental_Name) " +
				 "VALUES (?, ?, ?, ?, ?, ?) ";
		
		try {
			conn = cm.getConnection();
			
			pStmt = conn.prepareStatement(query);
			java.sql.Date date1 = getCurrentDatetime();
			pStmt.setDate(1, date1);
			java.sql.Date date2 = getCurrentDatetime();
			pStmt.setDate(2, date2);
			pStmt.setInt(3, rent.getUse());
			pStmt.setString(4, rent.getUser_id());
			pStmt.setString(5, rent.getBike_id());
			pStmt.setString(6, rent.getRental_name());
			
			rs = pStmt.executeQuery();
			System.out.println("insertRent 완료 ");
			
//			if (rs.next()) {
//				Date rental_time = rs.getDate("rental_time");
//				Date return_time = rs.getDate("return_time");
//				int use = rs.getInt("use");
//				String user_id = rs.getString("user_id");
//				String bike_id = rs.getString("bike_id");
//				String rental_Name = rs.getString("rental_name");
//				
//				Rent rt = new Rent(rental_time, return_time, use, user_id, bike_id, rental_Name);
//				return rt;
//			}	
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
		
		return null;
	}

	public int deleteRent(String user_id) {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		String query = "DELETE FROM RENT WHERE user_id = ?";
		
		try {
			conn = cm.getConnection();
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, user_id);
			rs = pStmt.executeQuery();
			System.out.println("deleteRent 완료");
			
//			if (rs.next()) {
//	
//				Date rental_time = rs.getDate("rental_time");
//				Date return_time = rs.getDate("return_time");
//				int use = rs.getInt("use");
//				String user_Id = rs.getString("user_id");
//				String bike_id = rs.getString("bike_id");
//				String rental_Name = rs.getString("rental_name");
//				
//				Rent rt = new Rent(rental_time, return_time, use, user_Id, bike_id, rental_Name);
//				return rt;
//			}	
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
		
		return 0;
	}


}