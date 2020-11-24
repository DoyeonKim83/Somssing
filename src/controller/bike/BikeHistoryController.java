package controller.bike;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Rent;
import model.service.RentManager;




public class BikeHistoryController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String rental_name = request.getParameter("rental_name");

		if (!BikeSessionUtils.hasLogined(request.getSession())) {
            return "/user/login/form";
        }
		RentManager manager = RentManager.getInstance();
		List<Rent> rentalList = manager.getRentList(rental_name);
	
		request.setAttribute("rentalList", rentalList);				
//		request.setAttribute("curUserId", 
//				BikeSessionUtils.getLoginUserId(request.getSession()));		

		return "/bike/history.jsp";
	}
}
