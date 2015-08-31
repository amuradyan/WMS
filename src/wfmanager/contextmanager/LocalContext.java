package wfmanager.contextmanager;

import java.util.HashMap;
import java.util.Map;

import wfmanager.TaskState;

public class LocalContext extends Context {
  protected Map<String, TaskState> taskStates;
  
  public LocalContext() {
    super();
    taskStates = new HashMap<String, TaskState>();
  }
  
  // If the flag is new, adds it, if it exsted - updates it
  public void setTSFlag(String taskName, TaskState state) {
    taskStates.put(taskName, state);
  }
  
  public TaskState getTSFlag(String taskName) {
    return taskStates.get(taskName);
  }
}
