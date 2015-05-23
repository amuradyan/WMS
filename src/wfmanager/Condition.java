package wfmanager;

public class Condition {
	Clause clause;
	String name;
	
	public Condition(Clause clause, String name) {
		this.clause = clause;
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
}	
