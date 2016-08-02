package ast.java;
import ast.ASTNode;;
public class ASTJavaNode extends ASTNode {
	private static final String TYPE_JAVA_NODE = "Java Node";
	public ASTJavaNode(){
		this.language = ASTNode.LAN_JAVA;
	}
	public void addParent(ASTJavaNode parent){
		this.parent = parent;
	}
	public String toSyntax(){
		return TYPE_JAVA_NODE;
	}
}
