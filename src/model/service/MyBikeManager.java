package model.service;

import java.sql.SQLException;
import java.util.List;

import model.BikeTime;
import model.RentalOffice;
import model.dao.*;
import model.dao.impl.BikeDAOImpl;

public class MyBikeManager {
   private static MyBikeManager bike = new MyBikeManager();
   private BikeDao bikeDao;

   public MyBikeManager() {
      try {
         bikeDao = new BikeDAOImpl();
         // rentalOfficeAnalysis = new RentalOfficeAnalysis(); // rentalOfficeDao
      } catch (Exception e) {
         e.printStackTrace();
      }         
   }
   
   public static MyBikeManager getInstance() {
      return bike;
   }
   
   // 유저아이디로 이용중인 자전거 정보와 시간 찾기
   public BikeTime getBikeTimeByUserId(String user_id) throws ExistingMyBikeException {
      BikeTime bikeTime = bikeDao.getMyBikeByUserId(user_id);
      
      if (bikeTime == null) {
         throw new ExistingMyBikeException(user_id + "님은 현재 이용중이신 자전거가 없습니다.");
      }
      return bikeDao.getMyBikeByUserId(user_id);
   }

   
}