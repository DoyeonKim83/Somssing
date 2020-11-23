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
	   public RentalOffice getRentalOfficeById(String rental_id) throws SQLException, ExistingRentalOfficeIdException {
	      RentalOffice rentalOffice = rentalOfficeDao.getRentalOfficeById(rental_id);
	      
	      if (rentalOffice == null) {
	         throw new ExistingRentalOfficeIdException(rental_id + "는 존재하지 않는 자전거 대여소 아이디입니다.");
	      }      
	      return rentalOfficeDao.getRentalOfficeById(rental_id);
	   }   
	   
	   // 대여소 이름으로 검색
	   public RentalOffice getRentalOfficeByName(String rental_name) throws SQLException, ExistingRentalOfficeNameException {
	      RentalOffice rentalOffice = rentalOfficeDao.getRentalOfficeById(rental_name);
	      
	      if (rentalOffice == null) {
	         throw new ExistingRentalOfficeNameException(rental_name + "는 존재하지 않는 자전거 대여소 이름입니다.");
	      }      
	      return rentalOfficeDao.getRentalOfficeByName(rental_name);
	   }   


}
