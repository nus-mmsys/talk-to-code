package ast;

public class ASTContinueStatementC extends ASTContinueStatement {
	ASTExpressionUnitIdentifier label;
	public ASTContinueStatementC() {
		this.label = null;
	}
	public ASTContinueStatementC(ASTExpressionUnitIdentifier label) {
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
