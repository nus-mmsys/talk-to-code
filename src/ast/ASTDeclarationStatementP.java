package ast;
import java.util.ArrayList;

public final class ASTDeclarationStatementP extends ASTDeclarationStatement {
	private ArrayList<ASTExpressionAssignment> variables;
	public ASTDeclarationStatementP() {
	}
	public void AddAVariable(ASTExpressionAssignment exp){
		exp.addParent(this);
		this.variables.add(exp);
	}
	public String toSyntax(){
		this.result = "";
		for(int i = 0;i<this.variables.size();i++){
			this.result+= this.variables.get(i).getObject().toSyntax();
			if(i!=this.variables.size()-1){
				this.result+= ",";
			}
		}
		this.result += " = ";
		for(int i = 0;i<this.variables.size();i++){
			this.result+= this.variables.get(i).getExp().toSyntax();
			if(i!=this.variables.size()-1){
				this.result+= ",";
			}
		}
		return this.result+"\n";
	}
}
