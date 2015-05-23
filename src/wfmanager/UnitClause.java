package wfmanager;

public class UnitClause implements Evaluateable {
	protected Evaluateable unit;
	
	@Override
	public boolean evaluate() {
		return unit.evaluate();
	}
}
