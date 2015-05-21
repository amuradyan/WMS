package tests;

import wfmanager.Trigger;

public class StrTrigger extends Trigger{
	String str;
	
	public StrTrigger(String val) {
		str = val;
	}
	
	@Override
	public boolean predicate(Object obj){
		boolean retVal = false;
		if(obj instanceof String && obj == "asd"){
			return true;
		}
		else
			return false;
	}
}
