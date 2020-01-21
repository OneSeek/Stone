// 代码清单8.1 NativeEvaluator.java
package chap8;

import stone.StoneException;
import stone.ast.ASTree;
import chap6.BasicEvaluator.ASTreeEx;
import chap6.Environment;
import chap7.FuncEvaluator;
import javassist.gluonj.Require;
import javassist.gluonj.Reviser;

import java.util.List;

@Require(FuncEvaluator.class)
@Reviser
public class NativeEvaluator {
	@Reviser
	public static class NativeArgEx extends FuncEvaluator.ArgumentsEx {
		public NativeArgEx(List<ASTree> c) {
			super(c);
		}

		public Object eval(Environment callerEnv, Object value) {
			if (!(value instanceof NativeFunction))
				return super.eval(callerEnv, value);
			NativeFunction func = (NativeFunction) value;
			int nparams = func.numOfParameters();
			if (size() != nparams)
				throw new StoneException("bad number of arguments", this);
			Object[] args = new Object[nparams];
			int num = 0;
			for (ASTree a : this) {
				ASTreeEx ae = (ASTreeEx) a;
				args[num++] = ae.eval(callerEnv);
			}
			return func.invoke(args, this);
		}
	}
}