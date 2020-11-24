package controller.rentaloffice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.RentalOffice;
import model.service.RentalOfficeManager;

public class SearchRentalOfficeByNameController implements Controller {

   @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {         
       
      RentalOfficeManager manager = RentalOfficeManager.getInstance();
      String rentalOffice_name = request.getParameter("rentalOffice_name");
      
      RentalOffice result2 = new RentalOffice();
      result2 = manager.getRentalOfficeById(rentalOffice_name);
      
      if (result2 == null) {
      	 System.out.print("존재하지 않는 대여소 이름입니다");
         return "/RentalOffice/ByName.jsp";
      }   
      
       request.setAttribute("result2", result2);      // 사용자 정보 저장   
      return "/RentalOffice/ResultByName.jsp";            // 사용자 보기 화면으로 이동
    }      
         
}