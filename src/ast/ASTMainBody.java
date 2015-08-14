package ast;

import java.util.ArrayList;

import ast.ASTNode;

public class ASTMainBody extends ASTNode {
	
	String retType;
	
	public ASTMainBody()
	{
		parent = null;
		children = new ArrayList<ASTNode>();
		nextSibling = null;
		activeChild = 0;
		retType = "void";
	}
	
	public ASTMainBody(ASTNode p)
	{
		super(p);
	}
	
	public ASTMainBody(ASTNode p, String r)
	{
		super(p);
		nextSibling = null;
		retType = r;
	}
	
	public void setActiveChild(int i)
	{
		activeChild = i;
	}
	
	public String print()
	{
		String retString = retType+" main()"+"\n"+"{\n";
		for(int i = 0; i<children.size(); i++)
		{
			retString = retString.concat("\t"+(children.get(i)).print());
		}
		return retString.concat("\n\treturn;\n}");
	}

}

