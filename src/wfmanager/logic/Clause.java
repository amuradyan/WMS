package wfmanager.logic;

public abstract class Clause extends Evaluateable {
	protected Evaluateable right;
	protected Evaluateable left;
	
	public Clause(Evaluateable right, Evaluateable left) {
		this.right = right;
		this.left = left;
	}
}
