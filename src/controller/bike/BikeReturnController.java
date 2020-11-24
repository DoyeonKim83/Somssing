package controller.bike;
//BikeReturnController
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.Rent;
import model.service.RentManager;


public class BikeReturnController implements Controller {
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		String deleteId = request.getParameter("userId");

		RentManager manager = RentManager.getInstance();		
		HttpSession session = request.getSession();	
	
		if ((BikeSessionUtils.isLoginUser("admin", session) && 	
			 !deleteId.equals("admin"))					
			   || 											
			(!BikeSessionUtils.isLoginUser("admin", session) &&  
					BikeSessionUtils.isLoginUser(deleteId, session))) { 
				
			manager.deleteRent(deleteId);	
			if (BikeSessionUtils.isLoginUser("admin", session))	
				return "/bike/returnList";		
			else
				return "/bike/return";	
		}
		
		Rent rent = manager.getRentByUserId(deleteId);
		request.setAttribute("user", rent);						
		request.setAttribute("deleteFailed", true);
		String msg = (BikeSessionUtils.isLoginUser("admin", session)) 
				   ? "시스템 관리자 정보는 삭제할 수 없습니다."		
				   : "타인의 정보는 삭제할 수 없습니다.";													
		request.setAttribute("exception", new IllegalStateException(msg));            
		return "/bike/returnList.jsp";
	}
}
