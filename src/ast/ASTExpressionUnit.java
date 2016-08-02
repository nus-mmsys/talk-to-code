package ast;

public class ASTExpressionUnit extends ASTExpression {
	private static final String NODE_TYPE = "Unit";
	
	protected String name; // unit name
	protected String type; // unit type
	
	protected String value;// unit value
	protected boolean isError; //For debugging purposes
	public ASTExpressionUnit() {
		super();
	}

	public ASTExpressionUnit(String name,String type){
		super(new ASTExpression(false));
		this.name = name;
		this.type = type;
		
	}
	public ASTExpressionUnit(String name,String type,String value){
		this(name,type);
		this.value = value;
		
	}


	public ASTExpressionUnit(ASTExpressionUnit a){
		super(a.result,a.isEnd,a.isQuoted);
		this.name = a.name;
		this.type = a.type;
		this.value = a.value;
		
		
	}


	public String checkClass(String type) {
		//Check whether the unit type belongs to the primitive type
		//if yes then need to do auto-boxing
		//if no then UnitClass = Unit type;
		return "";
	}
	public String getType() {
		return this.type;
	}
	public String getName() {
		return this.name;
	}
	public String getValue() {
		return this.value;
	}
	public String toSyntax() {
		return super.toSyntax();
	}
	public void setValue(String value){
		this.value = value;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String typeof() {
		return super.typeof()+"->"+NODE_TYPE;
	}
}
