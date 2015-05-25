package wfmanager;

import java.util.ArrayList;
import java.util.List;

public class Conditions implements Evaluateable {
	private List<Condition> conditions;
	
	public Conditions(){
		conditions = new ArrayList<Condition>();		
	}
	
	public void addCondition(Condition preCon){
		conditions.add(preCon);
	}

	@Override
	public boolean evaluate() {
		boolean retval = false;
		for(Condition cond : conditions)
			retval &= cond.evaluate();
		
		return retval;
	}
	
	
}
