package ast;

//Assumption
//quoted prefix operation like (i++) are not supported

public class ASTExpressionPrefixOperation extends ASTExpression{
	private static final String NODE_TYPE = "Prefix Operation";
	
	private ASTExpressionUnitOperator op;
	private ASTExpression identifier1;
	private int usability;
	public ASTExpressionPrefixOperation(){
		super();
	}

	public ASTExpressionPrefixOperation(String operator,ASTExpressionUnitIdentifier id1){
		this.op = new ASTExpressionUnitOperator(operator);
		this.identifier1 = id1;

		this.op.parent.addParent(this);
		this.identifier1.parent.addParent(this);
	}
	public ASTExpressionPrefixOperation(String operator,ASTExpressionUnitLiteral id1){
		this.op = new ASTExpressionUnitOperator(operator);
		this.identifier1 = id1;

		this.op.addParent(this);
		this.identifier1.addParent(this);
	}
	public ASTExpressionPrefixOperation(String operator,ASTExpression id1){
		this.op = new ASTExpressionUnitOperator(operator);
		this.identifier1 = id1;

		this.op.addParent(this);
		this.identifier1.addParent(this);
	}
	public boolean isValid(int currentProgrammingLanguage){
		return (this.usability&(1<<currentProgrammingLanguage))!=0;
	}

	public String toSyntax() {
		this.result = this.op.toSyntax() + identifier1.toSyntax();
		return this.result;
	}
	public String typeof() {
		return super.typeof()+"->"+NODE_TYPE;
	}
}
