package wfmanager;

import java.util.HashMap;
import java.util.Map;

import wfmanager.contextmanager.ContextManager;
import wfmanager.executorservice.ExecutorService;

public class WFManager {
  private Map<String, Workflow> currentWFs;
  private static WFManager instance;
  private ContextManager ctxManager;
  private ExecutorService execService;
  
  private WFManager() {
    currentWFs = new HashMap<String, Workflow>();
    ctxManager = ContextManager.getCManager();
    execService = ExecutorService.getInstance();
  }
  
  public static WFManager getInstance() {
    if (instance == null)
      instance = new WFManager();
    
    return instance;
  }
  
  private void addWorkflow(Workflow workflow) {
    this.currentWFs.put(workflow.getName(), workflow);
  }
  
  public Workflow getWFByName(String wfName) {
    return currentWFs.get(wfName);
  }
  
  public Map<String, Workflow> getAllWFs() {
    return currentWFs;
  }
  
  // TODO: This still does not remove the flags set by the
  // removed task from the global context. Look into it
  public void removeWF(String wfName) {
    currentWFs.remove(wfName);
    ctxManager.removeContextForWF(wfName);
  }
  
  // TODO: I don't like the way it's done now
  public Workflow createNewWF(String wfName) {
    Workflow wf = new Workflow(wfName);
    ctxManager.addContextForWF(wfName);
    execService.registerExecutor(wf);
    addWorkflow(wf);
    System.out.println("Workflow " + wfName + " created and stored.");
    
    return wf;
  }
}
