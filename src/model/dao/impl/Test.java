package model.dao.impl;

import model.dao.BikeBrokenOrLostDao;
import model.service.*;

public class Test {

   private static BikeBrokenOrLostDao cm = new BikeBrokenOrLostDAOImpl();
   
   public static void main(String[] args) {
   
      BikeBrokenOrLostManager manager = BikeBrokenOrLostManager.getInstance();
      int r = manager.insertBikeBroken("B001", "동덕여대 후문", "10001", "그냥");
      
      if(r != 0) {
    	 System.out.print("안녕");
      }
      

   }
}