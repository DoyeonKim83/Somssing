package model.dao;

import java.util.List;

import model.BikeBrokenOrLost;
import model.Bike;
import model.BikeTime;


public interface BikeDao {

	public BikeTime getProfByUserId(String user_id);
	public List<BikeBrokenOrLost> getBikeBrokenOrLostList(String user_id);
	public List<Bike> getBikeList(String user_id);
	public int insertBike(Bike bike);
	public int deleteBike(int bike);
	
}


