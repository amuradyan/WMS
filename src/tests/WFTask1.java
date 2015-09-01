package tests;

import wfmanager.WFTask;

public class WFTask1 extends WFTask {
  
  @Override
  public void execute() {
    t1();
  }
  
  private void t1() {
    for (int i = 10; i > 0; i--)
      System.out.println("Task1 counting backwards - " + i);
  }
}
