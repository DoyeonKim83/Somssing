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
		SomUser user = userDAO.findUser(userId);
		if (user == null) {
			throw new UserNotFoundException(userId + "는 존재하지 않는 아이디입니다.");
		}
		//다음 등급까지 남은 횟수 처리를 위한 비즈니스 로직
		if (user.getGrade().equals("BRONZE"))
			user.setNextlevel_time(6 - user.getRent_time());
		else if (user.getGrade().equals("SILVER"))
			user.setNextlevel_time(15 - user.getRent_time());
		else if (user.getGrade().equals("GOLD"))
			user.setNextlevel_time(0);
		
		return user;
	}
}