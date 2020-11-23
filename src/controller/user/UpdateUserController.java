package controller.user;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.UserManager;
import model.SomUser;

public class UpdateUserController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(UpdateUserController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
 
    	if (request.getMethod().equals("GET")) {	
    		// GET request: 회원정보 수정 form 요청	
    		//String updateId = request.getParameter("userId");
    		String updateId = UserSessionUtils.getLoginUserId(request.getSession());

    		log.debug("UpdateForm Request : {}", updateId);
    		
    		UserManager manager = UserManager.getInstance();
			SomUser user = manager.findUser(updateId);	// 수정하려는 사용자 정보 검색
			request.setAttribute("user", user);			

			return "/user/update.jsp";   // 검색한 사용자 정보를 update form으로 전송        
	    }	
    	
    	String textDate = request.getParameter("birth");
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	Date date = format.parse(textDate);
    	
    	// POST request (회원정보가 parameter로 전송됨)
    	SomUser updateUser = new SomUser(
    		UserSessionUtils.getLoginUserId(request.getSession()),
    		request.getParameter("password"),
    		request.getParameter("username"),
    		request.getParameter("email"),
    		request.getParameter("phone"),
    		request.getParameter("addr"),
    		date);

		UserManager manager = UserManager.getInstance();
		manager.update(updateUser);			
        return "redirect:/user/detail/view";		
    }
}