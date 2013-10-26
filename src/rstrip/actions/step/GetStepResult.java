package rstrip.actions.step;

import java.util.ArrayList;
import java.util.Collection;

import rstrip.actions.ActionResult;
import rstrip.objects.Step;

public class GetStepResult extends ActionResult {

	private Collection<Step> step;
	
	public GetStepResult(){
		this.step = new ArrayList<Step>();
	}
	
	public void addStep(Step step){
		this.step.add(step);
	}
	
}
