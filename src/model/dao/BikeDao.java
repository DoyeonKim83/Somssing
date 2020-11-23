package model.dao;

import java.util.List;

import model.*;

public interface BikeDao {
	public List<Bike> getBikeList();		// 전체 자전거 정보를 획득
	public int insertBike(Bike bike);	// 자전거정보를 추가
	public int deleteBike(String stuNo);		// 자전거정보를 삭제
//	public BikeDTO getBikeByUserId(int user_id);		// 자전거정보를 user_id로 찾음
	public Bike getBikeByBikeId(String bike_id);		// 자전거정보를 bike_id로 찾음
	// 유저아이디로 이용중인 자전거 정보와 시간 찾기
	public BikeTime getMyBikeByUserId(String user_id);
	// 고장, 분실 신고된 자전거 list(상세정보) 보기 
	public List<BikeBrokenOrLost> getBikeBrokenOrLostList(String user_id);	
}