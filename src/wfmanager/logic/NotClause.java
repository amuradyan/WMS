package wfmanager.logic;

import wfmanager.contextmanager.Context;

public class NotClause extends UnitClause {
	
	public NotClause(Evaluateable unit) {
		super(unit);
	}

	@Override
	public boolean evaluate(Context ctx) {
		return !unit.evaluate(ctx);
	}
}
