package ast;

public class ASTReturnStatement extends ASTSimpleStatement {
	private static final String NODE_TYPE = "Block Statement";
	public ASTReturnStatement() {
	}
	public String toSyntax(){
		return this.result;
	}
	public String typeof(){
		return super.typeof()+NODE_TYPE;
	}
}
