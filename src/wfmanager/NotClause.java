package wfmanager;

public class NotClause extends UnitClause {
	
	public NotClause(Evaluateable unit) {
		super(unit);
	}

	@Override
	public boolean evaluate() {
		return !unit.evaluate();
	}
}
