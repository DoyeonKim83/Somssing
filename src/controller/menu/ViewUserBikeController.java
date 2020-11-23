package controller.menu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.service.BikeBrokenOrLostManager;
import model.service.ExistingMyBikeException;
import model.service.MyBikeManager;
import model.Bike;
import model.BikeTime;

public class ViewUserBikeController implements Controller {
   
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {         
  
      MyBikeManager manager = MyBikeManager.getInstance();
      String userId = request.getParameter("user_id");

       BikeTime bikeTime = null;
       try {
         bikeTime = manager.getBikeTimeByUserId(userId);   
      } catch (ExistingMyBikeException e) {            
           return "MainPage.jsp";
      }      
       
      return "MainPage.jsp";         
    }      

}