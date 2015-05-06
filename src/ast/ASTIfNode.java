package ast;

import java.util.ArrayList;

public class ASTIfNode extends ASTNode {
	
	ArrayList<ASTConditionNode> conditions;
	ASTElseNode elseNode;
	
	ASTIfNode(ASTNode p)
	{
		super(p);
		conditions = new ArrayList<ASTConditionNode>();
	}
	
	public String print()
	{
		String ret = "if";
		for(ASTConditionNode a: conditions)
		{
			ret = ret.concat("("+a.print()+")");
		}
		ret = ret.concat("\n{\n");
		for(ASTNode a:children)
			ret = ret.concat(a.print());
		ret = ret.concat("}");
		return ret;
	}
	
	
	
}
