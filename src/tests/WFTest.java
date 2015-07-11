package tests;

import java.lang.reflect.ParameterizedType;

import wfmanager.WFManager;
import wfmanager.Workflow;
import wfmanager.logic.Clause;
import wfmanager.logic.Condition;
import wfmanager.logic.OrClause;
import wfmanager.logic.Predicate;

public class WFTest {

	public static void main(String[] args){
		WFManager manager = WFManager.getInstance();
		String wfName = "TestWF";
		
		Workflow wf = manager.createNewWF(wfName);
		wf.addTask(WFTask1.class);
		Is7Predicate is7 = new Is7Predicate("asd");
		
//		Clause testClause = new OrClause(new Predicate<Integer>("userSkip"), new Predicate<Integer>("isEADBReceived"));
//		Condition cond = new Condition(testClause, "testCond");
//		System.out.println(((ParameterizedType)is7.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		
		wf.addTask(WFTask2.class);
		
		wf.start();
		
		System.out.println(manager.getWFByName(wfName).getName());
	}
}
