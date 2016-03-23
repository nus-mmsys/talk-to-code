package ast;

public final class ASTExpressionStatementJ extends ASTExpressionStatement {

	public ASTExpressionStatementJ(ASTExpression exp) {
		super(exp);
	}
	public String toSyntax(){
		this.result = super.toSyntax()+";\n";
		return this.result;
	}
}
