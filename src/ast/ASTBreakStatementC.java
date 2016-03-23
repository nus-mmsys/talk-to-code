package ast;

public final class ASTBreakStatementC extends ASTBreakStatement {
	ASTExpressionUnitIdentifier label;
	public ASTBreakStatementC() {
		this.label = null;
	}
	public ASTBreakStatementC(ASTExpressionUnitIdentifier label) {
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
