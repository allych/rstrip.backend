package rstrip.actions.poi;

import rstrip.actions.ActionResult;
import rstrip.objects.POI;

public class EditPOIResult extends ActionResult {

	public POI poi;
	
	public EditPOIResult() {
		this.poi = new POI();
	}
	
}
