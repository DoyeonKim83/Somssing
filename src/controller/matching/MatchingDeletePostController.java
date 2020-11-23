package controller.matching;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.*;
import controller.matching.*;
import model.Community;
import model.service.MatchingManager;

public class MatchingDeletePostController implements Controller {
	
	
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
  
    	MatchingManager manager = MatchingManager.getInstance();
    	int comm_id;
    	try {
	    	comm_id = Integer.parseInt(request.getParameter("comm_id"));
	    	boolean result = manager.deletePost(comm_id);
	    	if (result == true) {
	    		return "/matching/matchingDeleteSuccess.jsp";
	    	} else {
	    		return "/matching/matchingList.jsp";
	    	}
    	} catch (Exception e) {
    		return "/matching/matchingList.jsp";
    	}
    }
}


