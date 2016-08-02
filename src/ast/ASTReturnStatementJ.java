package ast;


public class ASTReturnStatementJ extends ASTReturnStatement {
	private ASTExpression exp;
	public ASTReturnStatementJ(ASTExpression exp){
		this.exp = exp;
		exp.addParent(this);
	}
	
	
	public String toSyntax(){
		this.result = "return";
		this.result += " "+this.exp.toSyntax();
		this.result+=";\n";
		return this.result;
	}
}
