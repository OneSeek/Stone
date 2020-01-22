// 代码清单10.2 ArrayParser.java
package stone;

import stone.ast.*;
import javassist.gluonj.Reviser;

import static stone.Parser.rule;

@Reviser
public class ArrayParser extends FuncParser {
	Parser elements = rule(ArrayLiteral.class).ast(expr).repeat(rule().sep(",").ast(expr));

	public ArrayParser() {
		reserved.add("]");
		primary.insertChoice(rule().sep("[").maybe(elements).sep("]"));
		postfix.insertChoice(rule(ArrayRef.class).sep("[").ast(expr).sep("]"));
	}
}