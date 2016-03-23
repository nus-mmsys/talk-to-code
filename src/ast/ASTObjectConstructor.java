package ast;
import java.util.*;
public class ASTObjectConstructor extends ASTBlockStatement {
	private static final String NODE_TYPE = "Object Statement";
	
	protected ArrayList<ASTExpressionUnitIdentifier> parameters;
	protected ArrayList<ASTStatement> statements;
	public ASTObjectConstructor() {
		this.parameters = new ArrayList<ASTExpressionUnitIdentifier>();
		this.statements = new ArrayList<ASTStatement>();
	}
	protected void addParameter(ASTExpressionUnitIdentifier p){
		this.parameters.add(p);
		p.addParent(this);
	}
	public void addStatement(ASTStatement s){
		this.statements.add(s);
		s.addParent(this);
	}
	public String typeof(){
		return super.typeof()+NODE_TYPE;
	}
	public String toSyntax(){
		return this.result;
	}
}
