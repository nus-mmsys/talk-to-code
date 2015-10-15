package ast;

public class ASTExpression extends ASTNode {
	private static final String NODE_TYPE = "Expression";
	
	protected String result;
	protected boolean isEnd = false;
	protected boolean isQuoted = false;
	
	public ASTExpression(ASTNode a) {
		super(a);
	}
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
	public String typeof() {
		return super.typeof()+"->"+NODE_TYPE;
	}
	public String print() {

		if(this.isQuoted) {
			this.result = quote(this.result);
		}
		if(this.isEnd){
			this.result = end(this.result);
		}
		return this.result;
	}
	protected static String quote(String text){
		return "("+text+")";
	}
	protected static String end(String text){
		return text+";";
	}
}
