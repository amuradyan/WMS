package wfmanager;

import java.util.ArrayList;
import java.util.List;

public class Conditions implements Evaluateable {
	private List<Condition> preconditions;
	private List<Condition> postconditions;
	
	public Conditions(){
		preconditions = new ArrayList<Condition>();		
		postconditions = new ArrayList<Condition>();
	}
	
	public void addPrecondition(Condition preCon){
		preconditions.add(preCon);
	}

	public void addPostcondition(Condition postCon){
		postconditions.add(postCon);
	}

	@Override
	public boolean evaluate() {
		boolean retval = false;
		for(Condition cond : preconditions)
			retval &= cond.evaluate();
		
		return retval;
	}
	
	
}
