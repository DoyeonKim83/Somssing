package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.UserManager;

public class DeleteUserController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(DeleteUserController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    	//String deleteId = request.getParameter("userId");
    	String deleteId = UserSessionUtils.getLoginUserId(request.getSession());
    	log.debug("Delete User : {}", deleteId);

    	UserManager manager = UserManager.getInstance();		
		manager.remove(deleteId);				// 사용자 정보 삭제
		return "redirect:/user/logout";		// logout 처리
	}
}
