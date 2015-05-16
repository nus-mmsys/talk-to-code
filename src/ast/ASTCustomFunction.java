package ast;

import java.lang.*;
import java.util.*;

public class ASTCustomFunction extends ASTFunction {

	String retType;

	ASTCustomFunction(ASTNode p)
	{
		super(p);

		parent = null;
		children = new ArrayList<ASTNode>();
		nextSibling = null;
		activeChild = 0;
		retType = "void";
	}
	
	public void setActiveChild(int i)
	{
		activeChild = i;
	}
	
	public String print()
	{
		String retString = retType+" "+functionName +" (";
		for(int i = 0; i<functionParameters.size(); i++)
		{
			if(i!=functionParameters.size()-1)
				retString=retString.concat(functionParameters.get(i).trim()+", ");
			else
				retString=retString.concat(functionParameters.get(i).trim());
		}
		retString = retString.concat(")\n{\n");

		for(int i = 0; i<children.size(); i++)
		{
			retString = retString.concat((children.get(i)).print());
		}
		return retString.concat("\n\treturn;\n}\n");
	}


}
