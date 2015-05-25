package tests;

import wfmanager.Clause;
import wfmanager.Condition;
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
		
		Clause testClause = new OrClause(new Predicate<Integer>(), new Predicate<Integer>());
		Condition cond = new Condition(testClause, "testCond");
		
		wf.addTask(WFTask2.class, cond);
		
		wf.start();
		
		System.out.println(manager.getWFByName(wfName).getName());
	}
}
