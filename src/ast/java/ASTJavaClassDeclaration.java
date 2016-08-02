package ast.java;

public class ASTJavaClassDeclaration extends ASTJavaStatement {
	private static final String TYPE_JAVA_CLASS_DECLARATION = "Java Class Declaration";
	private static final int TYPE_DEFAULT = 0;
	private static final int TYPE_VISIBLE_PUBLIC = 1;
	private static final int TYPE_VISIBLE_PROTECTED = 2;
	private static final int TYPE_VISIBLE_PRIVATE = 3;
	private static final int TYPE_ABSTRACT = 1;
	private static final int TYPE_FINAL = 2;
	private int visibleType;
	private int abstractType;
	private String extendField;
	private String implementsField;
	private String name;
	
	public ASTJavaClassDeclaration(String name){
		super();
		this.visibleType = TYPE_DEFAULT;
		this.abstractType = TYPE_DEFAULT;
		this.extendField = "";
		this.implementsField = "";
		this.name = name;
	}
	
}
