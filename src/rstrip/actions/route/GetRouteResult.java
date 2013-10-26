package rstrip.actions.route;

import java.util.ArrayList;
import java.util.Collection;

import rstrip.actions.ActionResult;
import rstrip.objects.Route;

public class GetRouteResult extends ActionResult {

	private Collection<Route> route;
	
	public GetRouteResult(){
		this.route = new ArrayList<Route>();
	}
	
	public void addRoute(Route route){
		this.route.add(route);
	}
	
}
