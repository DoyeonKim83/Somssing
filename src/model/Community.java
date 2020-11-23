package model;

import java.util.Date;

public class Community {
	private int comm_id;
	private String content;
	private String title;
	private Date comm_time;
	private String user_id;
	
	
	public Community() {
		super();
	}
	
	public Community(String content, String title, String user_id) {
		super();
		this.content = content;
		this.title = title;
		this.user_id = user_id;
	}

	public Community(String content, String title, Date comm_time, String user_id) {
		super();
		this.content = content;
		this.title = title;
		this.comm_time = comm_time;
		this.user_id = user_id;
	}


	public Community(int comm_id, String content, String title, Date comm_time, String user_id) {
		super();
		this.comm_id = comm_id;
		this.content = content;
		this.title = title;
		this.comm_time = comm_time;
		this.user_id = user_id;
	}



	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getComm_id() {
		return comm_id;
	}
	public void setComm_id(int comm_id) {
		this.comm_id = comm_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getComm_time() {
		return comm_time;
	}
	public void setComm_time(Date comm_time) {
		this.comm_time = comm_time;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
}
