package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.SomUser;
import model.service.UserManager;

public class TicketBuyController implements Controller {
	public String execute (HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		SomUser user = null;
		
		String user_id = null;
		int time;
		UserManager manager = UserManager.getInstance();
		
		try {
			HttpSession session = request.getSession();
			user_id = (String) session.getAttribute("user_id");
			time = Integer.parseInt(request.getParameter("ps_num"));
			
			user = manager.updateUserRemainTime(user_id, time);
			request.setAttribute("user", user);
			
			return "/ticket/ticketBuyResult.jsp";
			
		} catch (Exception e) {
			request.setAttribute ("ticketBuyFailed", true);
			request.setAttribute("exception", e);
			return "MainPage.jsp";
			// loginForm 뷰로 forward
		}
	}
}
