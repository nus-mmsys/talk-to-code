package ast.java;

import ast.ASTNode;

public class ASTJavaObject extends ASTJavaExpression{
	private static final String TYPE_JAVA_OBJECT_NODE = "Java Object Node";
	public ASTJavaObject(){
		super();
	}
	public void addParent(ASTJavaNode parent){
		this.parent = parent;
	}
	public String toSyntax(){
		return super.toSyntax()+" -> "+TYPE_JAVA_OBJECT_NODE;
	}

}
