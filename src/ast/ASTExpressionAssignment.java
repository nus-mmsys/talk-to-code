package ast;

public class ASTExpressionAssignment extends ASTExpression{
	private static final String NODE_TYPE = "Assignment";
	private ASTExpression object;
	private ASTExpression exp;
	private ASTExpressionUnitOperator op;
	
	public ASTExpressionAssignment(){
		super();
	}
	public ASTExpressionAssignment(ASTExpression variable,ASTExpression exp,String operator){
		this.object = variable;
		this.exp = exp;
		this.op = new ASTExpressionUnitOperator(operator);
	
	}
	public String toSyntax(){
		this.result = this.object.toSyntax() + " "+this.op.toSyntax()+" "+this.exp.toSyntax();
		return super.toSyntax();
	}
	public String typeof(){
		return super.typeof()+NODE_TYPE;
	}
	public ASTExpression getObject(){
		return this.object;
	}
	public ASTExpression getExp(){
		return this.exp;
	}
}
