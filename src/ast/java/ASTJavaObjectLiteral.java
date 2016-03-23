package ast.java;

public final class ASTJavaObjectLiteral extends ASTJavaObject{
	private static final String TYPE_JAVA_OBJECT_LITERAL_NODE = "Java Object Literal Node";
	private String literalValue;
	
	public ASTJavaObjectLiteral(String value){
		this.literalValue = value;
	}
	public String toSyntax(){
		return super.toSyntax()+" -> "+TYPE_JAVA_OBJECT_LITERAL_NODE;
	}
}
