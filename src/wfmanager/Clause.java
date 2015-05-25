package wfmanager;

public class Clause implements Evaluateable {
	protected Evaluateable right;
	protected Evaluateable left;
	
	public Clause(Evaluateable right, Evaluateable left) {
		this.right = right;
		this.left = left;
	}
	
	@Override
	public boolean evaluate() {
		return false;
	}
}
