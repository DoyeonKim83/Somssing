package controller.route;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.RouteManager;
import model.Route;

public class RouteResultController implements Controller {
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		RouteManager manager = RouteManager.getInstance();
		String level = request.getParameter("level");
		
    	Route route = null;
    	route = manager.findRoute(level);	
    	
    	if (route == null) {
    		request.setAttribute("exception", 
					new IllegalStateException("알맞은 난이도를 입력하세요."));       
			return "/recommendation/search.jsp"; //search.jsp로 돌아가서 경고창 띄움
    	}
    	request.setAttribute("route", route);					
		return "/recommendation/result.jsp";	
	}
}
