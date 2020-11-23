package model;

import java.util.Date;

public class Route {
	private String route_id;
	private String route_mood;
	private String route_level;
	private String route_name;
	private String route_position;
	
	public Route() { }
	
	public Route(String route_id, String route_mood, String route_level, String route_name, String route_position) {
		super();
		this.route_id = route_id;
		this.route_mood = route_mood;
		this.route_level = route_level;
		this.route_name = route_name;
		this.route_position = route_position;
	}

	public String getRoute_id() {
		return route_id;
	}

	public void setRoute_id(String route_id) {
		this.route_id = route_id;
	}

	public String getRoute_mood() {
		return route_mood;
	}

	public void setRoute_mood(String route_mood) {
		this.route_mood = route_mood;
	}

	public String getRoute_level() {
		return route_level;
	}

	public void setRoute_level(String route_level) {
		this.route_level = route_level;
	}

	public String getRoute_name() {
		return route_name;
	}

	public void setRoute_name(String route_name) {
		this.route_name = route_name;
	}

	public String getRoute_position() {
		return route_position;
	}

	public void setRoute_position(String route_position) {
		this.route_position = route_position;
	}
}