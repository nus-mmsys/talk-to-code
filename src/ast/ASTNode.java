package ast;

import java.util.ArrayList;

public class ASTNode {
	ASTNode parent;
	ArrayList<ASTNode> children;
	ASTNode nextSibling;
	int activeChild;
	
	public ASTNode()
	{
		parent = null;
		children = new ArrayList<ASTNode>();
		nextSibling = null;
		activeChild = 0;
	}
	
	public ASTNode(ASTNode p)
	{
		parent = p;
		children = new ArrayList<ASTNode>();
		nextSibling = null;
		activeChild =0;
	}
	
	void addChild(ASTNode a)
	{
		a.parent = this;
		children.add(a);
	}
	
	ASTNode getNextChild()
	{
		ASTNode a = children.get(0);
		children.remove(0);
		return a;
	}
	
	public String print()
	{
		return "Hi, I am an ASTNode";
	}
	
	int getActiveChild()
	{
		return activeChild;
	}
	
}
