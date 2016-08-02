package ast;
import java.util.*;

public class ASTExpressionUnitLiteralArray extends ASTExpressionUnitLiteral{
	private static final String NODE_TYPE = "Array";
	private static final int USABILITY = 7; //111
	private ArrayList<ASTExpression> entries;
	private int size;
	
	
	public ASTExpressionUnitLiteralArray(){
		super();
		initialize();
	}

	public void addValue(String value){
		ASTExpressionUnitLiteral temp = new ASTExpressionUnitLiteral(value);
		this.entries.add(temp);
		temp.parent = this;
	}
	public void addValue(ASTExpression exp){
		this.entries.add(exp);
		exp.parent = this;
	}
	private void initialize() {
		this.entries = new ArrayList<ASTExpression>();
		this.size = entries.size();
		this.usability = USABILITY;
	}
	public String typeof(){
		return super.typeof()+"->"+NODE_TYPE;
	}
	
	public String toSyntax(int programmingLanguageSyntax) throws Exception{
		switch(programmingLanguageSyntax){
		case INDEX_C:
		case INDEX_JAVA:
		{
			this.result = "";
			this.result += "{";
			int index = 0;
			for(;index<size-1;index++){
				this.result+= this.entries.get(index).toSyntax();
				this.result+= ", ";
			}
			this.result+= this.entries.get(index).toSyntax();
			this.result += "}";
			return this.result;
		}
		case INDEX_PYTHON:
		{
			this.result = "";
			this.result += "[";
			int index = 0;
			for(;index<size-1;index++){
				this.result+= this.entries.get(index).toSyntax();
				this.result+= ", ";
			}
			this.result+= this.entries.get(index).toSyntax();
			this.result += "]";
			return this.result;
		}
		default:
			throw new Exception("Not supported Programming Language.");
		}
		
	}
}
