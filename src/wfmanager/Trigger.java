package wfmanager;

public abstract class Trigger {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean predicate(Object obj){
		return true;
	}
}
