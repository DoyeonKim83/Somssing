package model.dao;

import java.util.List;

import model.Rent;

public interface RentDao {
	public List<Rent> getRentList(String user_id);
	public int insertRent(String user_id, String rentalOffice_id);
	public int deleteRent(String bike_id);
	public Rent getRentByUserId(String user_id);
}

