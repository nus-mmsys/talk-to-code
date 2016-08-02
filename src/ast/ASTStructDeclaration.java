package ast;
import java.util.*;
public class ASTStructDeclaration extends ASTBlockStatement {
	private static final String NODE_TYPE = "Struct define Statement";
	private ASTExpressionUnitIdentifier name;
	private ArrayList<ASTDeclarationStatementC> attributes;
	
	public ASTStructDeclaration(String name) {
		ASTExpressionUnitIdentifier structName = new ASTExpressionUnitIdentifier(name);
		this.name = structName;
		structName.addParent(this);
		this.attributes = new ArrayList<ASTDeclarationStatementC>();
	}
	public void addAttribute(ASTDeclarationStatementC a){
		this.attributes.add(a);
		a.addParent(this);
	}
	public String toSyntax(){
		this.result = "typedef struct "+this.name.toSyntax()+" {\n";
		for(ASTDeclarationStatementC s:this.attributes){
			this.result +="\t"+s.toSyntax();
		}
		this.result+="} "+this.name.toSyntax()+";\n";
		return this.result;
	}
	public String typeof(){
		return super.typeof()+NODE_TYPE;
	}
}
