package ast.java;

public class ASTJavaSimpleStatement extends ASTJavaStatement {
	private static final String TYPE_JAVA_SIMPLE_STATEMENT = "Java Simple Statement";
	public ASTJavaSimpleStatement(){
		super();
	}
	public String toSyntax(){
		return super.toSyntax()+" -> "+TYPE_JAVA_SIMPLE_STATEMENT;
	}
}
