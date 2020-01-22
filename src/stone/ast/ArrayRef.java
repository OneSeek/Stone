// 代码清单10.4 ArrayRef.java
package stone.ast;

import java.util.List;

public class ArrayRef extends Postfix {
    public ArrayRef(List<ASTree> c) {
        super(c);
    }

    public ASTree index() {
        return this.child(0);
    }

    public String toString() {
        return "[" + this.index() + "]";
    }
}

