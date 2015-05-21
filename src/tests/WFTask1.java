package tests;

import wfmanager.WFTask;

public class WFTask1 extends WFTask {

	@Override
	public void execute() {
		t1();
	}
	
	private void t1(){
		System.out.println("I am task number 1");
	}

}
