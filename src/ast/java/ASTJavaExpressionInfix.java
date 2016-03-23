package ast.java;

public final class ASTJavaExpressionInfix extends ASTJavaExpression {
	private static final String TYPE_JAVA_EXP_INFIX_NODE = "Java Infix Expression Node";
	private String operator;
	private ASTJavaExpression body1; 
	private ASTJavaExpression body2;
	public ASTJavaExpressionInfix(String operator,ASTJavaExpression body1,ASTJavaExpression body2){
		super();
		this.operator = operator;
		this.body1 = body1;
		this.body2 = body2;
	}
	public String toSyntax(){
		return super.toSyntax()+" -> "+TYPE_JAVA_EXP_INFIX_NODE;
	}

}
