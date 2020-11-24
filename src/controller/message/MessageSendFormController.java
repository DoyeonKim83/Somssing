package controller.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.Community;
import model.service.MatchingManager;

public class MessageSendFormController implements Controller {
	
	
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
  
    	MatchingManager manager = MatchingManager.getInstance();
    	
    	String recv_id;
    	System.out.println("MessageSendFormController : 0");
    	try {
    		System.out.println("MessageSendFormController  : 1");
	    	recv_id = request.getParameter("recv_id");
	    	
	    	
	    	System.out.println("MessageSendFormController : 2");
	    	
			request.setAttribute("recv_id", recv_id);	
	
			return "/message/messageSend.jsp"; 
    	} catch (Exception e) {
    		return "/matchingList.jsp";
    	}
    }
}