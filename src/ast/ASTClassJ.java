package ast;
import java.util.ArrayList;
public class ASTClassJ extends ASTClass {
	private static final String DEFAULT_MODIFIER = "";
	private ArrayList<String> modifiers;

	private String inheritModifier = DEFAULT_MODIFIER;
	private ASTExpressionUnitIdentifier inheritClass;
	public ASTClassJ(String name) {
		super(name);
		this.modifiers = new ArrayList<String>();
	}
	public void addModifier(String modifier){
		this.modifiers.add(modifier);
	}
	
	public void addInheritance(String modifier,ASTExpressionUnitIdentifier inheritClass){
		this.inheritModifier = modifier;
		this.inheritClass = inheritClass;
		inheritClass.addParent(this);
	}
	
	public String toSyntax(){
		this.result = "";
		for(String s:this.modifiers){
			this.result += s;
			this.result += " ";
		}
		this.result += "class ";
		this.result += this.name;
		if(!this.inheritModifier.equals("")){
			this.result += " ";
			this.result += this.inheritModifier;
			this.result += " ";
			this.result += this.inheritClass.toSyntax();
		}
		this.result+= "{\n";
		for(ASTStatement s:this.statements){
			this.result += "\t";
			this.result+= s.toSyntax();
			this.result+= "\n";
		}
		this.result+="}\n";
		return this.result;
	}
}
