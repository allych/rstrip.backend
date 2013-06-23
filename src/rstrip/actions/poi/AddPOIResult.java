package rstrip.actions.poi;

import rstrip.actions.ActionResult;
import rstrip.objects.POI;

public class AddPOIResult extends ActionResult {

	public POI poi;
	
	public AddPOIResult() {
		this.poi = new POI();
	}
	
}
