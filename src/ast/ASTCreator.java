package ast;
import io.ConsoleLogger;

import java.util.ArrayList;
import java.util.List;

import nlp.GrammarRelation;
import nlp.Sentence;
import nlp.Word;
import ast.ASTNode;


public class ASTCreator {
	public ASTMainBody root;//this is the root of the tree that will be delivered to the main function
	private int var_suffix;
	public ConsoleLogger consoleLogger;
	private ArrayList<String> variableList;
	private ArrayList<String> variableTypeList;
	private ArrayList<String> createList;
	private ArrayList<String> varTypeList;
	private ArrayList<ASTCustomFunction> functionList;
	
	public ASTCreator()
	{
		root = new ASTMainBody();
		var_suffix = 0;
	}
	
	//This is the preferred constructor
	public ASTCreator(ConsoleLogger c)
	{
		consoleLogger = c;
		root = new ASTMainBody();
		var_suffix = 0;
		variableList = new ArrayList<String>();
		variableTypeList = new ArrayList<String>();
		functionList = new ArrayList<ASTCustomFunction>();
		createList = new ArrayList<String>();
		createList.add("loop");
		createList.add("variable");
		createList.add("array");
		varTypeList = new ArrayList<String>();
		varTypeList.add("int");
		varTypeList.add("Integer");
		varTypeList.add("char");
		varTypeList.add("Character");
		varTypeList.add("bool");
		varTypeList.add("Boolean");
		varTypeList.add("String");
		varTypeList.add("Double");
		varTypeList.add("float");
	}
	
	
	//
	//Start: AST Creator functions
	//
	
	public void rectifyNodes(ASTNode r)
	{
		for(ASTNode a:r.children)
		{
			a.parent=r;
		}
	}
	
	public void constructAST(ArrayList<Sentence> sents)
	{
		int num_cmds = sents.size();
		for(int i=0; i<num_cmds; i++)
		{
			consoleLogger.log("[Sentence]\t" + sents.get(i).print());
			modifyNode(sents.get(i), root);
			rectifyNodes(root);
		}
	}
	
	public String print()
	{
		String res = "";
		for (ASTCustomFunction n : functionList) {
			res += n.print()+'\n';
		}
		res += root.print();
		return res;
	}
	
	//
	//End: AST Creator functions
	//
	
	//
	//Start:Create functions
	//
	
	public void modifyNode(Sentence s, ASTNode r)
	{
		//get command word
		Word w = s.words.get(0);
		if(w.word.toLowerCase().equals("create")||w.word.toLowerCase().equals("initialize")||w.word.toLowerCase().equals("declare")||w.word.toLowerCase().equals("make"))
		{
			ASTNode a = findCreate(s,w.word);
			if(a!=null)
				r.addChild(a);
		}
		else if(w.word.toLowerCase().equals("if"))
		{
			ASTNode a = findCondition(s, r);
			if(a!=null)
				r.addChild(a);
		}
		return;
	}
	
	public ASTNode findCreate(Sentence s, String w)
	{
		String r = s.findWord2InRelation(w, "dobj");
		if(r==null)
			consoleLogger.log("Could not find what to create, returning null");
		else
		{
			consoleLogger.log("Creating "+r);
			if((r.toLowerCase().equals("variable")||(existsInVarTypeList(r))))
				return createVariable(s);
			else if(s.find("variable"))
				return createVariable(s);
			else if (r.equalsIgnoreCase("function") || existsInFuncList(r) || s.find("function")) {
				return createFunction(s);
			}
			else
				consoleLogger.log("Could not find what to create, returning null");
		}
		return null;
				
	}
	
	public ASTNode createFunction(Sentence s) {
		ASTCustomFunction func = new ASTCustomFunction(root); // TODO Need to do non-root function definition
		String funcName = findFunctionName(s);
		String params = findFunctionParams(s); // TODO Support multiple inputs
		String retType = findFunctionReturnType(s); // TODO Add return types

		consoleLogger.log("Relations ");
		for (GrammarRelation rel : s.relations) {
			consoleLogger.log(rel.toString());
		}

		if (funcName == null) {
			consoleLogger.log("No function name found");
			funcName = "function"+functionList.size();
		}

		func.functionName = funcName;

		if (params != null) 
			func.functionParameters.add(params);
		else
			consoleLogger.log("No function parameters found");
		
		if (retType != null)
			func.retType = retType;
		
		functionList.add(func);
		return null; // TODO temp fix to avoid getting collected by rectify and modify
	}
	
	private String findFunctionName(Sentence s) {
		String r = s.findWord2InRelation("called", "dobj");
		return r;
	}

	private String findFunctionParams(Sentence s) {
		String r = s.findWord2InRelation("create", "nmod:with");
		if (existsInVarTypeList(r))
			return r;

		if (r != null) {
			String t = s.findWord2InRelation(r, "compound");
			return t + " " + r;
		}
			
		return null;
	}

	private String findFunctionReturnType(Sentence s) {
		ArrayList<String> params = new ArrayList<String>();
		String r = s.findWord2InRelation("returns", "dobj");
		if (existsInVarTypeList(r))
			return r;
		return null;
	}
	
	
	public ASTNode createVariable(Sentence s)
	{
		ASTVarDec retNode = new ASTVarDec();
		String type = findVariableType(s);
		if(type==null)
		{
			consoleLogger.log("Variable type not found, using default");
			retNode.type = "int";
			variableTypeList.add("int");
		}
		else
		{
			consoleLogger.log("Variable type: "+type);
			retNode.type = type;
			variableTypeList.add(type);
		}
		
		String name = findVariableName(s);
		if(name==null)
		{
			consoleLogger.log("Variable name not found, using default");
			retNode.name = "var"+var_suffix;
			variableList.add(retNode.name);
			var_suffix++;
		}
		else
		{
			consoleLogger.log("Variable name: "+name);
			retNode.name = name;
			variableList.add(retNode.name);
		}
		
		String value = findVariableValue(s);
		if(value==null)
		{
			consoleLogger.log("Variable value not found, using default");
			retNode.value = "0";
		}
		else
		{
			consoleLogger.log("Variable value: "+value);
			retNode.value = value;
		}
		
		return retNode;
	}
	
	public String findVariableValue(Sentence s)
	{
		String r = s.findWord2InRelation("value", "prep_of");
		if(r==null)
			return null;
		return r;
	}
	
	public String findVariableType(Sentence s)
	{
		for(Word w:s.words)
		{
			if(existsInVarTypeList(w.word))
			{
				if(w.word.toLowerCase().equals("integer"))
					return "int";
				else if(w.word.toLowerCase().equals("boolean"))
					return "bool";
				else if(w.word.toLowerCase().equals("character"))
					return "char";
				else
					return w.word;
			}
		}
		return null;
	}
	
	public boolean existsInVarTypeList(String w)
	{
		if (w == null) return false;
		for(String s:varTypeList)
		{
			if(s.toLowerCase().equals(w.toLowerCase()))
				return true;
		}
		return false;
	}	
	
	public boolean existsInFuncList(String w) {
		for (ASTCustomFunction n : functionList) {
			if (n.functionName.equalsIgnoreCase(w)) {
				return true;
			}
		}
		return false;
	}
	
	public String findVariableName(Sentence s)
	{
		String r = null;
		if(s.find("named"))
			r = s.returnWordElement("named", 1);
		else
			consoleLogger.log("Could not find 'named', returning null");
		if(r==null)
			consoleLogger.log("Could not find a name, return null");
		else
			return r;
		return null;
	}
	
	public String sanitizeVariableName(String s)
	{
		if(s!=null)
		{
			while(s.indexOf('.')!=-1)
			{
				s = s.replace('.', ' ');
			}
			return s.trim();
		}
		
		return s;
	}
	
	//
	//End: Create functions
	//
	
	//
	//Start:Condition Functions
	//
	
	public ASTIfNode findCondition(Sentence s, ASTNode parent)
	{
		consoleLogger.log("Value 1 is "+s.words.get(1).word);
		ASTIfNode ifNode = new ASTIfNode(parent);
		ASTConditionNode c = new ASTConditionNode(ifNode);
		c.value1 = s.words.get(1).word;
		c.value2 = findSecondValue(s, c.value1);
		c.operand = findConditionalValue(s);
		ifNode.conditions.add(c);
		
		if(s.find("print"))
		{
			consoleLogger.log("Print function call detected");
			ASTFunction af = new ASTFunction(ifNode);
			af.functionName = "printf";
			String r = s.findWord2InRelation("print", "appos");
			if(r==null)
			{
				r = s.findWord2InRelation("print", "dep");
				if(r==null)
				{					
					consoleLogger.log("Unclear what to print, returning");
					return ifNode;
				}
			}

			r = sanitizeVariableName(r);
			if(checkVariable(r)>-1)
			{
				if(variableTypeList.get(checkVariable(r)).equals("int"))
					af.functionParameters.add("\"%d\"");
				else if(variableTypeList.get(checkVariable(r)).equals("float"))
					af.functionParameters.add("\"%f\"");
				else if(variableTypeList.get(checkVariable(r)).equals("double"))
					af.functionParameters.add("\"%lf\"");
				else if(variableTypeList.get(checkVariable(r)).equals("char"))
					af.functionParameters.add("\"%c\"");
				else
					af.functionParameters.add("\"%s\"");
			}
			else
				consoleLogger.log("Warning: variable not previously created. Continuing.");
			af.functionParameters.add(r);
			ifNode.addChild(af);
		}
		return ifNode;
	}
	
	public String findSecondValue(Sentence s, String v)
	{
		String r = s.findWord1InRelation(v, "nsubj");
		if(r==null)
		{
			consoleLogger.log("No second value could be found for value 1, returning null");
			return null;
		}
		else
		{
			consoleLogger.log("Value 2 is "+r);
			return r;
		}
	}
	
	public String findConditionalValue(Sentence s)
	{
		if(s.find("greater"))
			return ">";
		else if(s.find("smaller")||s.find("less"))
			return "<";
		else if(s.find("equals"))
			return "==";
		else if(s.findPhrase("not equal"))
			return "!=";
		else if(s.findPhrase("greater than or equal"))
			return ">=";
		else if(s.findPhrase("smaller than or equal"))
			return "<=";
		else
			return null;
			
	}
	
	public int checkVariable(String varName)
	{
		for(int i =0; i<variableList.size(); i++)
		{
			if(varName.equals(variableList.get(i)))
				return i;
		}
		return -1;	
	}

	//
	//End: Condition Functions
	//
}
