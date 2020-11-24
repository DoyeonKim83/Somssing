package controller.bike;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Rent;
import model.service.RentManager;


public class BikeRentController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(BikeRentController.class);
    java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	RentManager manager = RentManager.getInstance();
    	try {
    	Date rental_time = df.parse(request.getParameter("rental_time"));
    	Date return_time = df.parse(request.getParameter("return_time"));
    	int use = Integer.parseInt(request.getParameter("use"));
    	String user_id = request.getParameter("user_id");
    	String bike_id = request.getParameter("bike_id");
    	String rental_name = request.getParameter("rental_name");
	
    	System.out.println(rental_time);
    	System.out.println(bike_id);
    	System.out.println(rental_name);
        
    	
    	List<Rent> list = new ArrayList<Rent>();
    	list = manager.getRentList(bike_id);
    	
    	Rent rent = new Rent(rental_time, return_time, use, user_id, bike_id, rental_name);
    	Rent new_rent = manager.insertRent(rent);
		
	    request.setAttribute("new_rent", new_rent);
	        return "/bike/rentList.jsp";
	        
		} catch (Exception e) {
			return "/bike/rent.jsp";
		}
    }
}
