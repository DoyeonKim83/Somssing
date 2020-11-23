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

   public void insertBikeBroken(String bike_id, String rentalOffice_name, 
         String rentalOffice_id, String why_BrokenOrLost) {
   }
   
   public void insertBikeLost(String bike_id, String rentalOffice_name, 
         String rentalOffice_id, String why_BrokenOrLost) {
   }

   
}