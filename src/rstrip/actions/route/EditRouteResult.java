package rstrip.actions.route;

import rstrip.actions.ActionResult;
import rstrip.objects.Route;

public class EditRouteResult extends ActionResult {

	public Route route;
	
	public EditRouteResult() {
		this.route = new Route();
	}
	
}
