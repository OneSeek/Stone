//代码清单7.6 NestedEnv.java
package chap7;
import chap6.Environment;
import chap7.FuncEvaluator.EnvEx;
import java.util.HashMap;

public class NestedEnv implements Environment {

	protected HashMap<String, Object> values;
	protected Environment outer;

	public NestedEnv() {
		this(null);
	}

	public NestedEnv(Environment e) {
		values = new HashMap<String, Object>();
		outer = e;
	}

	public void setOuter(Environment e) {
		outer = e;
	}

	public void put(String name, Object value) {
		Environment e = where(name);
		if (e == null)
			e = this;
		((EnvEx)e).putNew(name,value);
	}

	public void putNew(String name, Object value) {
		values.put(name, value);
	}

	public Environment where(String name) {
		if (values.get(name) != null)
			return this;
		else if (outer == null)
			return null;
		return ((EnvEx) outer).where(name);
	}

	public Object get(String name) {
		Object v = values.get(name);
		if (v == null && outer != null)
			return outer.get(name);
		return v;
	}
}