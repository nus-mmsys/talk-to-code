package ast;

import java.util.ArrayList;

public class ASTForStatementJ extends ASTForStatement {
	private ASTExpression initialCondition;
	private ASTExpression finalCondition;
	private ASTExpression incrementCondition;
	private ArrayList<ASTStatement> statements;
	public ASTForStatementJ() {
		this.initialCondition = null;
		this.finalCondition = null;
		this.incrementCondition = null;
		this.statements = new ArrayList<ASTStatement>();
	}
	public void addInitial(ASTExpression exp){
		this.initialCondition = exp;
		exp.addParent(this);
	}
	public void addFinal(ASTExpression exp){
		this.finalCondition = exp;
		exp.addParent(this);
	}
	public void addIncrement(ASTExpression exp){
		this.incrementCondition = exp;
		exp.addParent(this);
	}
	public void addStatement(ASTStatement s){
		this.statements.add(s);
		s.addParent(this);
	}
	public String toSyntax(){
		this.result = "for (";
		if(this.initialCondition!=null){
			this.result += this.initialCondition.toSyntax();
		}
		this.result+=";";
		if(this.finalCondition!=null){
			this.result += this.finalCondition.toSyntax();
		}
		this.result+=";";
		if(this.incrementCondition!=null){
			this.result += this.incrementCondition.toSyntax();
		}
		this.result+="){\n";
		for(int i = 0;i<this.statements.size();i++){
			this.result+="\t";
			this.result+=this.statements.get(i).toSyntax();
			this.result+="\n";
		}
		this.result+="}\n";
		return this.result;
	}
}
