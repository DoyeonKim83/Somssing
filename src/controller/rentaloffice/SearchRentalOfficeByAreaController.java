package controller.rentaloffice;

import java.util.ArrayList;
import java.util.List;
import model.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.RentalOfficeManager;

public class SearchRentalOfficeByAreaController implements Controller {
	
	 @Override
	    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {         
	       
	      RentalOfficeManager manager = RentalOfficeManager.getInstance();
	      String area = request.getParameter("area");
	      
	      System.out.println(area);

	      List<RentalOffice> list = new ArrayList<RentalOffice>();
	      list = manager.getRentalOfficeList(area);
	      
	      if (list == null) {
	         return "/RentalOffice/ByArea.jsp";
	      }   
	       
	       request.setAttribute("list", list);      // 사용자 정보 저장   
	      return "/RentalOffice/ResultByArea.jsp";            // 사용자 보기 화면으로 이동
	    }
   

}
