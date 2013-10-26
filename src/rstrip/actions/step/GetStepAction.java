package rstrip.actions.step;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import rstrip.Server;
import rstrip.actions.Action;
import rstrip.objects.Step;
import rstrip.utility.Control;

public class GetStepAction extends Action {

	protected GetStepResult result;
	
	private Float latitude, longitude;
	private Integer zoom, width, height, id;
	
	public GetStepAction(Map parameters) {
		super(parameters);
		this.result = new GetStepResult();
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
		String query = "SELECT `s`.`id`, `s`.`latitude`, `s`.`longitude`, `s`.`creation_date`, " +
				"`s`.`update_date`, `s`.`name`, `s`.`type` FROM `step` `s`" +
				"WHERE `s`.`id_user` = '1'";

		if (this.id != null) {
			query += " AND `s`.`id` = '" + this.id + "'";
		}
		
		ResultSet rows = Server.database.query(query);
		
		while (rows.next()) {
			Step step = new Step();

			step.setId(rows.getInt("id"));
			step.setLatitude(rows.getFloat("latitude"));
			step.setLongitude(rows.getFloat("longitude"));
			step.setCreationDate(rows.getString("creation_date"));
			step.setUpdateDate(rows.getString("update_date"));
			step.setName(rows.getString("name"));
			step.setType(rows.getString("type"));
			
			this.result.addStep(step);
		}
	}

	public GetStepResult getResult() {
		return this.result;
	}
	
}
