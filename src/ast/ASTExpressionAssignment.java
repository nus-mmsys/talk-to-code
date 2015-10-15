package ast;

public class ASTExpressionAssignment extends ASTExpression{
	private static final String NODE_TYPE = "Assignment";
	private ASTExpressionUnit object;
	private ASTExpression exp;
	
	public ASTExpressionAssignment(){
		super();
	}
	public ASTExpressionAssignment(ASTExpressionUnit variable,ASTExpression exp){
		this.object = variable;
		this.exp = exp;
		this.isEnd = true;
	}
	public String print(){
		this.result = this.object.print() + " = "+this.exp.print();
		return super.print();
	}
	public String typeof(){
		return super.typeof()+this.NODE_TYPE;
	}
}
