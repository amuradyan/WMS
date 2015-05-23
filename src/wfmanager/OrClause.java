package wfmanager;

public class OrClause extends Clause {
	
	@Override
	public boolean evaluate(){
		return right.evaluate() || left.evaluate();
	}
}
