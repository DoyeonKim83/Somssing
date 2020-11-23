package model.dao;

import model.dao.impl.*;

public class DAOFactory {
	
	public BikeDao getBikeDAO() {
		return new BikeDAOImpl();		
	}
	
//	public UserRentalDAO getUserRentalDAO() {
//		return new UserRentalDAOImpl();		
//	}
	
	public RentDao getRentDAO() {
		return new RentDAOImpl();		
	}

	public SearchRentalOfficeDao getRentalOfficeDAO() {
		return new RentalOfficeDAOImpl();		
	}
	
	public MessageDao getMessageDAO() {
		return new MessageDAOImpl();		
	}
	
}
