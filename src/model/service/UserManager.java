package model.service;

import java.sql.SQLException;

import model.SomUser;
import model.dao.SomUserDao;

public class UserManager {
	private static UserManager userMan = new UserManager();
	private SomUserDao userDAO;

	private UserManager() {
		try {
			userDAO = new SomUserDao();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static UserManager getInstance() {
		return userMan;
	}
	
	public int update(SomUser user) throws SQLException, UserNotFoundException {
		return userDAO.update(user);
	}
	
	public int remove(String userId) throws SQLException, UserNotFoundException {
		return userDAO.remove(userId);
	}
	
	public SomUser findUser(String userId) throws SQLException, UserNotFoundException {
		System.out.println("finduser manager : 0");
		SomUser user = userDAO.findUser(userId);
		System.out.println("finduser manager : 1");
		if (user == null) {
			throw new UserNotFoundException(userId + "는 존재하지 않는 아이디입니다.");
		}
		//다음 등급까지 남은 횟수 처리를 위한 비즈니스 로직
		System.out.println("finduser manager : 4");
		if (user.getGrade().equals("BRONZE"))
			user.setNextlevel_time(6 - user.getRent_time());
		else if (user.getGrade().equals("SILVER"))
			user.setNextlevel_time(15 - user.getRent_time());
		else if (user.getGrade().equals("GOLD"))
			user.setNextlevel_time(0);
		System.out.println("finduser manager : 5");
		return user;
	}
	public boolean login(String userId, String password) throws SQLException, UserNotFoundException, PasswordMismatchException 
	{
		System.out.println("login manager : 0");
		SomUser user = findUser(userId);
		System.out.println("login manager : 1");
		if (!user.matchPassword(password)) {
			throw new PasswordMismatchException("비밀번호가 일치하지 않습니다");
		}
		return true;
	}
	
	public boolean create(SomUser user) throws SQLException, ExistingUserException {
		System.out.println("Manager : create!!");
		if (userDAO.existedUser(user.getUser_id()) == true) {
			throw new ExistingUserException(user.getUser_id() + "는 존재하는 아이디입니다");
		}
		return userDAO.create(user);
	}
	
	public SomUser updateUserRemainTime(String user_id, int time) throws SQLException, UserNotFoundException {
		//updateUserRemainTime
		userDAO.updateUserRemainTime(user_id, time);
		SomUser user = findUser(user_id);
		return user;
	}
}