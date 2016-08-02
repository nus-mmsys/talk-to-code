package ast;

public class ASTContinueStatementJ extends ASTContinueStatement {
	ASTExpressionUnitIdentifier label;
	public ASTContinueStatementJ() {
		this.label = null;
	}
	public ASTContinueStatementJ(ASTExpressionUnitIdentifier label) {
		this.label = label;
		label.addParent(this);
	}
	public String toSyntax(){
		if(this.label == null)
			this.result = super.toSyntax()+";\n";
		else{
			this.result = super.toSyntax()+" "+this.label.toSyntax()+";\n";
		}
		return this.result;
	}
}
