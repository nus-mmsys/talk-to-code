package ast;

public class ASTExpressionInfixOperation extends ASTExpression{
	private static final String NODE_TYPE = "Infix Operation";
	private String operator;
	private ASTExpression identifier1;
	private ASTExpression identifier2;
	public ASTExpressionInfixOperation(ASTNode a) {
		super(a);
	}
	public ASTExpressionInfixOperation(){
		super();
	}
	public ASTExpressionInfixOperation(String operator,ASTExpression id1,ASTExpression id2){
		this.operator = operator;
		this.identifier1 = id1;
		this.identifier2 = id2;
		//this.isQuoted = false; 
	}
	public void end() {
		this.isEnd = true;
	}
	public String print() {
		this.result = identifier1.print() + " "+operator +" "+ identifier2.print();
		return super.print();
	}
	public String typeof() {
		return super.typeof()+"->"+NODE_TYPE;
	}

}
