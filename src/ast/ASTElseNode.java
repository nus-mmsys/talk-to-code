package ast;

import java.util.ArrayList;

public class ASTElseNode extends ASTNode{

	ArrayList<ASTNode> elseBody;
	
	ASTElseNode(ASTIfNode p)
	{
		super(p);
		elseBody = new ArrayList<ASTNode>();
	}
}
