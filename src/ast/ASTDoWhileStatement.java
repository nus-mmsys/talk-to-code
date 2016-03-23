package ast;
import java.util.*;
public class ASTDoWhileStatement extends ASTBlockStatement {
	private static final String NODE_TYPE = "Do while Statement";
	protected ASTExpression exp;
	protected ArrayList<ASTStatement> statements;
	public ASTDoWhileStatement() {
		this.exp = null;
		this.statements = new ArrayList<ASTStatement>();
	}
	public ASTDoWhileStatement(ASTExpression exp){
		this();
		this.exp = exp;
		exp.addParent(this);
	}
	public void addStatement(ASTStatement s){
		this.statements.add(s);
		s.addParent(this);
	}
	public String typeof(){
		return super.typeof()+NODE_TYPE;
	}
	public String toSyntax(){
		this.result = "do {\n";
		for(ASTStatement s:this.statements){
			this.result+="\t";
			this.result+=s.toSyntax();
			this.result+="\n";
		}
		this.result+="} while (";
		this.result += this.exp.toSyntax();
		this.result+= ");\n";
		return this.result;
	}
}
