package ast;
import java.util.ArrayList;
public class ASTClass extends ASTBlockStatement {
	
	protected ASTExpressionUnitIdentifier name;
	protected ArrayList<ASTStatement> statements;
	public ASTClass(String name) {
		ASTExpressionUnitIdentifier className = new ASTExpressionUnitIdentifier(name);
		this.name = className;
		className.addParent(this);
	}
	public void addStatement(ASTStatement s){
		this.statements.add(s);
		s.addParent(this);
	}
	public String toSyntax(){
		return this.result;
	}
}
