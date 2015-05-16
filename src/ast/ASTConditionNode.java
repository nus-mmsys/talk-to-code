package ast;

public class ASTConditionNode extends ASTNode{

	String value1;
	String operand;
	String value2;
	
	ASTConditionNode(ASTNode p)
	{
		super(p);
		value1="";
		operand="";
		value2="";
	}
	
	ASTConditionNode(String v1, String o, String v2)
	{
		value1 = v1;
		operand = o;
		value2 = v2;
	}
	
	public String print()
	{
		return value1+operand+value2;
	}
}
