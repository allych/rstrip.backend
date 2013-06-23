package rstrip.actions.poi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import rstrip.Server;
import rstrip.actions.Action;
import rstrip.utility.Control;

public class AddPOIAction extends Action {

	protected AddPOIResult result;
	
	private String name, description;
	private Float latitude, longitude;

	public AddPOIAction(Map parameters) {
		super(parameters);
		this.result = new AddPOIResult();
	}
	
	protected void validateParameters(){
		this.name = parameters.get("name").toString();
		this.description = parameters.get("description").toString();
		this.latitude = Float.parseFloat(parameters.get("latitude").toString());
		this.longitude = Float.parseFloat(parameters.get("longitude").toString());
		
		if (this.name == null){
			error = "ERROR 302 :: PARAMETER IS NOT PASSED (name)";
			return;
		}
		else if (this.latitude == null){
			error = "ERROR 302 :: PARAMETER IS NOT PASSED (latitude)";
			return;
		}
		else if (this.longitude == null){
			error = "ERROR 302 :: PARAMETER IS NOT PASSED (longitude)";
			return;
		}
		
		if (this.name.equals("") || !Control.isString(this.name)){
			error = "ERROR 40 :: NOT VALID PARAMETER (name)";
			return;
		}
		else if (!Control.isUnsignedFloat(this.latitude)){
			error = "ERROR 40 :: NOT VALID PARAMETER (latitude)";
			return;
		}
		else if (!Control.isUnsignedFloat(this.longitude)){
			error = "ERROR 40 :: NOT VALID PARAMETER (longitude)";
			return;
		}
		else if (this.description != null && !Control.isText(this.description)){
			error = "ERROR 40 :: NOT VALID PARAMETER (description)";
			return;
		}
		
	}
	
	public void execute() throws SQLException {
		Server.database.startTransaction();
		
		ResultSet rows = Server.database.exec("INSERT INTO poi SET `id_user`=1, `latitude`='" + 
				this.latitude + "', `longitude`='" + this.longitude + "'", "id");
		
		if (rows.next()) {
			String query = "INSERT INTO poi_localized SET `name`='" + 
					this.name + "', `id_poi`='" + rows.getInt(1) + "', `id_language`=1";
			if (this.description != null){
				query += ", `description`='" + this.description + "'";
			}
			
			ResultSet row = Server.database.exec(query, "id");
			if (!row.next()){
				this.error = "ERROR 501 :: EXECUTION ERROR";
				Server.database.rollback();
				return;
			}
			
			this.result.poi.setId(rows.getInt(1));
		}
		else {
			this.error = "ERROR 501 :: EXECUTION ERROR";
			Server.database.rollback();
			return;
		}
		
		Server.database.endTransaction();
	}
	
	public AddPOIResult getResult() {
		return this.result;
	}
	
}
