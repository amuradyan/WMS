package wfmanager.logic;

import wfmanager.contextmanager.Context;


public class AndCaluse extends BinaryClause {
	
	public AndCaluse(Evaluateable right, Evaluateable left) {
		super(right, left);
	}

	@Override
	public boolean evaluate(Context ctx){
		return right.evaluate(ctx) && left.evaluate(ctx);
	}
}
