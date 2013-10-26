package rstrip.actions.route;

import java.sql.SQLException;
import java.util.Map;

import rstrip.Server;
import rstrip.actions.Action;
import rstrip.utility.Control;

public class DeleteRouteAction extends Action {

	protected DeleteRouteResult result;
	
	private Integer id;

	public DeleteRouteAction(Map parameters) {
		super(parameters);
		this.result = new DeleteRouteResult();
	}
	
	protected void validateParameters(){
		this.id = (parameters.get("id") != null) ? Integer.parseInt(parameters.get("id").toString()) : null;
		
		if (this.id == null){
			error = "ERROR 302 :: PARAMETER IS NOT PASSED (id)";
			return;
		}
		
		if (!Control.isUnsignedInteger(this.id)){
			error = "ERROR 40 :: NOT VALID PARAMETER (id)";
			return;
		}
	}
	
	public void execute() throws SQLException {
		Server.database.startTransaction();
		
		Server.database.exec("DELETE FROM route WHERE `id`='" + this.id + "'");
		
		this.result.route.setId(this.id);

		Server.database.endTransaction();
	}
	
	public DeleteRouteResult getResult() {
		return this.result;
	}
	
}
