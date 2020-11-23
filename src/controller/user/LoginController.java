package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.service.UserManager;


public class LoginController implements Controller {
	public String execute (HttpServletRequest request, HttpServletResponse response) throws Exception {
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		
		try {
			
			UserManager.getInstance().login(user_id , password);
			
	
			HttpSession session = request.getSession();
			session.setAttribute("user_id", user_id);
			return "/MainPage.jsp";
		} catch (Exception e) {

			request.setAttribute ("loginFailed", true);
			request.setAttribute("exception", e);
			return "/user/loginForm.jsp";
			
		}
	}
}