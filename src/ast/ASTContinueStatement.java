package ast;

public class ASTContinueStatement extends ASTSimpleStatement {
	private static final String NODE_TYPE = "Break Statement";
	public ASTContinueStatement() {	
	}
	public String toSyntax(){
		this.result = "continue";
		return this.result;
	}
	public String typeof(){
		return super.typeof()+NODE_TYPE;
	}
}
