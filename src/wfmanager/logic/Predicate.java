package wfmanager.logic;

import wfmanager.contextmanager.Context;

public abstract class Predicate<T> extends Evaluateable {
  protected T propSubject;
  protected String binding;
  
  public Predicate(String binding) {
    this.binding = binding;
  }
  
  public String getBinding() {
    return binding;
  }
  
  @SuppressWarnings("unchecked")
  public void initPropSubj(Context ctx) {
    if (ctx.getFlag(binding) != null)
      this.propSubject = (T) ctx.getFlag(binding);
  }
}
