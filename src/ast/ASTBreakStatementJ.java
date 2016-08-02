package ast;

public final class ASTBreakStatementJ extends ASTBreakStatement {
	ASTExpressionUnitIdentifier label;
	public ASTBreakStatementJ() {
		this.label = null;
	}
	public ASTBreakStatementJ(ASTExpressionUnitIdentifier label) {
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
