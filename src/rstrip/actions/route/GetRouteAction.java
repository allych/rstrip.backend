package rstrip.actions.route;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import rstrip.Server;
import rstrip.actions.Action;
import rstrip.objects.Route;
import rstrip.utility.Control;

public class GetRouteAction extends Action {

	protected GetRouteResult result;
	
	private Float latitude, longitude;
	private Integer zoom, width, height, id;
	
	public GetRouteAction(Map parameters) {
		super(parameters);
		this.result = new GetRouteResult();
	}
	
	protected void validateParameters(){
		this.latitude = (parameters.get("latitude") != null) ? Float.parseFloat(parameters.get("latitude").toString()) : null;
		this.longitude = (parameters.get("longitude") != null) ? Float.parseFloat(parameters.get("longitude").toString()) : null;
		this.zoom = (parameters.get("zoom") != null) ? Integer.parseInt(parameters.get("zoom").toString()) : null;
		this.width = (parameters.get("width") != null) ? Integer.parseInt(parameters.get("width").toString()) : null;
		this.height = (parameters.get("height") != null) ? Integer.parseInt(parameters.get("height").toString()) : null;
		this.id = (parameters.get("id") != null) ? Integer.parseInt(parameters.get("id").toString()) : null;
		
		if (this.latitude == null){
			error = "ERROR 302 :: PARAMETER IS NOT PASSED (latitude)";
			return;
		}
		else if (this.longitude == null){
			error = "ERROR 302 :: PARAMETER IS NOT PASSED (longitude)";
			return;
		}
		else if (this.zoom == null){
			error = "ERROR 302 :: PARAMETER IS NOT PASSED (zoom)";
			return;
		}
		else if (this.width == null){
			error = "ERROR 302 :: PARAMETER IS NOT PASSED (width)";
			return;
		}
		else if (this.height == null){
			error = "ERROR 302 :: PARAMETER IS NOT PASSED (height)";
			return;
		}
		
		if (!Control.isUnsignedFloat(this.latitude)){
			error = "ERROR 40 :: NOT VALID PARAMETER (latitude)";
			return;
		}
		else if (!Control.isUnsignedFloat(this.longitude)){
			error = "ERROR 40 :: NOT VALID PARAMETER (longitude)";
			return;
		}
		else if (!Control.isUnsignedInteger(this.zoom)){
			error = "ERROR 40 :: NOT VALID PARAMETER (zoom)";
			return;
		}
		else if (!Control.isUnsignedInteger(this.width)){
			error = "ERROR 40 :: NOT VALID PARAMETER (width)";
			return;
		}
		else if (!Control.isUnsignedInteger(this.height)){
			error = "ERROR 40 :: NOT VALID PARAMETER (height)";
			return;
		}
		else if (this.id != null && !Control.isUnsignedInteger(this.id)){
			error = "ERROR 40 :: NOT VALID PARAMETER (id)";
			return;
		}
	}
	
	public void execute() throws SQLException {
		String query = "SELECT `r`.`id`, `r`.`name`, `r`.`date_start`, `r`.`date_end` FROM `route` `r`" +
				" WHERE `r`.`id_user` = '1'";

		if (this.id != null) {
			query += " AND `r`.`id` = '" + this.id + "'";
		}
		
		ResultSet rows = Server.database.query(query);
		
		while (rows.next()) {
			Route route = new Route();

			route.setId(rows.getInt("id"));
			route.setName(rows.getString("name"));
			route.setDateStart(rows.getString("date_start"));
			route.setDateEnd(rows.getString("date_end"));
			
			this.result.addRoute(route);
		}
	}

	public GetRouteResult getResult() {
		return this.result;
	}
	
}
