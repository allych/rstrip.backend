package rstrip.actions.step;

import rstrip.actions.ActionResult;
import rstrip.objects.Step;

public class EditStepResult extends ActionResult {

	public Step step;
	
	public EditStepResult() {
		this.step = new Step();
	}
	
}
