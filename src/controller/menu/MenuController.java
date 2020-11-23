package controller.menu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import controller.*;
import controller.user.UserSessionUtils;

public class MenuController implements Controller {

   @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {      
	   
	   if (!UserSessionUtils.hasLogined(request.getSession())) {
           return "redirect:/user/loginForm";		// login form 요청으로 redirect
       }

      return "/main/MenuPage.jsp";            // 사용자 보기 화면으로 이동
    }      
}