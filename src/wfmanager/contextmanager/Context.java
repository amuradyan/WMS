package wfmanager.contextmanager;

import java.util.HashMap;
import java.util.Map;

public class Context {
	protected Map<String, Object> ctxData;

	public Context(){
		ctxData = new HashMap<String, Object>();
	}

	// If the flag is new, adds it, if it existed - updates it
	public void setFlag(String flgName, Object flag) {
		ctxData.put(flgName, flag);
	}

	public Object getFlag(String flgName) {
		return ctxData.get(flgName);
	}
	
	@Override
	public boolean equals(Object obj) {
		Context that = null;
		if(obj != null && obj instanceof Context)
			that = (Context) obj;
		
		return this.ctxData == that.ctxData;
	}
}
