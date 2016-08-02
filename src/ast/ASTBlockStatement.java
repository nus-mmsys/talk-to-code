package ast;

public class ASTBlockStatement extends ASTStatement {
	private static final String NODE_TYPE = "Block Statement";
	public ASTBlockStatement() {
	}
	public String toSyntax(){
		this.result = "\n";
		return this.result;
	}
	public String typeof(){
		return super.typeof()+NODE_TYPE;
	}
}
