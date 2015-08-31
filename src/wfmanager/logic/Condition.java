package wfmanager.logic;

import wfmanager.contextmanager.Context;

public class Condition extends Evaluateable {
  UnitClause clause;
  String name;
  
  public Condition(UnitClause clause, String name) {
    this.clause = clause;
    this.name = name;
  }
  
  public String getName() {
    return this.name;
  }
  
  @Override
  public boolean evaluate(Context ctx) {
    return clause.evaluate(ctx);
  }
}
