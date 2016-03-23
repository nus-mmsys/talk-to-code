package ast;

public class ASTExpressionUnitLiteral extends ASTExpressionUnit{
	private static final String NODE_TYPE = "Value";
	private String value;
	public ASTExpressionUnitLiteral(){
		super();
	}

	public ASTExpressionUnitLiteral(String value){
		super();
		this.value = value;
	}
	public String typeof(){
		return super.typeof()+"->"+NODE_TYPE;
	}
	public String toSyntax(){
		return this.value;
	}
}
