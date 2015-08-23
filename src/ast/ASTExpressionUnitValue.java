package ast;

public class ASTExpressionUnitValue extends ASTExpressionUnit{
	private static final String NODE_TYPE = "Value";
	public ASTExpressionUnitValue(){
		super();
	}
	public ASTExpressionUnitValue(ASTNode a) {
		super(a);
	}
	public ASTExpressionUnitValue(String value){
		super();
		super.setValue(value);
	}
	public String typeof(){
		return super.typeof()+"->"+NODE_TYPE;
	}
	public String print(){
		this.result = super.getValue();
		this.result = super.print();
		return this.result;
	}
}
