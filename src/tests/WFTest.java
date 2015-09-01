package tests;

import java.lang.reflect.ParameterizedType;

import wfmanager.WFManager;
import wfmanager.Workflow;
import wfmanager.contextmanager.Context;
import wfmanager.contextmanager.ContextManager;
import wfmanager.logic.BinaryClause;
import wfmanager.logic.Condition;
import wfmanager.logic.NotClause;
import wfmanager.logic.OrClause;
import wfmanager.logic.Predicate;
import wfmanager.logic.UnitClause;

public class WFTest {
  
  public static void main(String[] args) {
    WFManager manager = WFManager.getInstance();
    String wfName = "TestWF";
    
    Workflow wf = manager.createNewWF(wfName);
    Is7Predicate is7 = new Is7Predicate("asd");
    
    UnitClause testClause = new NotClause(is7);
    
    Condition c1 = new Condition(testClause);
    Condition c2 = new Condition(testClause);
    // System.out.println(((ParameterizedType)is7.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    Context ctx = ContextManager.getCManager().getContextForWF("TestWF");
    
    ctx.setFlag("asd", 9);
    
    wf.addTask(WFTask1.class, c1);
    wf.addTask(WFTask2.class, c2);
    
    wf.start();
    
    System.out.println(manager.getWFByName(wfName).getName());
  }
}
