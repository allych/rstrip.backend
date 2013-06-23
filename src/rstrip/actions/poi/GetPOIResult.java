package rstrip.actions.poi;

import java.util.ArrayList;
import java.util.Collection;

import rstrip.actions.ActionResult;
import rstrip.objects.POI;

public class GetPOIResult extends ActionResult {

	private Collection<POI> poi;
	
	public GetPOIResult(){
		this.poi = new ArrayList<POI>();
	}
	
	public void addPOI(POI poi){
		this.poi.add(poi);
	}
	
}
