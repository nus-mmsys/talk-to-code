package ast;

public final class ASTExpressionStatementP extends ASTExpressionStatement {

	public ASTExpressionStatementP(ASTExpression exp) {
		super(exp);
	}
	public String toSyntax(){
		this.result = super.toSyntax()+"\n";
		return this.result;
	}
}
