package rstrip.actions.poi;

import java.sql.SQLException;
import java.util.Map;

import rstrip.Server;
import rstrip.actions.Action;
import rstrip.utility.Control;

public class DeletePOIAction extends Action {

	protected DeletePOIResult result;
	
	private Integer id;

	public DeletePOIAction(Map parameters) {
		super(parameters);
		this.result = new DeletePOIResult();
	}
	
	protected void validateParameters(){
		this.id = Integer.parseInt(parameters.get("id").toString());
		
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
		
		Server.database.exec("DELETE FROM poi_localized WHERE `id_poi`='" + this.id + "'");
		Server.database.exec("DELETE FROM poi WHERE `id`='" + this.id + "'");
		
		this.result.poi.setId(this.id);

		Server.database.endTransaction();
	}
	
	public DeletePOIResult getResult() {
		return this.result;
	}
	
}
