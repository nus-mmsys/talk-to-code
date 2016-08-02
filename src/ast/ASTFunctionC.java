package ast;

import java.util.*;
public class ASTFunctionC extends ASTFunction {
	private ArrayList<String> modifiers;
	private ASTExpressionUnitTypes returnType;
	private ArrayList<ASTExpressionUnitTypes> types;
	private ArrayList<ASTExpressionUnitIdentifier> parameters;
	
	public ASTFunctionC(String name) {
		super(name);
		this.returnType = new ASTExpressionUnitTypes("void");//default
		this.types = new ArrayList<ASTExpressionUnitTypes>();
		this.parameters = new ArrayList<ASTExpressionUnitIdentifier>();
		this.modifiers = new ArrayList<String>();
		
	}
	public void addModifier(String modifier){
		this.modifiers.add(modifier);
		
	}
	public void addParameter(ASTExpressionUnitTypes t,ASTExpressionUnitIdentifier p){
		this.parameters.add(p);
		p.addParent(this);
		this.types.add(t);
		t.addParent(this);
	}
	public void addReturnType(ASTExpressionUnitTypes t){
		this.returnType = t;
		t.addParent(this);
	}
	public String toSyntax(){
		this.result = "";
		if(!this.name.equals("main")){
			for(String mod : this.modifiers){
				this.result += mod;
				this.result += " ";
			}
			this.result+=this.returnType.toSyntax();
			this.result+=" ";
			this.result+=this.name.toSyntax();
			this.result+="(";
			for(int i =0;i<this.types.size();i++){
				this.result+=this.types.get(i).toSyntax();
				if(i!=this.types.size()-1){
					this.result+=", ";
				}
			}
			this.result+=");\n";
		}
		for(String mod : this.modifiers){
			this.result += mod;
			this.result += " ";
		}
		this.result+=this.returnType.toSyntax();
		this.result+=" ";
		this.result+=this.name.toSyntax();
		this.result+="(";
		for(int j =0;j<this.types.size();j++){
			this.result+=this.types.get(j).toSyntax();
			this.result+=" ";
			this.result+=this.parameters.get(j).toSyntax();
			if(j!=this.types.size()-1){
				this.result+=", ";
			}
		}
		this.result+="){\n";
		for(ASTStatement s:this.statements){
			this.result+="\t";
			this.result+=s.toSyntax();
			this.result+="\n";
		}
		this.result+="}\n";
		return this.result;
	}
}
