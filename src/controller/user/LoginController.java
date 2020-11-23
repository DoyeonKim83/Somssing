package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.SomUser;
import model.service.UserManager;


public class LoginController implements Controller {
	public String execute (HttpServletRequest request, HttpServletResponse response) throws Exception {
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		UserManager manager;
		SomUser user = null;
		try {
			System.out.println("login controller : 1");
			manager = UserManager.getInstance();
			boolean result = manager.login(user_id , password);
			
			System.out.println("login controller : 2");
			HttpSession session = request.getSession();
			session.setAttribute("user_id", user_id);
			session.setAttribute(UserSessionUtils.USER_SESSION_KEY, user_id);
			user = manager.findUser(user_id);
			
			request.setAttribute("user", user);
			
			System.out.println("login controller : 3");
			return "/MenuPage.jsp";
		} catch (Exception e) {
			System.out.println("login controller error!");
			request.setAttribute ("loginFailed", true);
			request.setAttribute("exception", e);
			return "/user/loginForm.jsp";
			
		}
	}
}