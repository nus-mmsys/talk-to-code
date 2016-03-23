package ast.java;



public final class ASTJavaExpressionAssignment extends ASTJavaExpression{
	private static final String TYPE_JAVA_EXP_ASSIGN_NODE = "Java Assignment Expression Node";
	private ASTJavaObject body;
	private ASTJavaExpression exp;
	public ASTJavaExpressionAssignment(ASTJavaObject body, ASTJavaExpression exp){
		this.body = body;
		this.exp = exp;
		
	}
	public ASTJavaExpressionAssignment(String name, ASTJavaExpression exp){
		this.body = new ASTJavaObjectVariable(name);
		this.exp = exp;
	}
	public ASTJavaObject getBody(){
		return this.body;
	}
	
	public String toSyntax(){
		return super.toSyntax()+" -> "+TYPE_JAVA_EXP_ASSIGN_NODE;
		
	}

}
