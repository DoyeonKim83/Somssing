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
		System.out.println("ticket controller : 0");
		try {
			System.out.println("ticket controller : 1");
			HttpSession session = request.getSession();
			System.out.println("ticket controller : 2");
			user_id = (String) session.getAttribute("user_id");
			
			time = Integer.parseInt(request.getParameter("ps_num"));
			System.out.println("ticket controller : 3" + user_id+ ", " + time);
			user = manager.updateUserRemainTime(user_id, time);
			System.out.println("ticket controller : 4");
			request.setAttribute("user", user);
			System.out.println("ticket controller : 5");
			return "/ticket/ticketBuyResult.jsp";
			// 사용자 리스트 요청으로 redirect
		} catch (Exception e) {
			request.setAttribute ("ticketBuyFailed", true);
			request.setAttribute("exception", e);
			return "MainPage.jsp";
			// loginForm 뷰로 forward
		}
	}
}
