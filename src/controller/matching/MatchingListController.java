package controller.matching;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.MatchingManager;
import model.Community;

public class MatchingListController implements Controller {
	

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
  
    	MatchingManager manager = MatchingManager.getInstance();
    	List<Community> comList = manager.printComList();
    	
	
		request.setAttribute("comList", comList);					

		return "/matching/matchingList.jsp"; 
    }
}