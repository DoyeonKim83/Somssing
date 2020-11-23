package controller.report;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.BikeBrokenOrLostManager;
public class ReportBikeLostController implements Controller {

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      // TODO Auto-generated method stub
      
      BikeBrokenOrLostManager manager = BikeBrokenOrLostManager.getInstance();
      String bike_id = request.getParameter("bike_id");
      String rentalOffice_name = request.getParameter("rentalOffice_name");
      String rentalOffice_id = request.getParameter("rentalOffice_id");
      String why_BrokenOrLost = request.getParameter("why_BrokenOrLost");

       try {
         manager.insertBikeLost(bike_id, rentalOffice_name, rentalOffice_id, why_BrokenOrLost);
      } catch (Exception e) {            
         return "/Report/Lost.jsp";
      }   
     
       
       return "/Report/Result.jsp";   
    }      



}