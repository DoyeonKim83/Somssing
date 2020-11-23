package model;

public class RentalOffice {

	private String rentalOffice_id;
	private String rentalOffice_name;
	private int latitude;
	private int longitude;
	private String area;
	

	public RentalOffice() {}
	
	public RentalOffice(int latitude, int longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public RentalOffice(String rentalOffice_id, String rentalOffice_name, int latitude, int longitude) {
		super();
		this.rentalOffice_id = rentalOffice_id;
		this.rentalOffice_name = rentalOffice_name;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	

	public RentalOffice(String rentalOffice_id, String rentalOffice_name, int latitude, int longitude, String area) {
		super();
		this.rentalOffice_id = rentalOffice_id;
		this.rentalOffice_name = rentalOffice_name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.area = area;
	}

	public String getRentalOffice_id() {
		return rentalOffice_id;
	}

	public void setRentalOffice_id(String rental_id) {
		this.rentalOffice_id = rental_id;
	}

	public String getRentalOffice_name() {
		return rentalOffice_name;
	}

	public void setRentalOffice_name(String rental_name) {
		this.rentalOffice_name = rental_name;
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
