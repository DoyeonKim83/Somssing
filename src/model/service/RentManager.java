package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Rent;
import model.dao.RentDao;
import model.dao.impl.RentDAOImpl;


public class RentManager {
	private static RentManager rentMan = new RentManager();
	private RentDao rentDAO;

	private RentManager() {
		try {
			rentDAO = new RentDAOImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static RentManager getInstance() {
		return rentMan;
	}
	
	public int insertRent(String user_id, String rentalOffice_id) throws SQLException {
		return rentDAO.insertRent(user_id, rentalOffice_id);
	}	
	
	public int deleteRent(String bike_id) throws SQLException {
		return rentDAO.deleteRent(bike_id);
	}

	public List<Rent> getRentList(String user_id) throws SQLException {
		return rentDAO.getRentList(user_id);
	}
	
	public Rent getRentByUserId(String userId)
			throws SQLException, RentNotFoundException {
		Rent bike = rentDAO.getRentByUserId(userId);
			
			if (bike == null) {
				throw new RentNotFoundException(userId + "없습니다.");
			}		
			return bike;
		}
	
	public RentDao getMessageDAO() {
		return this.rentDAO;
	}

}
