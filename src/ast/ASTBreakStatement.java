package ast;

public class ASTBreakStatement extends ASTSimpleStatement {
	private static final String NODE_TYPE = "Break Statement";
	public ASTBreakStatement() {	
	}
	public String toSyntax(){
		this.result = "break";
		return this.result;
	}
	public String typeof(){
		return super.typeof()+NODE_TYPE;
	}
}
