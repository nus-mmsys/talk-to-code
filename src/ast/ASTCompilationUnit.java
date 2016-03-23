package ast;
import java.util.ArrayList;
public class ASTCompilationUnit extends ASTNode {
	protected ArrayList<ASTStatement> statements;
	protected String name;
	public ASTCompilationUnit(String name) {
		this.statements = new ArrayList<ASTStatement>();
		this.name = name;
	}
	public void addStatement(ASTStatement s){
		this.statements.add(s);
		s.addParent(this);
	}
	public String toSyntax(){
		this.result = "";
		for(ASTStatement s:this.statements){
			this.result += s.toSyntax() +"\n";
		}
		return this.result;
	}
	
}
