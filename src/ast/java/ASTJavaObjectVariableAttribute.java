package ast.java;

import java.util.ArrayList;

public final class ASTJavaObjectVariableAttribute extends ASTJavaObject{
	private static final String TYPE_JAVA_OBJECT_ATT_NODE = "Java Object Attribute Node";
	private String name;
	private ArrayList<ASTJavaObject> parents = new ArrayList<ASTJavaObject>();
	public ASTJavaObjectVariableAttribute(String name){
		this.name = name;
	}
	public void addCallingParents(ASTJavaObject parent){
		this.parents.add(parent);
	}
	public String toSyntax(){
		return super.toSyntax()+" -> "+TYPE_JAVA_OBJECT_ATT_NODE;
	}
}
