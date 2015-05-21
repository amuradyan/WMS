package wfmanager;

import java.util.HashMap;
import java.util.Map;

public class WFManager {
	private Map<String, Workflow> currentWFs;
	private static WFManager instance;
	private static WorkflowContext gCtx;
	
	private WFManager(){
		currentWFs = new HashMap<>();
		gCtx = new WorkflowContext();
	}
	
	public static WFManager getInstance(){
		if(instance == null)
			instance = new WFManager();
		
		return instance;
	}
	
	private void addWorkflow(Workflow workflow){
		this.currentWFs.put(workflow.getName(), workflow);
	}
	
	public Workflow getWFByName(String wfName){
		return currentWFs.get(wfName);
	}
	
	public Map<String, Workflow> getAllWFs(){
		return currentWFs;				
	}
	
	public Workflow createNewWF(String wfName){
		Workflow wf = new Workflow(wfName);
		wf.setGlobalContext(gCtx);
		addWorkflow(wf);
		System.out.println("Workflow " + wfName + " created and stored.");
		
		return wf;
	}
}
