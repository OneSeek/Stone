//代码清单 7.5 Arguments.java
package stone.ast;
import java.util.List;

public class Arguments extends Postfix {
	public Arguments(List<ASTree> c) {
		super(c);
	}

	public int size() {
		return numChildren();
	}
}