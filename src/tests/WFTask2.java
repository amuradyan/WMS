package tests;

import wfmanager.WFTask;

public class WFTask2 extends WFTask {
  
  @Override
  public void execute() {
    t2();
  }
  
  public void t2() {
    for (int i = 0; i < 10; i++)
      System.out.println("Task2 counting upwards - " + i);
  }
}
