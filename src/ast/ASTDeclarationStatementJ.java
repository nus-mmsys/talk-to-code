package ast;

import java.util.ArrayList;

public final class ASTDeclarationStatementJ extends ASTDeclarationStatement {
	private ArrayList<ASTExpression> variables;
	private ASTExpressionUnitTypes type;
	private ArrayList<String> modifiers;
	
	public ASTDeclarationStatementJ() {
	}
	public ASTDeclarationStatementJ(String type){
		this.type = new ASTExpressionUnitTypes(type);
		this.variables = new ArrayList<ASTExpression>();
		this.modifiers = new ArrayList<String>();
		this.type.addParent(this);
		
	}
	public void addModifier(String modifier){
		this.modifiers.add(modifier);
	}
	public void addVariable(ASTExpression exp){
		this.variables.add(exp);
		exp.addParent(this);
	}
	public String toSyntax(){
		this.result = "";
		for(String s:this.modifiers){
			this.result+=s;
			this.result+=" ";
		}
		this.result+=this.type.toSyntax();
		this.result+=" ";
		for(int i = 0;i<this.variables.size();i++){
			this.result+=this.variables.get(i).toSyntax();
			if(i!=this.variables.size()-1){
				this.result +=", ";
			}
		}
		this.result +=";\n";

		
		return this.result;
	}
}