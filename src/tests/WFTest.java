package tests;

import wfmanager.AndCaluse;
import wfmanager.Conditions;
import wfmanager.NotClause;
import wfmanager.OrClause;
import wfmanager.Predicate;
import wfmanager.WFManager;
import wfmanager.Workflow;

public class WFTest {

	public static void main(String[] args){
		WFManager manager = WFManager.getInstance();
		String wfName = "TestWF";
		
		Workflow wf = manager.createNewWF(wfName);
		wf.addTask(WFTask1.class);
		
		Conditions WFTask2Conditions = new Conditions();
//		WFTask2Conditions.addCondition(new AndCaluse(new OrClause(), new AndCaluse(new NotClause())));
		
		wf.addTask(WFTask2.class, WFTask2Conditions);
		
		wf.start();
		
		System.out.println(manager.getWFByName(wfName).getName());
	}
}
