package wfmanager;

public class OrClause extends Clause {
	
	public OrClause(Evaluateable right, Evaluateable left) {
		super(right, left);
	}

	@Override
	public boolean evaluate(){
		return right.evaluate() || left.evaluate();
	}
}
