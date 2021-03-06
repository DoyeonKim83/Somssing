package model.dao;

import java.util.List;
import model.MessageSend;


public interface MessageDao {
	public List<MessageSend> getMessageSentList(String user_id);
	public List<MessageSend> getMessageReceiveList(String user_id);
	public boolean insertMessageSend(MessageSend msg_send);

}
