package wfmanager;


public class AndCaluse extends Clause {
	
	@Override
	public boolean evaluate(){
		return right.evaluate() && left.evaluate();
	}
}
