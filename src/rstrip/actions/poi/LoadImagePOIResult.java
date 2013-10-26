package rstrip.actions.poi;

import rstrip.actions.ActionResult;
import rstrip.objects.POI;

public class LoadImagePOIResult extends ActionResult {

	public POI poi;
	
	public LoadImagePOIResult() {
		this.poi = new POI();
	}
	
}
