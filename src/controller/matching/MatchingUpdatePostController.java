package controller.matching;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.MatchingManager;
import model.Community;

public class MatchingUpdatePostController implements Controller {
	
	
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
  
    	MatchingManager manager = MatchingManager.getInstance();
    	int comm_id;
    	String new_content;
    	String new_title;
    	try {
	    	comm_id = Integer.parseInt(request.getParameter("comm_id"));
	    	new_title = request.getParameter("title");
	    	new_content = request.getParameter("content");
	    	Community com = manager.updatePost(comm_id, new_title, new_content);
		
			request.setAttribute("com", com);					
	
			return "/matching/matchingPost.jsp"; 
    	} catch (Exception e) {
    		return "/matchingList.jsp";
    	}
    }
}

