//代码清单7.2 支持函数功能的语法分析器 FuncParser.java
package stone;
import static stone.Parser.rule;
import stone.ast.ParameterList;
import stone.ast.Arguments;
import stone.ast.DefStmnt;
// FuncParser类继承于第五章代码清单5.2中的BasicParser类。
public class FuncParser extends BasicParser {
    Parser param = rule().identifier(reserved);
    Parser params = rule(ParameterList.class)
                        .ast(param).repeat(rule().sep(",").ast(param));
    /*
     * paramList字段与postfix字段的初始化表达式使用了maybe方法。
     * 与option方法一样，maybe方法也用于向模式中添加可省略的非终结符。
     * parserList字段对应的非终结符param_List实际语法规则如下所示。
     * param_list : "(" [ params ] ")"
     * 括号内的params可省略
     * */
    Parser paramList = rule().sep("(").maybe(params).sep(")");
    Parser def = rule(DefStmnt.class)
                     .sep("def").identifier(reserved).ast(paramList).ast(block);
    Parser args = rule(Arguments.class)
                      .ast(expr).repeat(rule().sep(",").ast(expr));
    Parser postfix = rule().sep("(").maybe(args).sep(")");

    public FuncParser() {
        reserved.add(")");
        primary.repeat(postfix);
        simple.option(args);
        program.insertChoice(def);
    }
}