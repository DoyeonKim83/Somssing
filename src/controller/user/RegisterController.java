package controller.user;


import java.util.Date;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

import model.SomUser;
import model.service.ExistingUserException;
import model.service.UserManager;

public class RegisterController implements Controller {

	public String execute (HttpServletRequest request, HttpServletResponse response) throws Exception {
		java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
		System.out.println("controller : 1");
		SomUser user = new SomUser(request.getParameter("user_id"), request.getParameter("password")
						, request.getParameter("userName"), request.getParameter("email"), request.getParameter("phone")
						, request.getParameter("addr"), df.parse(request.getParameter("birth")), request.getParameter("gender")
						, "BRONZE", 0);
		System.out.println("controller : 2" + request.getParameter("user_id")+ request.getParameter("password")
				+ request.getParameter("userName")+ request.getParameter("email")+ request.getParameter("phone")
				+ request.getParameter("addr")+ df.parse(request.getParameter("birth"))+ request.getParameter("gender"));
		try {
			UserManager manager = UserManager.getInstance();
			System.out.println("controller : 3");
			boolean result = manager.create(user);
			System.out.println("controller : 4");
			
			return "/user/loginForm.jsp";
		} catch (ExistingUserException e) {
			

			request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("user", user);
			return "/user/registerForm.jsp";
		}
	}
}

