package ast;

public class ASTExpressionUnitConstant extends ASTExpressionUnit {
	private static final String NODE_TYPE = "Constant";
	private static final String VISIBLE_PUBLIC = "public";
	private static final String VISIBLE_PROTECTED = "protected";
	private static final String VISIBLE_PRIVATE = "private";
	private String visibleType;
	private boolean isStatic;
	private boolean isDeclaration;
	public ASTExpressionUnitConstant(){
		super();
	}
	public ASTExpressionUnitConstant(ASTNode a) {
		super(a);
	}
	public ASTExpressionUnitConstant(String name,String type,String value){
		super(name,type,value);
		this.visibleType = VISIBLE_PUBLIC;
		this.isStatic = false;
		this.isDeclaration = false;
	}
	
	public ASTExpressionUnitConstant(String name,String type,String value,boolean isDeclaration){
		this(name,type,value);
		this.isDeclaration = isDeclaration;
	}
	
	public ASTExpressionUnitConstant(String name,String type,String value,String visibleType,boolean isDeclaration){
		this(name,type,value,isDeclaration);
		this.visibleType = visibleType;
	}
	
	public ASTExpressionUnitConstant(String name,String type,String value,String visibleType,boolean isStatic,boolean isDeclaration){
		this(name,type,value,visibleType,isDeclaration);
		this.isStatic = isStatic;
	}
	

	





	public String typeof(){
		return super.typeof()+"->"+NODE_TYPE;
	}
	
	public String print(){
		String result = "";
		if(this.isDeclaration) {
			result += this.getVisibility();
			result += " ";
			if(this.isStatic) {
				result+= "static";
			}
			result += " ";
			result += super.getType();
			result += " ";
		}
		result += super.getName();
		this.result = result;
		this.result = super.print();
		return this.result;
	}
	public String getVisibility() {
		return this.visibleType;
	}

	

}
