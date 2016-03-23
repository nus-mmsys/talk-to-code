package ast;

public class ASTExpressionPostfixOperation extends ASTExpression{
	private static final String NODE_TYPE = "Postfix Operation";
	private ASTExpressionUnitOperator op;
	private ASTExpressionUnitIdentifier identifier1;
	private int usability;
	public ASTExpressionPostfixOperation(){
		super();
	}

	public ASTExpressionPostfixOperation(String operator,ASTExpressionUnitIdentifier id1){
		this.op = new ASTExpressionUnitOperator(operator);
		this.identifier1 = id1;
		this.op.addParent(this);
		this.identifier1.addParent(this);
	}
	public boolean isValid(int currentProgrammingLanguage){
		return (currentProgrammingLanguage&(1<<this.usability))!=0;
	}
	public String toSyntax() {
		this.result = identifier1.toSyntax() + this.op.toSyntax();
		return this.result;
	}
	public String typeof() {
		return super.typeof()+"->"+NODE_TYPE;
	}

}
