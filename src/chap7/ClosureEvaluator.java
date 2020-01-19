// 代码清单7.14 支持闭包的语法分析器ClosureEvaluator.java
package chap7;

import stone.ast.ASTree;
import stone.ast.Fun;
import chap6.Environment;
import javassist.gluonj.Require;
import javassist.gluonj.Reviser;

import java.util.List;

@Require(FuncEvaluator.class)
@Reviser
public class ClosureEvaluator {
	@Reviser
    public static class FunEx extends Fun {
		public FunEx(List<ASTree> c) {
			super(c);
		}
		
		public Object eval(Environment env) {
			return new Function(parameters(),body(),env);
		}
	}
}