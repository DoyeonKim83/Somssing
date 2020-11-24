package controller.message;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.MessageSent;
import model.service.MessageManager;

public class MessageSentController implements Controller{

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");

		MessageManager manager = MessageManager.getInstance();
		List<MessageSent> msgSent_List = manager.getMessageSentList(userId);
	
		request.setAttribute("msgSent_List", msgSent_List);				

		return "/message/messageSent.jsp";
	}

}
