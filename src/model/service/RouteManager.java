package model.service;

import model.Route;
import model.dao.RouteDao;

public class RouteManager {
	private static RouteManager routeMan = new RouteManager();
	private RouteDao routeDAO;

	private RouteManager() {
		try {
			routeDAO = new RouteDao();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static RouteManager getInstance() {
		return routeMan;
	}
	
	public Route findRoute(String level) {
		return routeDAO.findRoute(level);
	}
}
