package rstrip.actions.step;

import rstrip.actions.ActionResult;
import rstrip.objects.Step;

public class DeleteStepResult extends ActionResult {

	public Step step;
	
	public DeleteStepResult() {
		this.step = new Step();
	}
	
}
