package tests;

import wfmanager.WFTask;

public class WFTask2 extends WFTask {

	@Override
	public void execute() {
		t2();
	}
	
	public void t2(){
		System.out.println("I am task number 2");
	}
}
