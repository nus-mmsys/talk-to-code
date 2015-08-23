package ast;

public class ASTExpressionUnitIdentifier extends ASTExpressionUnit{
	private static final String NODE_TYPE = "Identifier";
	private static final String VALUE_UNDECLARED = "\0";
	private static final String VISIBLE_PUBLIC = "public";
	private static final String VISIBLE_PROTECTED = "protected";
	private static final String VISIBLE_PRIVATE = "private";
	protected String visibleType;
	protected boolean isStatic;
	protected boolean isDeclaration;
	protected boolean isAttribute;
	public ASTExpressionUnitIdentifier(){
		super();
	}
	public ASTExpressionUnitIdentifier(ASTNode a) {
		super(a);
	}
	public ASTExpressionUnitIdentifier(String name,String type){
		super(name,type,VALUE_UNDECLARED);
		this.visibleType = VISIBLE_PUBLIC;
		this.isStatic = false;
		this.isDeclaration = false;
		this.isAttribute = false;
	}
	public ASTExpressionUnitIdentifier(String name,String type,String value){
		this(name,type);
		this.value = value;
	}
	public ASTExpressionUnitIdentifier(String name,String type,boolean isDeclaration){
		this(name,type);
		this.isDeclaration = isDeclaration;
	}
	public ASTExpressionUnitIdentifier(String name,String type,String value,boolean isDeclaration){
		this(name,type,value);
		this.isDeclaration = isDeclaration;
	}
	public ASTExpressionUnitIdentifier(String name,String type,boolean isDeclaration,String visibleType){
		this(name,type,isDeclaration);
		this.visibleType = visibleType;
	}
	public ASTExpressionUnitIdentifier(String name,String type,String value,String visibleType,boolean isDeclaration){
		this(name,type,value,isDeclaration);
		this.visibleType =visibleType;
	}
	public ASTExpressionUnitIdentifier(String name,String type,String visibleType,boolean isStatic,boolean isDeclaration){
		this(name,type,VALUE_UNDECLARED,visibleType,isDeclaration);
		this.isStatic = isStatic;
		
	}
	public ASTExpressionUnitIdentifier(String name,String type,String value,String visibleType,boolean isStatic,boolean isDeclaration){
		this(name,type,value,visibleType,isDeclaration);
		this.isStatic = isStatic;
	}
	public ASTExpressionUnitIdentifier(String name,String type,String value,String visibleType,boolean isStatic,boolean isDeclaration,boolean isAttribute){
		this(name,type,value,visibleType,isStatic,isDeclaration);
		this.isAttribute = isAttribute;
	}
	public ASTExpressionUnitIdentifier(ASTExpressionUnit a){
		
		super(a);
		this.visibleType = VISIBLE_PUBLIC;
		this.isStatic = false;
		this.isDeclaration = false;
	}
	
	public ASTExpressionUnitIdentifier(ASTExpressionUnitIdentifier a){
		
		super(new ASTExpression(a.result,a.isEnd,a.isQuoted),a.name,a.type,a.value,a.unitClass);
		this.visibleType = a.visibleType;
		this.isStatic = a.isStatic;
		this.isDeclaration = a.isDeclaration;
		this.isAttribute = a.isAttribute;
	}
	
	public String typeof(){
		return super.typeof()+"->"+NODE_TYPE;
	}
	
	public String print(){
		String result = "";
		if(this.isDeclaration) {
			if(this.isAttribute) {
				result = componentAdd(result,this.getVisibility());		
				if(this.isStatic) {
					result = componentAdd(result,"static");
				}
			}
	
			result = componentAdd(result,this.getType());
		}
		result += super.getName();
		this.result = result;
		this.result = super.print();
		return this.result;
	}
	public String getVisibility() {
		return this.visibleType;
	}
	
	protected static String componentAdd(String text,String component){
		return text+component+" ";
	}

}
