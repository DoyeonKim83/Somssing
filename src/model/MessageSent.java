package model;

import java.util.Date;

public class MessageSent {
	private int msg_id;
	private String msg_content;
	private Date send_time;
	private String receiver_id;
	
	public MessageSent(int msg_id, String msg_content, Date send_time, String receiver_id, String sender_id) {
		super();
		this.msg_id = msg_id;
		this.msg_content = msg_content;
		this.send_time = send_time;
		this.receiver_id = receiver_id;
		this.sender_id = sender_id;
	}
	private String sender_id;
	
	public int getMsg_id() {
		return msg_id;
	}
	public void setMsg_id(int msg_id) {
		this.msg_id = msg_id;
	}
	public String getMsg_content() {
		return msg_content;
	}
	public void setMsg_content(String msg_content) {
		this.msg_content = msg_content;
	}
	public Date getSend_time() {
		return send_time;
	}
	public void setSend_time(Date send_time) {
		this.send_time = send_time;
	}
	public String getReceiver_id() {
		return receiver_id;
	}
	public void setReceiver_id(String receiver_id) {
		this.receiver_id = receiver_id;
	}
	public String getSender_id() {
		return sender_id;
	}
	public void setSender_id(String sender_id) {
		this.sender_id = sender_id;
	}
	
	

}
