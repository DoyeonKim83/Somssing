package model;

public class RentalOffice {

	private String rental_id;
	private String rental_name;
	private int latitude;
	private int longitude;
	private String area;
	

	public RentalOffice() {}
	
	public RentalOffice(int latitude, int longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public RentalOffice(String rental_id, String rental_name, int latitude, int longitude) {
		super();
		this.rental_id = rental_id;
		this.rental_name = rental_name;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	

	public RentalOffice(String rental_id, String rental_name, int latitude, int longitude, String area) {
		super();
		this.rental_id = rental_id;
		this.rental_name = rental_name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.area = area;
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

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}



}
