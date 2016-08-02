package ast.java;

import java.util.*;

public final class ASTJavaObjectVariableArray extends ASTJavaObject {
	private static final String TYPE_JAVA_OBJECT_ARR_NODE = "Java Object Array Node";
	private String name;
	private ArrayList<ASTJavaExpression> indexes = new ArrayList<ASTJavaExpression>();
	
	public ASTJavaObjectVariableArray(String name){
		super();
		this.name = name;
	}
	public void insertIndex(ASTJavaExpression index){
		this.indexes.add(index);
	}
	public int getDimension(){
		return this.indexes.size();
	}
	public String toSyntax(){
		return super.toSyntax()+" -> "+TYPE_JAVA_OBJECT_ARR_NODE;
	}
}
