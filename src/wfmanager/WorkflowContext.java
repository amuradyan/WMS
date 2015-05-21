package wfmanager;

import java.util.Map;

public class WorkflowContext {
	private Map<String, Object> ctx;
	private Map<String, TaskState> taskStates;

	public WorkflowContext(){
		
	}
	
	public void setFlag(String flgName, Object flag) {
		ctx.put(flgName, flag);
	}

	public Object getFlag(String flgName) {
		return ctx.get(flgName);
	}
}
