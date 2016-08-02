package ast;
import java.util.ArrayList;
public class ASTExpressionUnitFunctionCall extends ASTExpressionUnit{
	private static final String NODE_TYPE = "Function Call";
	private String functionName;
	private ArrayList<ASTExpression> parameters;
	public ASTExpressionUnitFunctionCall(String name){
		this.functionName = name;
		this.parameters = new ArrayList<ASTExpression>();
	}
	public void addParameter(ASTExpression exp){
		this.parameters.add(exp);
		exp.parent = this;
	}
	public String typeof(){
		return super.typeof()+NODE_TYPE;
	}
	public String toSyntax(){
		this.result = this.functionName;
		this.result += "(";
		for(int index = 0;index<this.parameters.size();index++){
			this.result += this.parameters.get(index).toSyntax();
			if(index!=this.parameters.size()-1){
				this.result += ",";
			}
		}
		this.result += ")";
		return this.result;
	}

}
