package wfmanager.logic;

import wfmanager.contextmanager.Context;

public class UnitClause extends Evaluateable {
  protected Evaluateable unit;
  
  public UnitClause(Evaluateable unit) {
    this.unit = unit;
  }
  
  @Override
  public boolean evaluate(Context ctx) {
    return unit.evaluate(ctx);
  }
}
