package rstrip.actions.route;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import rstrip.Server;
import rstrip.actions.Action;
import rstrip.utility.Control;

public class AddPOIToRouteAction extends Action {

	protected AddRouteResult result;
	
	private String name;

	public AddPOIToRouteAction(Map parameters) {
		super(parameters);
		this.result = new AddRouteResult();
	}
	
	protected void validateParameters(){
		this.name = (parameters.get("name") != null) ? parameters.get("name").toString() : null;
		
		if (this.name == null){
			error = "ERROR 302 :: PARAMETER IS NOT PASSED (name)";
			return;
		}
		
		if (this.name.equals("") || !Control.isString(this.name)){
			error = "ERROR 40 :: NOT VALID PARAMETER (name)";
			return;
		}
		
	}
	
	public void execute() throws SQLException {
		Server.database.startTransaction();
		
		ResultSet rows = Server.database.exec("INSERT INTO route SET `id_user`=1, " +
				"`name`='" + this.name + "'", "id");
		
		if (rows.next()) {
			this.result.route.setId(rows.getInt(1));
		}
		else {
			this.error = "ERROR 501 :: EXECUTION ERROR";
			Server.database.rollback();
			return;
		}
		
		Server.database.endTransaction();
	}
	
	public AddRouteResult getResult() {
		return this.result;
	}
	
}
