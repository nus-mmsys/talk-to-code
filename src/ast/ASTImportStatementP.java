package ast;

public final class ASTImportStatementP extends ASTImportStatement{
	public ASTImportStatementP(ASTExpression p) {
		super(p);
		
	}
	public String toSyntax(){
		this.result = "import ";
		this.result += this.packageName.toSyntax()+"\n";
		return this.result;
	}
}
