package wfmanager;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class Workflow {
	private String name;
	private Map<Class<? extends WFTask>, Conditions> tasks;
	private Map<Class<? extends WFTask>, Conditions> initialTasks;
	private WorkflowContext lCtx;
	private WorkflowContext gCtx;
	
	public Workflow(String name){
		this.name = name;
		tasks = new HashMap<Class<? extends WFTask>, Conditions>();
		initialTasks = new HashMap<Class<? extends WFTask>, Conditions>();
		lCtx = new WorkflowContext();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void addTask(Class<? extends WFTask> task){
		addTask(task, null);
	}

	public void addTask(Class<? extends WFTask> task, Conditions cond){
		tasks.put(task, cond);
		initConditions();
	}

	public void addInitialTask(Class<? extends WFTask> task){
		addInitialTask(task, null);
	}

	public void addInitialTask(Class<? extends WFTask> task, Conditions conds){
		initialTasks.put(task, conds);
		initConditions();
	}
	
	public void setGlobalContext(WorkflowContext ctx) {
		gCtx = ctx;
	}

	private void initConditions(){
		// Set according triggers in DB
	}
	
	public void start() {
		WFTask task = null;
		if (initialTasks != null && !initialTasks.isEmpty()){
			for(Map.Entry<Class<? extends WFTask>, Conditions> entry : initialTasks.entrySet()) {
				try {
					Class<? extends WFTask> currClass = entry.getKey();
					Constructor<? extends WFTask> ctor = currClass
							.getConstructor();
					task = ctor.newInstance();
					task.passGlobalContext(gCtx);
					task.passLocalContext(lCtx);
					task.run();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}