package ast;

public class ASTExpressionUnit extends ASTExpression {
	private static final String NODE_TYPE = "Unit";
	
	protected String name; // unit name
	protected String type; // unit type
	protected String unitClass;
	protected String value;// unit value
	protected boolean isError; //For debugging purposes
	public ASTExpressionUnit() {
		super();
	}
	public ASTExpressionUnit(ASTNode a) {
		super(a);
	}
	public ASTExpressionUnit(String name,String type,String value){
		super(new ASTExpression(false));
		this.name = name;
		this.value = value;
		this.type = type;
		this.unitClass = checkClass(type);
	}
	public ASTExpressionUnit(String name,String type,String value,String unitClass){
		this(name,type,value);
		this.unitClass = unitClass;
	}
	public ASTExpressionUnit (ASTExpression a,String name,String type,String value) {
		super(a);
		this.name = name;
		this.type = type;
		this.value = value;
	}
	public ASTExpressionUnit(ASTExpression a,String name,String type,String value,String unitClass){

		this(a,name,type,value);
		this.unitClass = unitClass;
	}
	public ASTExpressionUnit(ASTExpressionUnit a){
		super(a.result,a.isEnd,a.isQuoted);
		this.name = a.name;
		this.type = a.type;
		this.value = a.value;
		this.unitClass = a.unitClass;
		
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
	public String print() {
		return super.print();
	}
	public void setValue(String value){
		this.value = value;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setClass(String className) {
		this.unitClass = className;
	}
	public String typeof() {
		return super.typeof()+"->"+NODE_TYPE;
	}
}
