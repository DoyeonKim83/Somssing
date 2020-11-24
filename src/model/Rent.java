package model;

import java.util.Date;

public class Rent {
	private Date rental_time;
	private Date return_time;
	private int use;
	private String user_id;
	private String bike_id;
	private String rental_name;
	
	public Rent(Date rental_time, Date return_time, int use, String user_id, String bike_id, String rental_name) {
		super();
		this.rental_time = rental_time;
		this.return_time = return_time;
		this.use = use;
		this.user_id = user_id;
		this.bike_id = bike_id;
		this.rental_name = rental_name;
	}
	
	public Date getRental_time() {
		return rental_time;
	}
	public void setRental_time(Date rental_time) {
		this.rental_time = rental_time;
	}
	public Date getReturn_time() {
		return return_time;
	}
	public void setReturn_time(Date return_time) {
		this.return_time = return_time;
	}
	public int getUse() {
		return use;
	}
	public void setUse(int use) {
		this.use = use;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getBike_id() {
		return bike_id;
	}
	public void setBike_id(String bike_id) {
		this.bike_id = bike_id;
	}
	public String getRental_name() {
		return rental_name;
	}
	public void setRental_name(String rental_name) {
		this.rental_name = rental_name;
	}
	
	
	
	
}
