package wfmanager.logic;

public abstract class BinaryClause extends Evaluateable {
	protected Evaluateable right;
	protected Evaluateable left;
	
	public BinaryClause(Evaluateable right, Evaluateable left) {
		this.right = right;
		this.left = left;
	}
}
