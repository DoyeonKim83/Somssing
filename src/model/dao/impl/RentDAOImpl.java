package model.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import model.dao.*;
import model.*;

public class RentDAOImpl implements RentDao {
	
private JDBCUtil jdbcUtil = null;
	
	private static String query = "SELECT RENT.RENTAL_TIME AS RENTAL_T, " +
								  "       RENT.RETURN_TIME AS RETURN_T, " +
								  "       RENT.USE AS USE_IF, " +
								  "       RENT.RENTAL_NAME AS RENTAL_N " +
								  "       RENT.BIKE_ID AS B_ID " +
								  "       RENT.USER_ID AS U_ID " +
								  "FROM RENT ";
		
	public RentDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}

	@Override
	public List<Rent> getRentList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertRent(Rent rent) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRent(Rent rent) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRent(String user_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Rent getRentOfficeByBikeId(String bike_id) {
		String searchQuery = query + "WHERE RENT.B_ID = ?";
		Object[] param = new Object[] {bike_id};

		jdbcUtil.setSql(searchQuery);
		jdbcUtil.setParameters(param);
	
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			Rent dto = new Rent();
			while (rs.next()) {
				dto.setBike_id(rs.getString("B_ID"));
				dto.setUser_id(rs.getString("U_ID"));
				dto.setRental_time(rs.getDate("RENTAL_T"));
				dto.setReturn_time(rs.getDate("RETURN_T"));
				dto.setUse(rs.getInt("USE_IF"));
				dto.setRental_name(rs.getString("RENTAL_N"));
			}
			return dto;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	@Override
	public Rent getRentOfficeByUserId(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}



}
