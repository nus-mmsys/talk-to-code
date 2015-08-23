package ast;
import java.util.*;
public class ASTIfStatement extends ASTNode {
	private static final String NODE_TYPE = "If Statement";
	private ASTExpression condition;
	private ArrayList<ASTNode> ifBranch;
	private ArrayList<ASTNode> elseBranch;
	private String result;
	
	private void initialize() {
		this.ifBranch =  new ArrayList<ASTNode>();
		this.elseBranch = new ArrayList<ASTNode>();
	}
	
	public ASTIfStatement() {
		super();
		initialize();
	}
	public ASTIfStatement(ASTExpression e){
		this.condition = e;
		initialize();
	}
	public void setIf(ASTNode e){
		this.ifBranch.add(e);
	}
	public String typeof() {
		return super.typeof()+"->"+NODE_TYPE;
	}
	public String print() {
		String result = "";
		result += ("if("+this.condition.print()+") {\n");
		for(int i = 0;i<this.ifBranch.size();i++){
			result+= ("\t"+this.ifBranch.get(i).print()+"\n");
		}
		result += "}\nelse {\n";
		for(int j = 0; j<this.elseBranch.size();j++){
			result+=("\t"+this.elseBranch.get(j).print()+"\n");
		}
		result +="}\n";
		this.result = result;
		return this.result;
	}
}
