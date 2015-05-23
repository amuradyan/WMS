package wfmanager;

public class Clause implements Evaluateable {
	protected Evaluateable right;
	protected Evaluateable left;
	
	@Override
	public boolean evaluate() {
		return false;
	}
}
