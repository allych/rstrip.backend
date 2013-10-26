package rstrip.actions.route;

import rstrip.actions.ActionResult;
import rstrip.objects.Route;

public class DeleteRouteResult extends ActionResult {

	public Route route;
	
	public DeleteRouteResult() {
		this.route = new Route();
	}
	
}
