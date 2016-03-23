package ast;

public class ASTContinueStatementP extends ASTContinueStatement {


	public ASTContinueStatementP() {
	}
	public String toSyntax(){
		this.result = super.toSyntax()+"\n";
		return this.result;
	}
}
