package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.user.*;
import controller.matching.*;
import controller.route.*;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
        mappings.put("/", new ForwardController("index.jsp"));
        mappings.put("/main", new ForwardController("/MainPage.jsp"));
        
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
        
        
        mappings.put("/recommendation", new ForwardController("/recommendation/search.jsp"));
        mappings.put("/recommendation/result", new RouteResultController());
        
        logger.info("Initialized Request Mapping!");
        
        
    }

    public Controller findController(String uri) {	
        return mappings.get(uri);
    }
}
