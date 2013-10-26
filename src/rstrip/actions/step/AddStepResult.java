package rstrip.actions.step;

import rstrip.actions.ActionResult;
import rstrip.objects.Step;

public class AddStepResult extends ActionResult {

	public Step step;
	
	public AddStepResult() {
		this.step = new Step();
	}
	
}
