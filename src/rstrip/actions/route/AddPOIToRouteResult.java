package rstrip.actions.route;

import rstrip.actions.ActionResult;
import rstrip.objects.Route;

public class AddPOIToRouteResult extends ActionResult {

	public Route route;
	
	public AddPOIToRouteResult() {
		this.route = new Route();
	}
	
}
