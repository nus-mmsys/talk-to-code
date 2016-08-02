package ast;
import java.util.*;
public class ASTIfStatement extends ASTBlockStatement {
	private static final String NODE_TYPE = "If Statement";
	protected ASTExpression condition;
	protected ArrayList<ASTStatement> ifBranch;
	protected ArrayList<ASTStatement> elseBranch;
	protected String result;
	private void initialize() {
		this.ifBranch =  new ArrayList<ASTStatement>();
		this.elseBranch = new ArrayList<ASTStatement>();
	}
	public ASTIfStatement() {
		super();
		initialize();
	}
	public ASTIfStatement(ASTExpression e){
		this.condition = e;
		initialize();
		e.addParent(this);
	}

	public void setIf(ASTStatement e){
		this.ifBranch.add(e);
		e.addParent(this);
	}
	public void setElse(ASTStatement e){
		this.elseBranch.add(e);
		e.addParent(this);
	}
	public String typeof() {
		return super.typeof()+"->"+NODE_TYPE;
	}
	public String toSyntax() {

		return this.result;
	}
}
