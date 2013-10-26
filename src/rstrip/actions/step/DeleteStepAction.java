package rstrip.actions.step;

import java.sql.SQLException;
import java.util.Map;

import rstrip.Server;
import rstrip.actions.Action;
import rstrip.utility.Control;

public class DeleteStepAction extends Action {

	protected DeleteStepResult result;
	
	private Integer id;

	public DeleteStepAction(Map parameters) {
		super(parameters);
		this.result = new DeleteStepResult();
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
		
		Server.database.exec("DELETE FROM step WHERE `id`='" + this.id + "'");
		
		this.result.step.setId(this.id);

		Server.database.endTransaction();
	}
	
	public DeleteStepResult getResult() {
		return this.result;
	}
	
}
