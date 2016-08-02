package ast;

public final class ASTImportStatementJ extends ASTImportStatement{
	public ASTImportStatementJ(ASTExpression p) {
		super(p);
		
	}
	public String toSyntax(){
		this.result = "import ";
		this.result += this.packageName.toSyntax();
		this.result += ";\n";
		return this.result;
	}
}
