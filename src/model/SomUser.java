package model;

import java.util.Date;
import java.util.List;

public class SomUser {
	private String user_id;
	private String password;
	private String userName;
	private String email;
	private String phone; 
	private String addr;
	private Date birth;
	private String gender;
	private String grade;
	private int remain_time;
	private int rent_time; //빌린 횟수
	private int nextlevel_time; //다음 등급까지 남은 횟수
	
	public SomUser() { }
	
	public SomUser(String user_id, String password, String userName, String email, String phone, String addr, Date birth,
			String gender, String grade, int remain_time, int rent_time) {
		super();
		this.user_id = user_id;
		this.password = password;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.addr = addr;
		this.birth = birth;
		this.gender = gender;
		this.grade = grade;
		this.remain_time = remain_time;
		this.rent_time = rent_time;
	}

	public SomUser(String user_id, String password, String userName, String email, String phone, String addr,  Date birth,
			String gender) {
		super();
		this.user_id = user_id;
		this.password = password;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.addr = addr;
		this.birth = birth;
		this.gender = gender;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public  Date getBirth() {
		return birth;
	}

	public void setBirth( Date birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getRemain_time() {
		return remain_time;
	}

	public void setRemain_time(int remain_time) {
		this.remain_time = remain_time;
	}

	public int getRent_time() {
		return rent_time;
	}

	public void setRent_time(int rent_time) {
		this.rent_time = rent_time;
	}

	public int getNextlevel_time() {
		return nextlevel_time;
	}

	public void setNextlevel_time(int nextlevel_time) {
		this.nextlevel_time = nextlevel_time;
	}

	public boolean matchPassword(String password) {
		if (password == null) {
			return false;
		}
		return this.password.equals(password);
	}
	
	public boolean isSameUser(String userid) {
        return this.user_id.equals(userid);
    }
}
