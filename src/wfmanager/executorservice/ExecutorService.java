package wfmanager.executorservice;

import java.util.HashMap;
import java.util.Map;

import wfmanager.Workflow;

public class ExecutorService {
	private static ExecutorService instance;
	private Map<String, Executor> executors;
	
	private ExecutorService(){
		executors = new HashMap<String, Executor>();
	}
	
	public static ExecutorService getInstance(){
		if(instance == null)
			instance = new ExecutorService();
		
		return instance;
	}
	
	public Executor getExecutorForWF(String wfName){
		return executors.get(wfName);
	}
	
	public Executor registerExecutor(Workflow wf){
		Executor executor = new Executor(wf);
		executors.put(wf.getName(), executor);
		
		return executor;
	}
}
