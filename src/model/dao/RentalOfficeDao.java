package model.dao;

import java.util.List;

import model.*;

public interface RentalOfficeDao {
	
	// 전체 대여소 목록 보기
	public List<RentalOffice> getRentalOfficeList(String area);				
	
	// 대여소 아이디로 검색
	public RentalOffice getRentalOfficeById(String rental_id);	
	
	// 대여소 이름으로 검색
	public RentalOffice getRentalOfficeByName(String rental_name);	
	
}