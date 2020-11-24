package model.dao;

import java.util.List;
import model.MessageReceive;
import model.MessageSend;
import model.MessageSent;


public interface MessageDao {
	public List<MessageSent> getMessageSentList(String user_id);
	public List<MessageReceive> getMessageReceiveList(String user_id);
	public MessageSend insertMessageSend(MessageSend msg_send);

}
