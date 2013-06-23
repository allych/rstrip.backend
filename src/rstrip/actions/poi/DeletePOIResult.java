package rstrip.actions.poi;

import rstrip.actions.ActionResult;
import rstrip.objects.POI;

public class DeletePOIResult extends ActionResult {

	public POI poi;
	
	public DeletePOIResult() {
		this.poi = new POI();
	}
	
}
