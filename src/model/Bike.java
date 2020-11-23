package model;

public class Bike {
	private String bike_id;
	private int rental_num;
	private int rental_ok;
	private int broken_ok;
	private int lost_ok;
	private String rental_id;
	private String rental_name;
	
	public String getBike_id() {
		return bike_id;
	}
	public void setBike_id(String bike_id) {
		this.bike_id = bike_id;
	}
	public int getRental_num() {
		return rental_num;
	}
	public void setRental_num(int rental_num) {
		this.rental_num = rental_num;
	}
	public int getRental_ok() {
		return rental_ok;
	}
	public void setRental_ok(int rental_ok) {
		this.rental_ok = rental_ok;
	}
	public int getBroken_ok() {
		return broken_ok;
	}
	public void setBroken_ok(int broken_ok) {
		this.broken_ok = broken_ok;
	}
	public int getLost_ok() {
		return lost_ok;
	}
	public void setLost_ok(int lost_ok) {
		this.lost_ok = lost_ok;
	}
	public String getRental_id() {
		return rental_id;
	}
	public void setRental_id(String rental_id) {
		this.rental_id = rental_id;
	}
	public String getRental_name() {
		return rental_name;
	}
	public void setRental_name(String rental_name) {
		this.rental_name = rental_name;
	}

}
