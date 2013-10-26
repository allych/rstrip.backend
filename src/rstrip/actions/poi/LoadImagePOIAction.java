package rstrip.actions.poi;

/* http://www.sources.ru/java/faq/loadfiles.htm */

import java.sql.SQLException;
import java.util.Map;

import rstrip.Server;
import rstrip.actions.Action;
import rstrip.utility.Control;

public class LoadImagePOIAction extends Action {

	protected LoadImagePOIResult result;
	
	private Integer id;

	public LoadImagePOIAction(Map parameters) {
		super(parameters);
		this.result = new LoadImagePOIResult();
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
	}
	
	public LoadImagePOIResult getResult() {
		return this.result;
	}
	
}
