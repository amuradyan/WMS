package wfmanager;

import java.util.HashMap;
import java.util.Map;

import wfmanager.executorservice.Executor;
import wfmanager.executorservice.ExecutorService;
import wfmanager.logic.Condition;

public class Workflow {
	private String name;
	private Map<Class<? extends WFTask>, Condition> tasks;
	
	public Workflow(String name){
		this.name = name;
		tasks = new HashMap<Class<? extends WFTask>, Condition>();
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

	public void addTask(Class<? extends WFTask> task, Condition cond){
		tasks.put(task, cond);
	}
	
	public Map<Class<? extends WFTask>, Condition> getTasks(){
		return tasks;
	}

	public void start() {
		getExecutor().start();
	}
	
	public Executor getExecutor() {
		return ExecutorService.getInstance().getExecutorForWF(this.name);
	}
}