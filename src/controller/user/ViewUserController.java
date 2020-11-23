package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.UserManager;
import model.SomUser;

public class ViewUserController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
    	// 로그인 여부 확인
    	if (!UserSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/user/login";		// login form 요청으로 redirect
        }
    	
		UserManager manager = UserManager.getInstance();
		//String userId = request.getParameter("userId");
		String userId = UserSessionUtils.getLoginUserId(request.getSession());

    	SomUser user = null;
    	user = manager.findUser(userId);	// 사용자 정보 검색
		
    	request.setAttribute("user", user);		// 사용자 정보 저장
    	if (request.getParameter("command").equals("main"))
    		return "/user/main.jsp";				
    	else {
    		return "/user/delete.jsp";
    	}
    }
}