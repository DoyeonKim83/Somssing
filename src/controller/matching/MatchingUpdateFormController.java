package controller.matching;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.Community;
import model.service.MatchingManager;

public class MatchingUpdateFormController implements Controller {
	
	
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
  
    	MatchingManager manager = MatchingManager.getInstance();
    	int comm_id;
    	String user_id;
    	HttpSession session;
    	System.out.println("MatchingUpdateFormController controller : 0");
    	try {
    		System.out.println("MatchingUpdateFormController controller : 1");
	    	comm_id = Integer.parseInt(request.getParameter("comm_id"));
	    	Community com = manager.checkPost(comm_id);
	    	System.out.println("MatchingUpdateFormController controller : 2");
	    	
			request.setAttribute("com", com);	
	
			return "/matching/matchingUpdatePost.jsp"; 
    	} catch (Exception e) {
    		return "/matchingList.jsp";
    	}
    }
}
