package model.dao;

import java.util.List;

import model.BikeBrokenOrLost;
import model.*;

public interface BikeBrokenOrLostDao {

   public List<BikeBrokenOrLost> getBikeBrokenOrLostList(String user_id);
   
   public void insertBikeBroken(
         String bike_id, String rentalOffice_name, 
         String rentalOffice_id, String why_BrokenOrLost);
   
   public void insertBikeLost(
         String bike_id, String rentalOffice_name, 
         String rentalOffice_id, String why_BrokenOrLost);
   
}