package wfmanager.logic;

public abstract class UnitClause extends Evaluateable {
	protected Evaluateable unit;
	
	public UnitClause(Evaluateable unit) {
		this.unit = unit;
	}
}
