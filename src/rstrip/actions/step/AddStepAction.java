package rstrip.actions.step;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import rstrip.Server;
import rstrip.actions.Action;
import rstrip.utility.Control;

public class AddStepAction extends Action {

	protected AddStepResult result;
	
	private String name, type;
	private Float latitude, longitude;

	public AddStepAction(Map parameters) {
		super(parameters);
		this.result = new AddStepResult();
	}
	
	protected void validateParameters(){
		this.name = (parameters.get("name") != null) ? parameters.get("name").toString() : null;
		this.type = (parameters.get("type") != null) ? parameters.get("type").toString() : null;
		this.latitude = (parameters.get("latitude") != null) ? Float.parseFloat(parameters.get("latitude").toString()) : null;
		this.longitude = (parameters.get("longitude") != null) ? Float.parseFloat(parameters.get("longitude").toString()) : null;
		
		if (this.name == null){
			error = "ERROR 302 :: PARAMETER IS NOT PASSED (name)";
			return;
		}
		else if (this.type == null){
			error = "ERROR 302 :: PARAMETER IS NOT PASSED (type)";
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
		else if (this.type.equals("") || !Control.isStepType(this.type)){
			error = "ERROR 40 :: NOT VALID PARAMETER (type)";
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
		
	}
	
	public void execute() throws SQLException {
		Server.database.startTransaction();
		
		ResultSet rows = Server.database.exec("INSERT INTO step SET `id_user`=1, `latitude`='" + 
				this.latitude + "', `longitude`='" + this.longitude + "', " +
				"`name`='" + this.name + "', `type`='" + this.type + "'", "id");
		
		if (rows.next()) {
			this.result.step.setId(rows.getInt(1));
		}
		else {
			this.error = "ERROR 501 :: EXECUTION ERROR";
			Server.database.rollback();
			return;
		}
		
		Server.database.endTransaction();
	}
	
	public AddStepResult getResult() {
		return this.result;
	}
	
}
