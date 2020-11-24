package controller.message;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.MessageSend;
import model.service.MessageManager;


public class MessageSendController implements Controller{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    	
  
    	MessageManager manager = MessageManager.getInstance();
    	int msg_id;
		String msg_content, receiver_id, sender_id;
		Date send_time;
    	try {
    		System.out.println("MessageSendControllercontroller : 0");
    		HttpSession session = request.getSession();
    		sender_id = (String) session.getAttribute("user_id");
    		System.out.println("MessageSendControllercontroller : 1");
    		
    		
    		msg_content = request.getParameter("msg_content");
    		receiver_id = request.getParameter("receiver_id");
 
    		
    		System.out.println("MessageSendControllercontroller : 2");
			MessageSend msg_send = new MessageSend(msg_content, receiver_id, sender_id);
			System.out.println("MessageSendControllercontroller : 3");
			MessageSend new_send = manager.insertMessageSend(msg_send);
			System.out.println("MessageSendControllercontroller : 4");
			request.setAttribute("new_com", new_send);					
			return "/message/messageSent.jsp"; 
    	} catch (Exception e) {
    		return "/message/messageSend.jsp";
    	}
    }
}