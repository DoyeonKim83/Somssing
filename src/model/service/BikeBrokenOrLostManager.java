package model.service;

import java.util.List;

import model.BikeBrokenOrLost;
import model.dao.*;
import model.dao.impl.BikeBrokenOrLostDAOImpl;

public class BikeBrokenOrLostManager {
   private static BikeBrokenOrLostManager bikeBrokenOrLost = new BikeBrokenOrLostManager();
   private BikeBrokenOrLostDao bikeBrokenOrLostDao;

   private BikeBrokenOrLostManager() {
      try {
         bikeBrokenOrLostDao = new BikeBrokenOrLostDAOImpl();

      } catch (Exception e) {
         e.printStackTrace();
      }         
   }
   
   public static BikeBrokenOrLostManager getInstance() {
      return bikeBrokenOrLost;
   }
   

   public List<BikeBrokenOrLost> getBikeBrokenOrLostList(String user_id) {
      return bikeBrokenOrLostDao.getBikeBrokenOrLostList(user_id);
   }

   public int insertBikeBroken(String bike_id, String rentalOffice_name, 
         String rentalOffice_id, String why_BrokenOrLost) {
			return bikeBrokenOrLostDao.insertBikeBroken(bike_id, 
					rentalOffice_name, rentalOffice_id, why_BrokenOrLost);
   }
   
   public int insertBikeLost(String bike_id, String rentalOffice_name, 
         String rentalOffice_id, String why_BrokenOrLost) {
	   		return bikeBrokenOrLostDao.insertBikeLost(bike_id, 
					rentalOffice_name, rentalOffice_id, why_BrokenOrLost);
   }

   
}