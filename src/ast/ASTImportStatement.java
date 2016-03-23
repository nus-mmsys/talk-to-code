package ast;

public class ASTImportStatement extends ASTSimpleStatement{
	private static final String NODE_TYPE = "Simple Statement";
	protected ASTExpression packageName;
	public ASTImportStatement(ASTExpression p){
		super();
		this.packageName = p;
		p.addParent(this);
	}
	public String typeof(){
		return super.typeof()+NODE_TYPE;
	}
	public String toSyntax(){
		return this.result;
	}
}
