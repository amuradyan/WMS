package wfmanager.logic;

import wfmanager.contextmanager.Context;

public class Condition extends Evaluateable {
  UnitClause clause;
  
  public Condition(UnitClause clause) {
    this.clause = clause;
  }

  @Override
  public boolean evaluate(Context ctx) {
    return clause.evaluate(ctx);
  }
}
