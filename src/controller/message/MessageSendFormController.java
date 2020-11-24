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
    	int comm_id;
    	String recv_id;
    	HttpSession session;
    	System.out.println("MessageSendFormControllercontroller : 0");
    	try {
    		System.out.println("MessageSendFormController controller : 1");
	    	recv_id = request.getParameter("recv_id");
	    	
	    	
	    	System.out.println("MessageSendFormController controller : 2");
	    	
			request.setAttribute("recv_id", recv_id);	
	
			return "/message/messageSend.jsp"; 
    	} catch (Exception e) {
    		return "/matchingList.jsp";
    	}
    }
}