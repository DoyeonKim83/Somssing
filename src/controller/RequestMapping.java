package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.user.*;
import controller.matching.*;
import controller.menu.MenuController;
import controller.menu.ViewUserBikeController;
import controller.rentaloffice.SearchRentalOfficeByAreaController;
import controller.rentaloffice.SearchRentalOfficeByIdController;
import controller.rentaloffice.SearchRentalOfficeByNameController;
import controller.report.ReportBikeBrokenController;
import controller.report.ReportBikeLostController;
import controller.route.*;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
        mappings.put("/", new ForwardController("index.jsp"));
        mappings.put("/main", new ForwardController("/main/MainPage.jsp"));
        mappings.put("/menu", new MenuController());
        mappings.put("/mybike", new ViewUserBikeController());
        
        
        //login, register
        mappings.put("/user/loginForm", new ForwardController("/user/loginForm.jsp"));
        mappings.put("/user/login", new LoginController());
        mappings.put("/user/registerForm", new ForwardController("/user/registerForm.jsp"));
        mappings.put("/user/register", new RegisterController());
    
        
        mappings.put("/user/view", new ViewUserController());
        mappings.put("/user/detail/view", new ViewDetailUserController());
        mappings.put("/user/update_action", new UpdateUserController());
        mappings.put("/user/delete", new DeleteUserController());
        mappings.put("/user/logout", new LogoutController());
        mappings.put("/user/grade", new ForwardController("/user/grade.jsp"));
        
        //search

        mappings.put("/search/rentalOffice", new ForwardController("/RentalOffice/Search.jsp"));
        mappings.put("/search/rentalOffice/ByArea", new SearchRentalOfficeByAreaController());
        mappings.put("/search/rentalOffice/ById", new SearchRentalOfficeByIdController());
        mappings.put("/search/rentalOffice/ByName", new SearchRentalOfficeByNameController());
        
        mappings.put("/report/choice", new ForwardController("/MenuPage.jsp"));
        mappings.put("/report/choice/broken", new ReportBikeBrokenController());
        mappings.put("/report/choice/lost", new  ReportBikeLostController());
        
     // ticket 
        mappings.put("/ticket/buyForm", new ForwardController("/ticket/ticketBuy.jsp"));
        //mappings.put("/ticket/buy", new TicketBuyController());
        
        //  matching
        mappings.put("/matching/list", new MatchingListController());
        mappings.put("/matching/ckeckPost", new MatchingPostCheckController());
        mappings.put("/matching/update", new MatchingUpdatePostController());
        mappings.put("/matching/updateForm", new ForwardController("/matching/matchingUpdatePost.jsp"));
        mappings.put("/matching/write", new MatchingWritingController());
        mappings.put("/matching/delete", new MatchingDeletePostController());

        mappings.put("/recommendation", new ForwardController("/recommendation/search.jsp"));
        mappings.put("/recommendation/result", new RouteResultController());
        
        logger.info("Initialized Request Mapping!");
        
        
    }

    public Controller findController(String uri) {   
        return mappings.get(uri);
    }
}