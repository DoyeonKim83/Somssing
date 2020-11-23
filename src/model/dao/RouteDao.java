package model.dao;

import java.sql.*;

import model.Route;

public class RouteDao {
	
	private static ConnectionManager cm = new ConnectionManager();

	/* level에 맞는 Route 정보를 찾아서 반환 */
	public static Route findRoute(String level) {
		Route route = new Route();
		Connection conn = null;
		PreparedStatement pStmt = null;			// PreparedStatment 참조 변수 생성
		ResultSet rs = null;
		
		String sql = "SELECT route_id, route_mood, route_level, route_name, route_position "
				+ "FROM ROUTE " + "WHERE route_level=?";

		try {
			conn = cm.getConnection();
			
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, level);
			rs = pStmt.executeQuery();
			
			if (rs.next()) { 
				route = new Route(rs.getString("route_id"), rs.getString("route_mood"),
								level, rs.getString("route_name"), rs.getString("route_position"));
				
				return route;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {		// 자원 반납
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