package ast;

import java.util.ArrayList;

import ast.ASTNode;

public class ASTVarDec extends ASTNode{

	String type;
	String name;
	String value;
	
	public ASTVarDec(ASTNode p) {
		super(p);
	}
	
	public ASTVarDec()
	{
		parent = null;
		children = null;
	}
	
	public ASTVarDec(ASTNode p, String t, String n, String v)
	{
		super(p);
		type = t;
		name = n;
		value = v;
	}
	
	public String print()
	{
		if(value.equals(""))
			return type+" "+name+";\n";
		if(type.equals("char"))
			return type+" "+name+" = '"+value+"';\n";
		if(type.equals("string"))
			return type+" "+name+" = \""+ value + "\";\n";
		return type+" "+name+" = "+value+";\n";
	}

}
