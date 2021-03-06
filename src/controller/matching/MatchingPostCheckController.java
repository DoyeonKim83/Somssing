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
    	HttpSession session;
    	System.out.println("postcheck controller : 0");
    	try {
    		System.out.println("postcheck controller : 1");
	    	comm_id = Integer.parseInt(request.getParameter("comm_id"));
	    	Community com = manager.checkPost(comm_id);
	    	System.out.println("postcheck controller : 2");
	    	session = request.getSession();
			user_id = (String) session.getAttribute("user_id"); 
			System.out.println("postcheck controller : 3");
			request.setAttribute("com", com);	
			request.setAttribute("user_id", user_id);
			System.out.println("postcheck controller : 4");
	
			return "/matching/matchingPost.jsp"; 
    	} catch (Exception e) {
    		return "/matchingList.jsp";
    	}
    }
}
