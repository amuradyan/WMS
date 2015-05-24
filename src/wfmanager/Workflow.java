package wfmanager;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class Workflow {
	private String name;
	private Context lCtx;
	private Context gCtx;
	private Map<Class<? extends WFTask>, Conditions> tasks;
	
	public Workflow(){
		lCtx = ContextManager.getCManager().getContextForWF(this.name);
		gCtx = ContextManager.getCManager().getGlobalContext();
	}
	
	public void setLocalContext(Context ctx){
		this.gCtx = ctx; 
	}
	
	public Workflow(String name){
		this.name = name;
		tasks = new HashMap<Class<? extends WFTask>, Conditions>();
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

	private void initConditions(){
		// Set according triggers in DB
	}
	
	public void start() {
		WFTask task = null;
		if (tasks != null && !tasks.isEmpty()){
			for(Map.Entry<Class<? extends WFTask>, Conditions> entry : tasks.entrySet()) {
				try {
					Class<? extends WFTask> currClass = entry.getKey();
					Constructor<? extends WFTask> ctor = currClass
							.getConstructor();
					task = ctor.newInstance();
					new Thread(task).start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}