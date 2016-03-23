package ast.java;

public final class ASTJavaObjectVariable extends ASTJavaObject {
	private static final String TYPE_JAVA_OBJECT_VAR_NODE = "Java Object Variable Node";
	private static final String DEFAULT_NEW_VARIABLE_NAME = "newVariable";
	private static final String DEFAULT_NEW_VARIABLE_TYPE = "int";
	private static final String MSG_WRONG_VISIBILITY_TYPE = "Wrong visibility type, it can only be either default (0), public (1), protected (2) or private (3)";
	private static final String MSG_ERROR_INCORRECT_VISIBILITY = "The visibility of this variable is incorrect. ";
	private static final int VISIBILITY_DEFAULT = 0;
	private static final int VISIBILITY_PUBLIC = 1;
	private static final int VISIBILITY_PROTECTED = 2;
	private static final int VISIBILITY_PRIVATE = 3;
	private static int countOfNewVariable = 0;
	private String name;
	private String type;
	private boolean isConstant;
	private boolean isStatic;
	private boolean isAttribute;
	private int visibility;
	public ASTJavaObjectVariable(){
		super();
		
		if(countOfNewVariable == 0){
			this.name = DEFAULT_NEW_VARIABLE_NAME;		
		} else {
			this.name = DEFAULT_NEW_VARIABLE_NAME+countOfNewVariable;
			
		}
		countOfNewVariable++;
		this.type = DEFAULT_NEW_VARIABLE_TYPE;
		this.isConstant = false;
		this.isStatic = false;
		this.isAttribute = false;
		this.visibility = VISIBILITY_DEFAULT;
		
	}
	public ASTJavaObjectVariable(String name){
		this();
		this.name = name;
		countOfNewVariable--;
	}
	public ASTJavaObjectVariable(String name,String type){
		this(name);
		this.type = type;
	}
	public void rename(String name){
		this.name = name;
	}
	public void changeType(String type){
		this.type = type;
	}
	public void declareFinal(){
		this.isConstant = true;
	}
	public void declareStatic(){
		this.isStatic = true;
	}
	public void declareAttribute(){
		this.isAttribute = true;
	}
	public void setVisibility(int visibility)throws IllegalArgumentException{
		if(visibility<VISIBILITY_DEFAULT||visibility>VISIBILITY_PRIVATE){
			throw new IllegalArgumentException(MSG_WRONG_VISIBILITY_TYPE);
		} else {
			this.visibility = visibility;
		}
	}
	public String getName(){
		return this.name;
	}
	public String getType(){
		return this.type;
	}
	public String getVisibility() throws IndexOutOfBoundsException {
		switch(this.visibility){
			case VISIBILITY_DEFAULT:{
				return "";
			}
			case VISIBILITY_PUBLIC:{
				return "public";
			}
			case VISIBILITY_PROTECTED:{
				return "protected";
			}
			case VISIBILITY_PRIVATE:{
				return "private";
			}
			default: {
				throw new IndexOutOfBoundsException(MSG_ERROR_INCORRECT_VISIBILITY+this.visibility);
			}
		}
	}
	public boolean isAConstant(){
		return this.isConstant;
	}
	public boolean isAnAttribute(){
		return this.isAttribute;
	}
	public boolean isAStatic(){
		return this.isStatic;
	}
	public void setConstant(boolean input){
		this.isConstant = input;
	}
	public void setAttribute(boolean input){
		this.isAttribute = input;
	}
	public void setStatic(boolean input){
		this.isStatic = input;
	}
	public String toSyntax(){
		return super.toSyntax()+" -> "+TYPE_JAVA_OBJECT_VAR_NODE;
	}

}
