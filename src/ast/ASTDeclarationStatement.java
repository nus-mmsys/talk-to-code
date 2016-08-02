package ast;

public class ASTDeclarationStatement extends ASTSimpleStatement {
	private static final String NODE_TYPE = "Declaration Statement";
	public ASTDeclarationStatement() {
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
