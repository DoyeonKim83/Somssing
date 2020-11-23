package model;

public class Community {
	private int comm_id;
	private String content;
	private String comm_time;
	private String user_id;
	
	
	public Community() {
		super();
	}
	public Community(int comm_id, String content, String comm_time, String user_id) {
		super();
		this.comm_id = comm_id;
		this.content = content;
		this.comm_time = comm_time;
		this.user_id = user_id;
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
	public String getComm_time() {
		return comm_time;
	}
	public void setComm_time(String comm_time) {
		this.comm_time = comm_time;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
}
