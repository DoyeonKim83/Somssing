package model.service;

import java.sql.SQLException;
import java.util.List;

import model.RentalOffice;
import model.dao.*;
import model.dao.impl.RentalOfficeDAOImpl;

public class RentalOfficeManager {
	   private static RentalOfficeManager rentalOffice = new RentalOfficeManager();
	   private RentalOfficeDao rentalOfficeDao;

	   private RentalOfficeManager() {
	      try {
	         rentalOfficeDao = new RentalOfficeDAOImpl();
	         // rentalOfficeAnalysis = new RentalOfficeAnalysis(); // rentalOfficeDao
	      } catch (Exception e) {
	         e.printStackTrace();
	      }         
	   }
	   
	   public static RentalOfficeManager getInstance() {
	      return rentalOffice;
	   }
	   

	   // 전체 대여소 목록 보기
	   public List<RentalOffice> getRentalOfficeList(String area) throws SQLException{
	      return rentalOfficeDao.getRentalOfficeList(area);
	   };            
	   
	   // 대여소 아이디로 검색
	   public RentalOffice getRentalOfficeById(String rental_id) throws SQLException {
	      RentalOffice rentalOffice = rentalOfficeDao.getRentalOfficeById(rental_id);
	      
    
	      return rentalOfficeDao.getRentalOfficeById(rental_id);
	   }   
	   
	   // 대여소 이름으로 검색
	   public RentalOffice getRentalOfficeByName(String rental_name) throws SQLException {
		  System.out.println(rental_name);
	      RentalOffice rentalOffice = rentalOfficeDao.getRentalOfficeByName(rental_name);
	      
	      return rentalOfficeDao.getRentalOfficeByName(rental_name);
	   }   


}
