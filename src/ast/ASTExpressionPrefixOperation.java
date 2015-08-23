package ast;
//Assumption
//quoted prefix operation like (i++) are not supported

public class ASTExpressionPrefixOperation extends ASTExpression{
	private static final String NODE_TYPE = "Prefix Operation";
	private String operator;
	private ASTExpressionUnitIdentifier identifier1;
	public ASTExpressionPrefixOperation(ASTNode a) {
		super(a);
	}
	public ASTExpressionPrefixOperation(){
		super();
	}
	public ASTExpressionPrefixOperation(String operator,ASTExpressionUnitIdentifier id1){
		this.operator = operator;
		this.identifier1 = id1;
		this.isQuoted = false; 
	}
	public void end() {
		this.isEnd = true;
	}
	public String print() {
		this.result = operator + identifier1.print();
		return super.print();
	}
	public String typeof() {
		return super.typeof()+"->"+NODE_TYPE;
	}
}
