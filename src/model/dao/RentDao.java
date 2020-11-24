package model.dao;

import java.util.List;

import model.Rent;

public interface RentDao {
	public List<Rent> getRentList(String rental_name);
	public Rent insertRent(Rent rent);
	public int deleteRent(String user_id);
	public Rent getRentByUserId(String user_id);
}

