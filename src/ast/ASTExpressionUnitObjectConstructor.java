package ast;
import java.util.*;
public class ASTExpressionUnitObjectConstructor extends ASTExpressionUnit {
	private static final String NODE_TYPE = "Object Constructor";
	protected ASTExpressionUnitTypes type;
	protected ArrayList<ASTExpression> parameters;
	public ASTExpressionUnitObjectConstructor(String type){
		this.type = new ASTExpressionUnitTypes(type);
		this.type.addParent(this);
		this.parameters = new ArrayList<ASTExpression>();
	}
	public void addParameter(ASTExpression exp){
		this.parameters.add(exp);
		exp.addParent(this);
	}
	public String toSyntax(){
		return this.result;
	}
}
