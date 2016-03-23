package ast;

public final class ASTExpressionStatementC extends ASTExpressionStatement {
	public ASTExpressionStatementC(ASTExpression p) {
		super(p);
		
	}
	
	public String toSyntax(){
		this.result = this.exp.toSyntax()+";\n";
		return this.result;
	}
}
