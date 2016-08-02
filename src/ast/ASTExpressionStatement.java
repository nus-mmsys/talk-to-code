package ast;

public class ASTExpressionStatement extends ASTSimpleStatement {
	private static final String NODE_TYPE = "Expression Statement";
	protected ASTExpression exp;
	public ASTExpressionStatement(ASTExpression exp){
		this.exp = exp;
		exp.addParent(this);
	}
	public String toSyntax(){
		this.result = this.exp.toSyntax();
		return this.result;
	}
	public String typeof(){
		return super.typeof()+NODE_TYPE;
	}
}
