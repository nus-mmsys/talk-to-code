package ast.java;

public final class ASTJavaStatementExpression extends ASTJavaSimpleStatement{
	private static final String TYPE_JAVA_STATEMENT_ASSIGNMENT = "Java Assignment Statement Node";
	private ASTJavaExpression body;
	public ASTJavaStatementExpression(ASTJavaExpression body){
		this.body = body;
	}
	public String toSyntax(){
		return super.toSyntax()+" -> "+TYPE_JAVA_STATEMENT_ASSIGNMENT;
		
	}
}
