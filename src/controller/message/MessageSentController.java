package controller.message;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.MessageSend;
import model.service.MessageManager;

public class MessageSentController implements Controller{

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session;
		
		try {
			
			session = request.getSession();
			String user_id = (String) session.getAttribute("user_id");

			MessageManager manager = MessageManager.getInstance();
			List<MessageSend> msgSent_List = manager.getMessageSentList(user_id);
	
			request.setAttribute("list", msgSent_List);				

			return "/message/messageSent.jsp";
		} catch (Exception e) {
    		return "/main/MenuPage.jsp";
    	}
	}

}
