package ast;

public class ASTForStatement extends ASTBlockStatement{
	private static final String NODE_TYPE = "Block Statement";
	public ASTForStatement() {
	}
	public String toSyntax(){
		this.result = "\n";
		return this.result;
	}
	public String typeof(){
		return super.typeof()+NODE_TYPE;
	}
}
