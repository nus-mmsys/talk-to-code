package ast;

public final class ASTImportStatementC extends ASTImportStatement{

	public ASTImportStatementC(ASTExpression p) {
		super(p);
		
	}
	public String toSyntax(){
		this.result = "#include <";
		this.result += this.packageName.toSyntax();
		this.result += ">\n";
		return this.result;
	}
}
