package ast;

import java.util.ArrayList;

public class ASTFunctionP extends ASTFunction {
	private ArrayList<ASTExpression> parameters;
	public ASTFunctionP(String name) {
		super(name);
	}
	public void addParameter(ASTExpression p){
		this.parameters.add(p);
		p.addParent(this);

	}
	public String toSyntax(){
		this.result = "def ";
		this.result += this.name.toSyntax();
		this.result+="(";
		for(int i = 0;i<this.parameters.size();i++){
			this.result+=this.parameters.get(i).toSyntax();
			if(i!=this.parameters.size()-1){
				this.result+=", ";
			}
		}
		this.result+="):\n";
		for(ASTStatement s:this.statements){
			this.result+="\t";
			this.result+=s.toSyntax();
			this.result+="\n";
		}
		return this.result;
	}
}
