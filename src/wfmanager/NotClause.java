package wfmanager;

public class NotClause extends UnitClause {
	
	@Override
	public boolean evaluate() {
		return !unit.evaluate();
	}
}
