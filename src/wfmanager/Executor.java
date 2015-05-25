package wfmanager;

import java.lang.reflect.Constructor;
import java.util.Map;

public class Executor {
	private Workflow wf;

	public Executor(Workflow wf) {
		this.wf = wf;
	}
	
	public void start(){
		WFTask task = null;
		Map<Class<? extends WFTask>, Conditions> tasks = wf.getTasks();
		
		if (tasks != null && !tasks.isEmpty()){
			for(Map.Entry<Class<? extends WFTask>, Conditions> entry : tasks.entrySet()) {
				try {
					if (entry.getValue() != null && entry.getValue().evaluate()) {
						Class<? extends WFTask> currClass = entry.getKey();
						Constructor<? extends WFTask> ctor = currClass
								.getConstructor();
						task = ctor.newInstance();
						new Thread(task).start();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
