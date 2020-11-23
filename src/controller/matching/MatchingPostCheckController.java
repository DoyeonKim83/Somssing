package controller.matching;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.service.MatchingManager;
import model.Community;

public class MatchingPostCheckController implements Controller {
	
	
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
  
    	MatchingManager manager = MatchingManager.getInstance();
    	int comm_id;
    	String user_id;
    	try {
	    	comm_id = Integer.parseInt(request.getParameter("comm_id"));
	    	Community com = manager.checkPost(comm_id);
	    	HttpSession session = request.getSession();
			user_id = (String) session.getAttribute("user_id");
			request.setAttribute("com", com);	
			request.setAttribute("user_id", user_id);
	
			return "/matching/matchingPost.jsp"; 
    	} catch (Exception e) {
    		return "/matchingList.jsp";
    	}
    }
}
