package ast;

public class ASTLabelStatement extends ASTSimpleStatement{
	private static final String NODE_TYPE = "Label";
	private ASTExpressionUnitIdentifier id;
	public ASTLabelStatement(ASTExpressionUnitIdentifier id) {
		this.id = id;
		id.addParent(this);
	}
	public String toSyntax(){
		this.result = this.id.toSyntax()+":\n";
		return this.result;
	}
}
