package ast.java;

import java.util.ArrayList;

public class ASTJavaObjectVariableMethod extends ASTJavaObject {
	private static final String TYPE_JAVA_OBJECT_METHOD_NODE = "Java Object method Node";
	private String name;
	private ArrayList<ASTJavaObject> parents = new ArrayList<ASTJavaObject>();
	private ArrayList<ASTJavaExpression> parameters = new ArrayList<ASTJavaExpression>();
	
	public ASTJavaObjectVariableMethod(String name){
		super();
		this.name = name;
	}
	public void insertIndex(ASTJavaExpression parameter){
		this.parameters.add(parameter);
	}
	public void addCallingParent(ASTJavaObject parent){
		this.parents.add(parent);
	}
	public String toSyntax(){
		return super.toSyntax()+" -> "+TYPE_JAVA_OBJECT_METHOD_NODE;
	}

}
