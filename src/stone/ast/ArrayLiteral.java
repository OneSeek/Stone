// 代码清单10.3 ArrayLiteral.java
package stone.ast;
import java.util.List;

public class ArrayLiteral extends ASTList {

	public ArrayLiteral(List<ASTree> c) {
		super(c);
	}

	public int size() {
		return numChildren();
	}
}