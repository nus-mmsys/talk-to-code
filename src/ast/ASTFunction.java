package ast;

import java.util.ArrayList;

public class ASTFunction extends ASTNode{
	
	public String functionName;
	public ArrayList<String> functionParameters;
	
	ASTFunction(ASTNode p)
	{
		super(p);
		functionName = "";
		functionParameters = new ArrayList<String>();
	}
	
	public String print()
	{
		String ret = functionName+"(";
		for(int i = 0; i<functionParameters.size(); i++)
		{
			if(i!=functionParameters.size()-1)
				ret=ret.concat(functionParameters.get(i).trim()+", ");
			else
				ret=ret.concat(functionParameters.get(i)+");\n");
		}
		return ret;
	}
	
}
