package model;

public class BikeTime {

	private int remain_time;
	private String bike_id;


	public BikeTime() {}
	
	public BikeTime(int remain_time, String bike_id) {
		super();
		this.remain_time = remain_time;
		this.bike_id = bike_id;
	}

	public int getRemain_time() {
		return remain_time;
	}

	public void setRemain_time(int remain_time) {
		this.remain_time = remain_time;
	}

	public String getBike_id() {
		return bike_id;
	}

	public void setBike_id(String bike_id) {
		this.bike_id = bike_id;
	}

}
