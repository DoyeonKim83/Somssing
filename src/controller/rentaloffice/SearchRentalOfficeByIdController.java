package controller.rentaloffice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.RentalOffice;
import model.service.RentalOfficeManager;

public class SearchRentalOfficeByIdController implements Controller {

public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {         
       
      RentalOfficeManager manager = RentalOfficeManager.getInstance();
      String rentalOffice_id = request.getParameter("rentalOffice_id");
      
      RentalOffice result = new RentalOffice();
      result = manager.getRentalOfficeById(rentalOffice_id);
      
      if (result == null) {
    	 System.out.print("존재하지 않는 대여소 아이디입니다");
         return "/RentalOffice/ById.jsp";
      }   
       
       request.setAttribute("result", result);      // 사용자 정보 저장   
      return "/RentalOffice/ResultById.jsp";            // 사용자 보기 화면으로 이동
    }      
       
         
}
