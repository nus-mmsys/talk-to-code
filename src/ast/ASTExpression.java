package ast;

public class ASTExpression extends ASTNode {
	private static final String NODE_TYPE = "Expression";
	
	protected boolean isEnd = false;
	protected boolean isQuoted = false;
	
	public ASTExpression(){
		super();
	}
	
	public ASTExpression(String result,boolean isEnd,boolean isQuote){
		this(isEnd,isQuote);
		this.result = result;

	}
	public ASTExpression(boolean isEnd,boolean isQuote){
		this(isQuote);
		this.isEnd = isEnd;
		
	}
	public ASTExpression(boolean isQuote){
		super();
		this.isQuoted = isQuote;
		this.isEnd = false; //Default Singular Expression
		this.result = "";
		
	}
	public ASTExpression(ASTExpression a){
		this.result = a.result;
		this.isEnd = a.isEnd;
		this.isQuoted = a.isQuoted;
	}
	public void setResult(String text){
		this.result = text;
	}
	public void setQuote(){
		this.isQuoted = true;
	}
	public String typeof() {
		return super.typeof()+"->"+NODE_TYPE;
	}
	public String toSyntax() {	
		return this.result;
	}
	protected void quote(){
		this.result = "("+this.result+")";
	}
}
