package wfmanager;


public class AndCaluse extends Clause {
	
	public AndCaluse(Evaluateable right, Evaluateable left) {
		super(right, left);
	}

	@Override
	public boolean evaluate(){
		return right.evaluate() && left.evaluate();
	}
}
