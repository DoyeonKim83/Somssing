package controller.matching;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.service.MatchingManager;
import model.Community;

public class MatchingWritingController implements Controller {
	
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
  
    	MatchingManager manager = MatchingManager.getInstance();
    	String content, title, user_id;
    	try {
    		HttpSession session = request.getSession();
			user_id = (String) session.getAttribute("user_id");
			
			title = request.getParameter("title");
	    	content = request.getParameter("content");
	    	
	    	Community com = new Community(content, title, user_id);
	    	Community new_com = manager.insertCommunity(com);
		
			request.setAttribute("new_com", new_com);					
			return "/matching/matchingPost.jsp"; 
    	} catch (Exception e) {
    		return "/matchingList.jsp";
    	}
    }
}
