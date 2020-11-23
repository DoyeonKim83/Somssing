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
      //System.out.println(rentalOffice_name);
      
      RentalOffice result2 = new RentalOffice();
      result2 = manager.getRentalOfficeByName(rentalOffice_name);
      
      if (result2 == null) {
         return "/RentalOffice/ByName.jsp";
      }   
       
       request.setAttribute("result2", result2);      // 사용자 정보 저장   
      return "/RentalOffice/ResultByName.jsp";            // 사용자 보기 화면으로 이동
    }      
         
}