package rstrip.actions.poi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import rstrip.Server;
import rstrip.actions.Action;
import rstrip.objects.POI;
import rstrip.utility.Control;

public class GetPOIAction extends Action {

	protected GetPOIResult result;
	
	private Float latitude, longitude;
	private Integer zoom, width, height, id;
	
	public GetPOIAction(Map parameters) {
		super(parameters);
		this.result = new GetPOIResult();
	}
	
	protected void validateParameters(){
		this.latitude = Float.parseFloat(parameters.get("latitude").toString());
		this.longitude = Float.parseFloat(parameters.get("longitude").toString());
		this.zoom = Integer.parseInt(parameters.get("zoom").toString());
		this.width = Integer.parseInt(parameters.get("width").toString());
		this.height = Integer.parseInt(parameters.get("height").toString());
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
		String query = "SELECT `p`.`id`, `p`.`latitude`, `p`.`longitude`, `p`.`creation_date`," +
				"`p`.`update_date`, `p`.`img`, `p`.`have_excursions`, `p`.`visit_time`, `pl`.`name`," +
				"`pl`.`description`, `pl`.`motivation`, `pl`.`schedule`, `pl`.`price`, `pl`.`features`," +
				"`pl`.`parking`, `pl`.`food`, `pl`.`website` FROM `poi` `p`" +
				"INNER JOIN `poi_localized` `pl` ON `p`.`id` = `pl`.`id_poi`" +
				"WHERE `p`.`id_user` = '1' AND `pl`.`id_language` = '1'";

		if (this.id != null) {
			query += " AND `p`.`id` = '" + this.id + "'";
		}
		
		ResultSet rows = Server.database.query(query);
		
		while (rows.next()) {
			POI poi = new POI();

			poi.setId(rows.getInt("id"));
			poi.setLatitude(rows.getFloat("latitude"));
			poi.setLongitude(rows.getFloat("longitude"));
			poi.setCreationDate(rows.getString("creation_date"));
			poi.setUpdateDate(rows.getString("update_date"));
			poi.setImg(rows.getString("img"));
			poi.setHaveExcursions(rows.getBoolean("have_excursions"));
			poi.setVisitTime(rows.getString("visit_time"));
			poi.setName(rows.getString("name"));
			poi.setDescription(rows.getString("description"));
			poi.setMotivation(rows.getString("motivation"));
			poi.setSchedule(rows.getString("schedule"));
			poi.setPrice(rows.getString("price"));
			poi.setFeatures(rows.getString("features"));
			poi.setParking(rows.getString("parking"));
			poi.setFood(rows.getString("food"));
			poi.setWebsite(rows.getString("website"));
			
			this.result.addPOI(poi);
		}
	}

	public GetPOIResult getResult() {
		return this.result;
	}
	
}
