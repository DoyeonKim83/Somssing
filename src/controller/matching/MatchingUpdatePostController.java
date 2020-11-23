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
    	System.out.println("update post controller : 0");
    	try {
	    	comm_id = Integer.parseInt(request.getParameter("comm_id"));
	    	new_title = request.getParameter("title");
	    	new_content = request.getParameter("content");
	    	System.out.println("update post controller : 1");
	    	Community com = manager.updatePost(comm_id, new_title, new_content);
	    	System.out.println("update post controller : 2");
		
			request.setAttribute("com", com);					
	
			return "/matching/matchingPost.jsp"; 
    	} catch (Exception e) {
    		return "/matchingList.jsp";
    	}
    }
}

