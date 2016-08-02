package ast;

public class ASTSimpleStatement extends ASTStatement{
	private static final String NODE_TYPE = "Simple Statement";
	public ASTSimpleStatement(){
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
