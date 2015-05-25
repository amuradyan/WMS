package wfmanager;

import java.util.HashMap;
import java.util.Map;

public class ContextManager {
	private Context gContext;
	private Map<String, LocalContext> lContexts;
	private static ContextManager instance;

	private ContextManager(){
		gContext = new Context();
		lContexts = new HashMap<String, LocalContext>();
	}
	
	public static ContextManager getCManager(){
		if(instance == null)
			instance = new ContextManager();
		
		return instance;
	}

	public Context getGlobalContext() {
		return gContext;
	}

	public Context getContextForWF(String wfName) {
		return lContexts.get(wfName);
	}
	
	public void addContextForWF(String wfName){
		lContexts.put(wfName, new LocalContext());
	}
	
	public void removeContextForWF(String wfName){
		lContexts.remove(wfName);
	}
	
	// TODO: This may cause memory leaks. Look into it later
	public void clearContextForWF(String wfName){
		addContextForWF(wfName);
	}
}
