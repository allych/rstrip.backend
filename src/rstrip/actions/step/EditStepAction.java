package rstrip.actions.step;

import java.sql.SQLException;
import java.util.Map;

import rstrip.Server;
import rstrip.actions.Action;
import rstrip.utility.Control;

public class EditStepAction extends Action {

	protected EditStepResult result;
	
	private Integer id;
	private String name;
	
	public EditStepAction(Map parameters) {
		super(parameters);
		this.result = new EditStepResult();
	}
	
	protected void validateParameters(){
		this.id = (parameters.get("id") != null) ? Integer.parseInt(parameters.get("id").toString()) : null;
		this.name = (parameters.get("name") != null) ? parameters.get("name").toString() : null;
		
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
	}
	
	public void execute() throws SQLException {
		Server.database.startTransaction();
		
		String query = "UPDATE step SET `name`='" + this.name + "', update_date = NOW() WHERE `id`='" + this.id + "'";
		Server.database.exec(query);

		this.result.step.setId(this.id);
		
		Server.database.endTransaction();
	}
	
	public EditStepResult getResult() {
		return this.result;
	}
	
}
