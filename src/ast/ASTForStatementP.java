package ast;

import java.util.ArrayList;

public class ASTForStatementP extends ASTForStatement {
	
	private ArrayList<ASTStatement> statements;
	private ArrayList<ASTStatement> elseBranch;
	private ASTExpressionUnitIdentifier variable;
	private ASTExpressionUnit range;
	public ASTForStatementP() {
		this.statements = new ArrayList<ASTStatement>();
		this.elseBranch = new ArrayList<ASTStatement>();
	}
	public void addVariable(ASTExpressionUnitIdentifier variable){
		this.variable =variable;
		variable.addParent(this);
	}
	public void addRange(ASTExpressionUnit range){
		this.range = range;
		range.addParent(this);
	}
	public void addStatement(ASTStatement s){
		this.statements.add(s);
		s.addParent(this);
	}
	public void addElseBranch(ASTStatement s){
		this.elseBranch.add(s);
		s.addParent(this);
	}
	public String toSyntax(){
		this.result = "for ";
		this.result+=this.variable.toSyntax();
		this.result += " in ";
		this.result += this.range.toSyntax() +": \n";
		for(int i = 0;i<this.statements.size();i++){
			this.result += "\t";
			this.result += this.statements.get(i).toSyntax();
			this.result += "\n";
		}
		if(!this.elseBranch.isEmpty()){
			this.result+="else:\n";
			for(int i = 0;i<this.elseBranch.size();i++){
				this.result += "\t";
				this.result += this.elseBranch.get(i).toSyntax();
				this.result += "\n";
			}
		}
		return this.result;
	}
}
