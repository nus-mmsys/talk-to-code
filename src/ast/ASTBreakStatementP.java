package ast;

public class ASTBreakStatementP extends ASTBreakStatement {

	public ASTBreakStatementP() {
	}
	public String toSyntax(){
		this.result = super.toSyntax()+"\n";
		return this.result;
	}
}
