package model.dao;

import java.util.List;

import model.*;

public interface MessageDao {
	public List<MessageSent> getMessageSentList(String user_id);		//보낸쪽지 확인
	public List<MessageReceive> getMessageReceiveList(String user_id);	//받은 쪽지 확인
	public int insertMessageSend(MessageSend msg_send);	// 보낸쪽지정보 추가
	public int deleteMessage(String msg_id);		// 쪽지정보를 삭제
	public MessageSend getMessageByUserId(String user_id);	// 메시지정보를 user_id로 찾음
}
