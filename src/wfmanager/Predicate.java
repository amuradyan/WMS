package wfmanager;

public class Predicate<T> implements Evaluateable {
	protected T propSubject;
	protected String binding;
	
	public String getBinding(){
		return binding;
	}
	
	public void initPropSubject(T propSubjValue){
		this.propSubject = propSubjValue;
	}
	
	@Override
	public boolean evaluate() {
		// TODO Auto-generated method stub
		return false;
	}
}
