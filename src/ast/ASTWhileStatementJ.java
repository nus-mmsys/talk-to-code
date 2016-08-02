package ast;

public class ASTWhileStatementJ extends ASTWhileStatement {

	public ASTWhileStatementJ(ASTExpression exp) {
		super(exp);
	}
	public String toSyntax(){
		this.result = "while (";
		this.result +=this.condition.toSyntax();
		this.result+= "){\n";
		for(int i =0;i<this.statements.size();i++){
			this.result+="\t";
			this.result+=this.statements.get(i).toSyntax();
			this.result+="\n";
		}
		this.result+="}\n";
		return this.result;
	}
}
