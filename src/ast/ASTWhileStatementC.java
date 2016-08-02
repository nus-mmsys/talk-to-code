package ast;

public class ASTWhileStatementC extends ASTWhileStatement {
	public ASTWhileStatementC(){
		this.condition = new ASTExpressionUnitLiteral("1");
	}
	public ASTWhileStatementC(ASTExpression exp) {
		super(exp);
	}
	public void addStatement(ASTStatement s){
		this.statements.add(s);
		s.addParent(this);
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
