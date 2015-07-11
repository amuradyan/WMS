package wfmanager;

import wfmanager.contextmanager.Context;
import wfmanager.contextmanager.LocalContext;

public abstract class WFTask implements Runnable {
	private LocalContext lCtx;
	private Context gCtx;
	private TaskState state;
	
	public WFTask(){
		this.state = TaskState.WAITING;
	}
	
	public void passLocalContext(LocalContext workflowLocalCtx){
		this.lCtx = workflowLocalCtx;
	}

	public void passGlobalContext(Context workflowGlobalCtx){
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
	
	@Override
	public void run(){
		setStarted();
		execute();
		setFinished();
	}
	
	public abstract void execute();
}
