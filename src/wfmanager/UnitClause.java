package wfmanager;

public class UnitClause implements Evaluateable {
	protected Evaluateable unit;
	
	public UnitClause(Evaluateable unit) {
		this.unit = unit;
	}
	
	@Override
	public boolean evaluate() {
		return unit.evaluate();
	}
}
