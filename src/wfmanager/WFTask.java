package wfmanager;

public abstract class WFTask {
	private WorkflowContext lCtx;
	private WorkflowContext gCtx;
	private TaskState state;
	
	public void passLocalContext(WorkflowContext workflowLocalCtx){
		this.lCtx = workflowLocalCtx;
	}

	public void passGlobalContext(WorkflowContext workflowGlobalCtx){
		gCtx = workflowGlobalCtx;
	}
	
	private void setStarted(){
		System.out.println("Task " + this.getClass() + " started");
		state = TaskState.STARTED;
	}

	private void setFinished(){
		System.out.println("Task " + this.getClass().getCanonicalName() + " finished");
		state = TaskState.FINISHED;
	}
	
	public void run(){
		setStarted();
		execute();
		setFinished();
	}
	
	public abstract void execute();
}
