package rstrip.actions.route;

import java.sql.SQLException;
import java.util.Map;

import rstrip.Server;
import rstrip.actions.Action;
import rstrip.utility.Control;

public class EditRouteAction extends Action {

	protected EditRouteResult result;
	
	private Integer id;
	private String name, date_start;
	
	public EditRouteAction(Map parameters) {
		super(parameters);
		this.result = new EditRouteResult();
	}
	
	protected void validateParameters(){
		this.id = (parameters.get("id") != null) ? Integer.parseInt(parameters.get("id").toString()) : null;
		this.name = (parameters.get("name") != null) ? parameters.get("name").toString() : null;
		this.date_start = (parameters.get("date_start") != null) ? parameters.get("date_start").toString() : null;
		
		if (this.id == null){
			error = "ERROR 302 :: PARAMETER IS NOT PASSED (id)";
			return;
		}
		else if (this.name == null){
			error = "ERROR 302 :: PARAMETER IS NOT PASSED (name)";
			return;
		}
		
		if (!Control.isUnsignedInteger(this.id)){
			error = "ERROR 40 :: NOT VALID PARAMETER (id)";
			return;
		}
		else if (!Control.isString(this.name) || this.name.equals("")) {
			error = "ERROR 40 :: NOT VALID PARAMETER (name)";
			return;
		}
		else if (this.date_start != null && (!Control.isDateTime(this.date_start) || this.date_start.equals(""))) {
			error = "ERROR 40 :: NOT VALID PARAMETER (date_start)";
			return;
		}
	}
	
	public void execute() throws SQLException {
		Server.database.startTransaction();
		
		String query = "UPDATE route SET `name`='" + this.name + "'";
		
		if (this.date_start != null) {
			query += ", `date_start` = '" + this.date_start + "' WHERE `id`='" + this.id + "'";
		}
		Server.database.exec(query);

		this.result.route.setId(this.id);
		
		Server.database.endTransaction();
	}
	
	public EditRouteResult getResult() {
		return this.result;
	}
	
}
