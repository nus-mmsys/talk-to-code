package ast;

public class ASTExpressionUnitIdentifier extends ASTExpressionUnit{
	private static final String NODE_TYPE = "Identifier";
	private String name;
	public ASTExpressionUnitIdentifier() {
		super();
	}

	public ASTExpressionUnitIdentifier(String name){
		this.name = name;
	}
	public String toSyntax(){
		return this.name;
	}
	public String typeof() {
		return super.typeof()+"->"+NODE_TYPE;
	}

	public boolean equals(String s){
		return this.name.equals(s);
	}
}
