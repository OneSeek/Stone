package stone;

public abstract class Token {                         // abstract class
	public static final Token EOF = new Token(-1) {}; // end of file 表示程序结束
	public static final String EOL = "\\n";           // end of line 表示换行符
	private int lineNumber;                           // token number

	protected Token(int line) {
		lineNumber = line;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public boolean isIdentifier() {
		return false;
	}

	public boolean isNumber() {
		return false;
	}

	public boolean isString() {
		return false;
	}

	public int getNumber() {
		throw new StoneException("not number token");
	}

	public String getText() {
		return "";
	}
}