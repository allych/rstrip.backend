package rstrip.actions;

import java.sql.SQLException;
import java.util.Map;

abstract public class Action {

	protected String error;
	protected Map parameters;
	protected ActionResult result;

	public Action(Map parameters) {
		this.parameters = parameters;

		validateParameters();
	}
	
	abstract protected void validateParameters();
	
	abstract public void execute() throws SQLException;

	public Boolean haveError(){
		if (error != null) {
			return true;
		}
		return false;
	}

	public ActionError getError() {
		return new ActionError(this.error);
	}

	public ActionResult getResult() {
		return this.result;
	}
	
}
