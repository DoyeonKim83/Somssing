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
	
	public List<Rent> getRentList(String user_id) {
		
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		String query = "SELECT rental_time, return_time, use, user_id, b.bike_id bid, b.rental_name rname "
				+ "FROM bike b, rent r "
				+ "WHERE b.bike_id = r.bike_id and r.user_id=?";
		
		try {
			conn = cm.getConnection();
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, user_id);
			rs = pStmt.executeQuery();
			
			List<Rent> list = new ArrayList<Rent>();
			while (rs.next()) {
				Date rental_time = rs.getDate("rental_time");
				Date return_time = rs.getDate("return_time");
				int use = rs.getInt("use");
				String bike_id = rs.getString("bid");
				String rental_Name = rs.getString("rname");
					
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

	public int insertRent(String user_id, String rentalOffice_id) {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		String bike_id = null;
		String rental_name = null;
		int broken_ok = -1, rental_ok = -1, lost_ok = -1;
		int result = -1;
		
		String query1 = "SELECT rental_ok, broken_ok, lost_ok, b.rental_name rname, b.bike_id bid "
				   + "FROM rentaloffice r, bike b "
				   + "WHERE r.rental_name = b.rental_name and r.rental_id=?";
		
		String query2 =  "INSERT INTO RENT (rental_time, return_time, use, user_id, bike_id, rental_Name) " +
				 "VALUES (?, ?, ?, ?, ?, ?) ";
		
		try {
			conn = cm.getConnection();
			
			pStmt = conn.prepareStatement(query1);
			pStmt.setString(1, rentalOffice_id);
			rs = pStmt.executeQuery();
			if (rs.next()) {
				bike_id = rs.getString("bid");
				rental_ok = rs.getInt("rental_ok");
				broken_ok = rs.getInt("broken_ok");
				lost_ok = rs.getInt("lost_ok");
				rental_name = rs.getString("rname");
			}
			
			pStmt.close();
			
			java.sql.Date date = getCurrentDatetime();
			if (rental_ok == 0 && broken_ok == 0 && lost_ok == 0) {
				pStmt = conn.prepareStatement(query2);
				pStmt.setDate(1, date);
				pStmt.setDate(2, date);
				pStmt.setInt(3, 1);
				pStmt.setString(4, user_id);
				pStmt.setString(5, bike_id);
				pStmt.setString(6, rental_name);
			}
			
			result = pStmt.executeUpdate(); // update 문 실행
			if (result != -1) {
				conn.commit();
			} else {
				conn.rollback();
			}
			return result;
			
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
		
		return -1;
	}

	public int deleteRent(String bike_id) {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		int result = -1; 
		
		String query = "DELETE FROM RENT WHERE bike_id=?";
		
		try {
			conn = cm.getConnection();
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, bike_id);
			result = pStmt.executeUpdate();
			System.out.println("deleteRent 완료");
			
			if (result != -1) {
				conn.commit();
			} else {
				conn.rollback();
			}

			return result;
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
		
		return -1;
	}


}