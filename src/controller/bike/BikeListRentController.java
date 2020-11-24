package controller.bike;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Rent;
import model.service.RentManager;
import model.service.UserManager;

public class BikeListRentController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(BikeRentController.class);
	java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		RentManager manager = RentManager.getInstance();
		try {
			String userId = UserSessionUtils.getLoginUserId(request.getSession());
			
			List<Rent> list = new ArrayList<Rent>();
			list = manager.getRentList(userId);

			request.setAttribute("list", list);
			return "/rent/rentList.jsp";

		} catch (Exception e) {
			return "/rent/rent.jsp";
		}
	}
}
