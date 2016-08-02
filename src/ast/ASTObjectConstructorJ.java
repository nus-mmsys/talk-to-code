package ast;
import java.util.*;
public final class ASTObjectConstructorJ extends ASTObjectConstructor {
	private ArrayList<ASTExpressionUnitTypes> types;
	private ASTExpressionUnitIdentifier name;
	private ArrayList<String> modifiers;
	public ASTObjectConstructorJ(String name) {
		super();
		ASTExpressionUnitIdentifier objectName = new ASTExpressionUnitIdentifier(name);
		this.name = objectName;
		this.name.addParent(this);
		this.modifiers = new ArrayList<String>();
	}
	public void addModifier(String mod){
		this.modifiers.add(mod);
	}
	protected void addParameter(ASTExpressionUnitIdentifier p,ASTExpressionUnitTypes t){
		super.addParameter(p);
		this.types.add(t);
		t.addParent(this);
	}
	public String toSyntax(){
		this.result = "";
		for(String s:this.modifiers){
			this.result+=s;
			this.result+=" ";
		}
		this.result+= this.name.toSyntax();
		this.result+="(";
		for(int i = 0;i<this.types.size();i++){
			this.result+=this.types.get(i).toSyntax();
			this.result+=" ";
			this.result+=this.parameters.get(i).toSyntax();
			if(i!=this.types.size()-1){
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
