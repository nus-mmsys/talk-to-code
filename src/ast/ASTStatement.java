package ast;

public class ASTStatement extends ASTNode {
	private static final String NODE_TYPE = "Statement";
	public ASTStatement(){
		super();
	}
	public String toSyntax(){
		this.result = "\n";
		return this.result;
	}
	public String typeof(){
		return super.typeof()+NODE_TYPE;
	}
}
