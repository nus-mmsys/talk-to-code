package ast;

import java.util.ArrayList;

public class ASTNode {
	private static final String type = "ASTNode";
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
	//need to change
	public String print()
	{
		return "Hi, I am an ASTNode";
	}
	public String typeof(){
		return type;
	}
	int getActiveChild()
	{
		return activeChild;
	}
	
}
