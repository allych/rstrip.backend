package rstrip.actions.route;

import rstrip.actions.ActionResult;
import rstrip.objects.Route;

public class AddRouteResult extends ActionResult {

	public Route route;
	
	public AddRouteResult() {
		this.route = new Route();
	}
	
}
