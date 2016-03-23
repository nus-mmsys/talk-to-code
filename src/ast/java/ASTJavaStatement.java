package ast.java;



public class ASTJavaStatement extends ASTJavaNode {
	private static final String TYPE_JAVA_STATEMENT = "Java Statement";
	public ASTJavaStatement(){
		super();
	}
	public String toSyntax(){
		return super.toSyntax()+" -> "+TYPE_JAVA_STATEMENT;
	}

}
