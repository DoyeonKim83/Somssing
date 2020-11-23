package model.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.*;
import model.*;

public class RentalOfficeDAOImpl implements RentalOfficeDao {
	
	public RentalOfficeDAOImpl() {
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
	

	public List<RentalOffice> getRentalOfficeList(String area){
		
		Connection conn = null;
		PreparedStatement pStmt = null;	
		ResultSet rs = null;
		
		String query = "SELECT area, rental_name, rental_id, latitude, longitude "
					+ "FROM rentaloffice "
					+ "WHERE area = ?";
		
		try {
			conn = getConnection();
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, area);
			rs = pStmt.executeQuery();
			
			List<RentalOffice> list = new ArrayList<RentalOffice> ();
			while (rs.next()) {
	
				String rental_name = rs.getString("rental_name");
				String rental_id = rs.getString("rental_id");
				int latitude = rs.getInt("latitude");
				int longitude = rs.getInt("longitude");
				
				RentalOffice rental = new RentalOffice(rental_id, rental_name, latitude, longitude, area);
				list.add(rental);
			}	
			return list;
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
	
	public RentalOffice getRentalOfficeById(String rental_id) {
		
		Connection conn = null;
		PreparedStatement pStmt = null;			
		ResultSet rs = null;
		
		String query = "SELECT area, rental_name, rental_id, latitude, longitude "
					+ "FROM rentaloffice "
					+ "WHERE rental_id = ?";
		
		try {
			conn = getConnection();
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, rental_id);
			rs = pStmt.executeQuery();
			
			if (rs.next()) {
	
				String rental_name = rs.getString("rental_name");
				int latitude = rs.getInt("latitude");
				int longitude = rs.getInt("longitude");
				String area = rs.getString("area");
				
				RentalOffice rental = new RentalOffice(rental_id, rental_name, latitude, longitude, area);
				
				return rental;
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
	
	public RentalOffice getRentalOfficeByName(String rental_name) {
		Connection conn = null;
		PreparedStatement pStmt = null;		
		ResultSet rs = null;
		
		String query = "SELECT area, rental_name, rental_id, latitude, longitude "
					+ "FROM rentaloffice "
					+ "WHERE rental_name = ?";
		
		try {
			conn = getConnection();
			pStmt = conn.prepareStatement(query);
			pStmt.setString(1, rental_name);
			rs = pStmt.executeQuery();
			
			if (rs.next()) {
	
				String rental_id = rs.getNString("rental_id");
				int latitude = rs.getInt("latitude");
				int longitude = rs.getInt("longitude");
				String area = rs.getString("area");
				
				RentalOffice rental = new RentalOffice(rental_id, rental_name, latitude, longitude, area);
				
				return rental;
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

}
