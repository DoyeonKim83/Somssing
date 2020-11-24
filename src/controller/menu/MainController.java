package controller.menu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import controller.*;
import controller.user.UserSessionUtils;
import model.SomUser;
import model.service.UserManager;

public class MainController implements Controller {

   @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {      
	   
	   if (!UserSessionUtils.hasLogined(request.getSession())) {
           return "redirect:/user/loginForm";		// login form 요청으로 redirect
       }
	   
	   UserManager manager = UserManager.getInstance();
	   String userId = UserSessionUtils.getLoginUserId(request.getSession());
	   System.out.println(userId);

	   SomUser user = null;
	   user = manager.findUser(userId);	// 사용자 정보 검색
			
	   request.setAttribute("user", user);		// 사용자 정보 저장

       return "/main/MainPage.jsp";            // 사용자 보기 화면으로 이동
    }      
}