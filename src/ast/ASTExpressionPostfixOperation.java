package ast;

public class ASTExpressionPostfixOperation extends ASTExpression{
	private static final String NODE_TYPE = "Postfix Operation";
	private String operator;
	private ASTExpressionUnitIdentifier identifier1;
	public ASTExpressionPostfixOperation(ASTNode a) {
		super(a);
	}
	public ASTExpressionPostfixOperation(){
		super();
	}
	public ASTExpressionPostfixOperation(String operator,ASTExpressionUnitIdentifier id1){
		this.operator = operator;
		this.identifier1 = id1;
		this.isQuoted = false; 
	}
	public void end() {
		this.isEnd = true;
	}
	public String print() {
		this.result = identifier1.print() + operator;
		return super.print();
	}
	public String typeof() {
		return super.typeof()+"->"+NODE_TYPE;
	}

}
