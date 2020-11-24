package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BikeBrokenOrLost;
import model.Bike;
import model.BikeTime;
import model.dao.BikeDao;
import model.dao.ConnectionManager;


public class BikeDAOImpl implements BikeDao {
	
	private ConnectionManager cm = new ConnectionManager();
	
	public static java.sql.Date getCurrentDatetime() {
	       java.util.Date today = new java.util.Date();
	       return new java.sql.Date(today.getTime());
	}

	public BikeTime getProfByUserId(String user_id) {
		
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		String query = "SELECT bike_id, remain_time "
					+ "FROM SOM_USER u, RENT r "
					+ "WHERE user_id = ? and u.user_id = r.user_id = ? ";
		
		try {
			conn = cm.getConnection();
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, user_id);
			rs = pStmt.executeQuery();
			
			if (rs.next()) {
	
				int remain_time = rs.getInt("remain_time");
				String bike_id = rs.getString("bike_id");
				
				BikeTime biketime = new BikeTime(remain_time, bike_id);
				
				return biketime;
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
	
	@Override
	public List<BikeBrokenOrLost> getBikeBrokenOrLostList(String user_id) {
		
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		String query = "SELECT bike_id, rental_name, rental_id, broken_ok, lost_ok "
					+ "FROM BIKE b, RENT r"
					+ "WHERE user_id = ? and b.bike_id = r.bike_id";
		
		try {
			conn = cm.getConnection();
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, user_id);
			rs = pStmt.executeQuery();
			
			List<BikeBrokenOrLost> list = new ArrayList<BikeBrokenOrLost>();
			while (rs.next()) {
				String bike_id = rs.getString("bike_id");
				String rental_name = rs.getString("rental_name");
				String rental_id = rs.getString("rental_id");
				String why_broken = rs.getString("why_broken");
					
				BikeBrokenOrLost bikebroken = new BikeBrokenOrLost(bike_id, rental_name, rental_id, why_broken);
				list.add(bikebroken);	
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

	public List<Bike> getBikeList(String user_id) {
		
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;

		String query = "SELECT bike_id, rental_name, rental_id "
				+ "FROM BIKE b, RENT r"
				+ "WHERE user_id = ? and b.bike_id = r.bike_id";
				
				try { 
					conn = cm.getConnection();
					pStmt = conn.prepareStatement(query);
					pStmt.setString(1, user_id);
					rs = pStmt.executeQuery();			
					List<Bike> list = new ArrayList<Bike>();
					while (rs.next()) {	
						String bike_id = rs.getString("bike_id");
						int rental_num = rs.getInt("rental_num");
						int rental_ok = rs.getInt("rental_ok");
						int broken_ok = rs.getInt("broken_ok");
						int lost_ok = rs.getInt("lost_ok");
						String rental_id = rs.getString("rental_id");
						String rental_name = rs.getString("rental_name");

						Bike bk = new Bike(bike_id, rental_num, rental_ok, broken_ok, lost_ok, rental_id, rental_name);
						
						list.add(bk);
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
	
	public int insertBike(Bike bike) {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		String query =  "INSERT INTO BIKE (BIKE_ID, RENTAL_NUM, RENTAL_OK, BROKEN_OK, LOST_OK, RENTAL_ID, RENTAL_NAME) " +
				 "VALUES (?, ?, ?, ?, ?, ?, ?) ";
		
		try {
			conn = cm.getConnection();
			pStmt = conn.prepareStatement(query);
			
			pStmt.setString(1, bike.getBike_id());
			pStmt.setInt(2, bike.getRental_num());
			pStmt.setInt(3, bike.getRental_ok());
			pStmt.setInt(4, bike.getBroken_ok());
			pStmt.setInt(5, bike.getLost_ok());
			pStmt.setString(6, bike.getRental_id());
			pStmt.setString(7, bike.getRental_name());
			
			rs = pStmt.executeQuery();
			System.out.println("insertBike 완료");
			
//			if (rs.next()) {
//	
//				String bike_id = rs.getString("bike_id");
//				int rental_num = rs.getInt("rental_num");
//				int rental_ok = rs.getInt("rental_ok");
//				int broken_ok = rs.getInt("broken_ok");
//				int lost_ok = rs.getInt("lost_ok");
//				String rental_id = rs.getString("rental_id");
//				String rental_name = rs.getString("rental_name");
//				
//				Bike bk = new Bike(bike_id, rental_num, rental_ok, broken_ok, lost_ok, rental_id, rental_name);
//				
//				return bk;
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
	
	public int deleteBike(int bikeID) {
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		String query = "DELETE FROM BIKE WHERE bike_id = ?";
		
		try {
			conn = cm.getConnection();
			pStmt = conn.prepareStatement(query);
			pStmt.setInt(1, bikeID);
			rs = pStmt.executeQuery();
			System.out.println("deleteBike 완료 ");
			
//			if (rs.next()) {
//	
//				String bike_id = rs.getString("bike_id");
//				int rental_num = rs.getInt("rental_num");
//				int rental_ok = rs.getInt("rental_ok");
//				int broken_ok = rs.getInt("broken_ok");
//				int lost_ok = rs.getInt("lost_ok");
//				String rental_id = rs.getString("rental_id");
//				String rental_name = rs.getString("rental_name");
//				
//				Bike bk = new Bike(bike_id, rental_num, rental_ok, broken_ok, lost_ok, rental_id, rental_name);
//				
//				return bk;
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