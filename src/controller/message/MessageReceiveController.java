package controller.message;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.MessageReceive;
import model.service.MessageManager;


public class MessageReceiveController implements Controller{

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("user_id");

		MessageManager manager = MessageManager.getInstance();
		List<MessageReceive> msgRe_List = manager.getMessageReceiveList(userId);
	
		request.setAttribute("msgRe_List", msgRe_List);					

		return "/message/messageReceive.jsp";
	}

}
