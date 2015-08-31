package tests;

import wfmanager.contextmanager.Context;
import wfmanager.logic.Predicate;

public class Is7Predicate extends Predicate<Integer> {
  
  public Is7Predicate(String binding) {
    super(binding);
    this.binding = binding;
  }
  
  @Override
  public boolean evaluate(Context ctx) {
    initPropSubj(ctx);
    return propSubject == 7;
  }
}
