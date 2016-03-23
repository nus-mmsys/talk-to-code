package ast;
import java.util.*;
public final class ASTPassStatement extends ASTBlockStatement {
	private ArrayList<ASTStatement> statements;
	public ASTPassStatement() {
		this.statements = new ArrayList<ASTStatement>();
	}
	public void addStatement(ASTStatement s){
		this.statements.add(s);
		s.addParent(this);
	}
	public String toSyntax(){
		this.result ="pass:\n";
		for(int i =0;i<this.statements.size();i++){
			this.result+="\t"+this.statements.get(i).toSyntax();
		}
		return this.result;
	}

}
