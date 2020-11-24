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
	
	public Rent insertRent(Rent rent) throws SQLException {
		return rentDAO.insertRent(rent);
	}	
	
	public int deleteRent(String user_id) throws SQLException {
		return rentDAO.deleteRent(user_id);
	}

	public List<Rent> getRentList(String rental_name) throws SQLException {
		return rentDAO.getRentList(rental_name);
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
