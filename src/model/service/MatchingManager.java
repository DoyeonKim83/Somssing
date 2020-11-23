package model.service;

import java.util.List;

import model.Community;
import model.dao.MatchingDao;

public class MatchingManager {
	private static MatchingManager matchingMan = new MatchingManager();
	private MatchingDao matchingDao;
	//private UserAnalysis userAanlysis;

	private MatchingManager() {
		try {
			matchingDao = new MatchingDao();
			//.userAanlysis = new UserAnalysis(userDAO);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static MatchingManager getInstance() {
		return matchingMan;
	}
	//�Խù� ����.
	public Community insertCommunity(Community com) {
		System.out.println(" Matchingmanager: insertCommunity ���� �Ϸ� ");
		int comm_id = matchingDao.insertCommunity(com);
		return checkPost(comm_id);
		
	}
	//�Խù� ����.
	public Community checkPost(int comm_id) {
		System.out.println(" Matchingmanager: checkPost ���� �Ϸ� ");
		Community chCom = matchingDao.checkPost(comm_id);
		return chCom;
	}
	
	// �Խù� ���� 
	public Community updatePost(int comm_id, String new_title, String new_content) {
		System.out.println(" Matchingmanager: updatePost ���� �Ϸ� ");
		matchingDao.updatePost(comm_id, new_title, new_content);
		return checkPost(comm_id);
	}
	
	//�Խù� ��� ��� 
	public List<Community> printComList() {
		System.out.println(" Matchingmanager: printComList() ���� ");
		return matchingDao.printComList();
	}
	
	public boolean deletePost(int comm_id) {
		System.out.println(" Matchingmanager: deletePost ���� ");
		return matchingDao.deletePost(comm_id);
	}

}
