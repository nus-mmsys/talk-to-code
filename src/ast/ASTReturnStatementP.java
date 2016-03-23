package ast;
import java.util.*;
public class ASTReturnStatementP extends ASTReturnStatement {
	ArrayList<ASTExpression> exps;
	public ASTReturnStatementP() {
		this.exps = new ArrayList<ASTExpression>();
	}
	public void addExp(ASTExpression exp){
		this.exps.add(exp);
		exp.addParent(this);
	}
	public String toSyntax(){
		this.result = "return ";
		for(int i = 0;i<this.exps.size();i++){
			this.result+=this.exps.get(i).toSyntax();
			if(i!=this.exps.size()-1){
				this.result+=", ";
			}
		}
		return this.result;
	}

}
