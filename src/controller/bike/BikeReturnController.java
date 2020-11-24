package controller.bike;
//BikeReturnController
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Rent;
import model.service.RentManager;


public class BikeReturnController implements Controller {
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    	RentManager manager = RentManager.getInstance();
    	
    	try {
	    	String bikeId = request.getParameter("bikeId");
	    	System.out.println(bikeId);
	    	
			manager.deleteRent(bikeId);
			return "redirect:/rent/list";
    	} catch (Exception e) {
    		e.printStackTrace();
			return "/rent/rentList.jsp";
		}
	}
}
