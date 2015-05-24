package wfmanager;

import java.util.HashMap;
import java.util.Map;

public class Context {
	private Map<String, Object> ctxData;

	public Context(){
		ctxData = new HashMap<String, Object>();
	}

	// If the flag is new, adds it, if it exsted - updates it
	public void setFlag(String flgName, Object flag) {
		ctxData.put(flgName, flag);
	}

	public Object getFlag(String flgName) {
		return ctxData.get(flgName);
	}
}
