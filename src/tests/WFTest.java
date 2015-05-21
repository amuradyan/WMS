package tests;

import wfmanager.Conditions;
import wfmanager.WFManager;
import wfmanager.Workflow;

public class WFTest {

	public static void main(String[] args){
		WFManager manager = WFManager.getInstance();
		String wfName = "TestWF";
		
		Workflow wf = manager.createNewWF(wfName);
		wf.addInitialTask(WFTask1.class);
		
		Conditions WFTask2Conditions = new Conditions();
//		WFTask2Conditions.addPrecondition(new TaskStateCondition(WFTask2.class, TaskState.FINISHED));
		wf.addInitialTask(WFTask2.class, WFTask2Conditions);
		
		wf.start();
		
		System.out.println(manager.getWFByName(wfName).getName());
	}
}
