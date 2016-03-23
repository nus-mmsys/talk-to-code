package ast.java;

public final class ASTJavaExpressionPrefix extends ASTJavaExpression {
	private static final String TYPE_JAVA_EXP_PREFIX_NODE = "Java Prefix Expression Node";
	private String operator;
	private ASTJavaExpression body; //allow ~(a+b),~a,!(a||b),!a etc;
	
	public ASTJavaExpressionPrefix(String operator,ASTJavaExpression body){
		super();
		this.operator = operator;
		this.body = body;
	}
	public String toSyntax(){
		return super.toSyntax()+" -> "+TYPE_JAVA_EXP_PREFIX_NODE;
	}
}
