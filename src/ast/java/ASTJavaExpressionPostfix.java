package ast.java;

public final class ASTJavaExpressionPostfix extends ASTJavaExpression{
	private static final String TYPE_JAVA_EXP_POSTFIX_NODE = "Java Postfix Expression Node";
	private String operator;
	private ASTJavaObject body; //allow ~(a+b),~a,!(a||b),!a etc;
	
	public ASTJavaExpressionPostfix(String operator,ASTJavaObject body){
		super();
		this.operator = operator;
		this.body = body;
	}
	public String toSyntax(){
		return super.toSyntax()+" -> "+TYPE_JAVA_EXP_POSTFIX_NODE;
	}
}
