package model.dao;

import java.util.List;

import model.*;

public interface RentDao {
	public List<Rent> getRentList();		// 전체 자전거 정보를 획득
	public int insertRent(Rent rent);	// 자전거정보를 추가
	public int updateRent(Rent rent);	// 자전거정보를 수정
	public int deleteRent(String user_id);		// 자전거정보를 삭제
	public Rent getRentOfficeByUserId(String user_id);		// 자전거정보를 user_id로 찾음
	public Rent getRentOfficeByBikeId(String bike_id);		// 자전거정보를 bike_id로 찾음
}

