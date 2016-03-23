package ast.java;

public class ASTJavaExpression extends ASTJavaNode {
	private static final String TYPE_JAVA_EXP_NODE = "Java Expression Node";
	protected boolean isQuoted = false;
	public ASTJavaExpression(){
		super();
	}
	public void addParent(ASTJavaNode parent){
		this.parent = parent;
	}
	public void quote(){
		this.isQuoted = true;
	}
	public String toSyntax(){
		return super.toSyntax()+" -> "+TYPE_JAVA_EXP_NODE;
	}

}
