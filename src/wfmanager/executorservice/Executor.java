package wfmanager.executorservice;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import wfmanager.WFTask;
import wfmanager.Workflow;
import wfmanager.contextmanager.Context;
import wfmanager.contextmanager.ContextManager;
import wfmanager.contextmanager.LocalContext;
import wfmanager.logic.Condition;

public class Executor {
  private Workflow wf;
  
  public Executor(Workflow wf) {
    this.wf = wf;
  }
  
  public void start() {
    Map<Class<? extends WFTask>, Condition> tasks = wf.getTasks();
    LocalContext lCtx = ContextManager.getCManager().getContextForWF(wf.getName());
    Context gCtx = ContextManager.getCManager().getGlobalContext();
    
    if (tasks != null && !tasks.isEmpty()) {
      for (Map.Entry<Class<? extends WFTask>, Condition> entry : tasks
          .entrySet()) {
        try {
          if (entry.getValue() != null) {
            if (entry.getValue().evaluate(lCtx)) {
              executeTask(entry, lCtx, gCtx);
            }
          } else {
            executeTask(entry, lCtx, gCtx);
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }
  
  private void executeTask(Map.Entry<Class<? extends WFTask>, Condition> entry,
      LocalContext lCtx, Context gCtx)
      throws NoSuchMethodException, InstantiationException,
      IllegalAccessException, InvocationTargetException {
    WFTask task;
    Class<? extends WFTask> currClass = entry.getKey();
    Constructor<? extends WFTask> ctor = currClass.getConstructor();
    task = ctor.newInstance();
    task.setGlobalContext(gCtx);
    task.setLocalContext(lCtx);
    new Thread(task).start();
  }
}
