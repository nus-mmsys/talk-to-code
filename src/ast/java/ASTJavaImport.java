package ast.java;


public class ASTJavaImport extends ASTJavaStatement{
	private static final String TYPE_JAVA_IMPORT = "Java Import";
	private String packageName;
	public ASTJavaImport(String packageName){
		super();
		this.packageName = packageName;
	}
	public ASTJavaImport(String packageName,ASTJavaProgram parent){
		super();
		this.parent = parent;
		this.packageName = packageName;
	}
	public String toSyntax(){
		return super.toSyntax()+" -> "+TYPE_JAVA_IMPORT;
	}
}
