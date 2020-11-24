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
    	java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
  
    	MessageManager manager = MessageManager.getInstance();
    	int msg_id;
		String msg_content, receiver_id, sender_id;
		Date send_time;
    	try {
    		HttpSession session = request.getSession();
    		sender_id = (String) session.getAttribute("user_id");
			
    		msg_id = Integer.parseInt(request.getParameter("msg_id"));
    		msg_content = request.getParameter("msg_content");
    		send_time = df.parse(request.getParameter("send_time"));
    		receiver_id = request.getParameter("receiver_id");
    		sender_id = request.getParameter("sender_id");
	    	
			MessageSend msg_send = new MessageSend(msg_id, msg_content, send_time, receiver_id, sender_id);
			MessageSend new_send = manager.insertMessageSend(msg_send);
		
			request.setAttribute("new_com", new_send);					
			return "/message/messageSent.jsp"; 
    	} catch (Exception e) {
    		return "/message/messageSend.jsp";
    	}
    }
}