package model.service;

import java.sql.SQLException;
import java.util.List;

import model.MessageReceive;
import model.MessageSend;
import model.MessageSent;
import model.dao.MessageDao;
import model.dao.impl.MessageDAOImpl;

public class MessageManager {
	private static MessageManager msgMan = new MessageManager();
	private MessageDAOImpl msgDAO;
	
	private MessageManager() {
		try {
			msgDAO = new MessageDAOImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static MessageManager getInstance() {
		return msgMan;
	}
	
	public boolean insertMessageSend(MessageSend msg_send) throws SQLException {
		return msgDAO.insertMessageSend(msg_send);
	}	

	public List<MessageSent> getMessageSentList(String user_id)
		throws SQLException {
		return msgDAO.getMessageSentList(user_id);
	}
	
	public List<MessageReceive> getMessageReceiveList(String user_id)
			throws SQLException {
			return msgDAO.getMessageReceiveList(user_id);
		}
	
	public MessageDao getMessageDAO() {
		return this.msgDAO;
	}
}
