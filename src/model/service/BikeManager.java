package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Bike;
import model.BikeTime;
import model.dao.BikeDao;
import model.dao.impl.BikeDAOImpl;

public class BikeManager {
	private static BikeManager bikeMan = new BikeManager();
	private BikeDao bikeDAO;
	private BikeTime biketimeDAO;
//	private UserAnalysis userAanlysis;

	private BikeManager() {
		try {
			bikeDAO = new BikeDAOImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static BikeManager getInstance() {
		return bikeMan;
	}

	public int insertBike(Bike bike) throws SQLException, BikeNotFoundException {
		return bikeDAO.insertBike(bike);
	}	

	public int deleteBike(int bike) throws SQLException, BikeNotFoundException {
		return bikeDAO.deleteBike(bike);
	}

	public BikeTime getProfByUserId(String userId)
		throws SQLException, BikeNotFoundException {
		BikeTime biketime = ((BikeDao) biketimeDAO).getProfByUserId(userId);
		
		if (biketime == null) {
			throw new BikeNotFoundException(userId + "없습니다.");
		}		
		return biketime;
	}

	public List<Bike> getBikeList(String user_id)
		throws SQLException {
		return bikeDAO.getBikeList(user_id);
	}
	
	public BikeDao getBikeDAO() {
		return this.bikeDAO;
	}
}
