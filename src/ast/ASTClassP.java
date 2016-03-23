package ast;

public class ASTClassP extends ASTClass {

	public ASTClassP(String name) {
		super(name);
	}
	public String toSyntax(){
		this.result = "class ";
		this.result += this.name;
		this.result += "(object):\n";
		for(ASTStatement s:this.statements){
			this.result += "\t";
			this.result+= s.toSyntax();
			this.result+= "\n";
		}
		return this.result;
	}
}
