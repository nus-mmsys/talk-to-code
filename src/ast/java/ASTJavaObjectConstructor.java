package ast.java;

import java.util.ArrayList;

public final class ASTJavaObjectConstructor extends ASTJavaObject {
	private static final String TYPE_JAVA_OBJECT_CONSTRUCTOR_NODE = "Java Object Constructor Node";
	private ASTJavaObjectLiteral name;
	private ArrayList<ASTJavaObject> parentPackages = new ArrayList<ASTJavaObject>();
	private ArrayList<ASTJavaExpression> parameters = new ArrayList<ASTJavaExpression>();
	
	public ASTJavaObjectConstructor(String name){
		super();
		this.name = new ASTJavaObjectLiteral(name);
	}
	public void insertIndex(ASTJavaExpression parameter){
		this.parameters.add(parameter);
	}
	public void addCallingParent(ASTJavaObject parent){
		this.parentPackages.add(parent);
	}
	public String toSyntax(){
		return super.toSyntax()+" -> "+TYPE_JAVA_OBJECT_CONSTRUCTOR_NODE;
	}
}
