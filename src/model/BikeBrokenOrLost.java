package model;

public class BikeBrokenOrLost {

	private String bike_id;
	private String rental_name;
	private String rental_id;
	private String why_BrokenOrLost;
	
	public BikeBrokenOrLost() {}
	
	public BikeBrokenOrLost(String bike_id, String rental_name, String rental_id, String why_BrokenOrLost) {
		super();
		this.bike_id = bike_id;
		this.rental_name = rental_name;
		this.rental_id = rental_id;
		this.why_BrokenOrLost = why_BrokenOrLost;
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
	public String getRental_id() {
		return rental_id;
	}
	public void setRental_id(String rental_id) {
		this.rental_id = rental_id;
	}
	public String getWhy_BrokenOrLost() {
		return why_BrokenOrLost;
	}
	public void setWhy_BrokenOrLost(String why_lost) {
		this.why_BrokenOrLost = why_BrokenOrLost;
	}
	
	
}
