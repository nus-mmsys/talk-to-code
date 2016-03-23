package ast;

public final class ASTExpressionUnitObjectConstructorJ extends ASTExpressionUnitObjectConstructor {

	public ASTExpressionUnitObjectConstructorJ(String type) {
		super(type);

	}
	public String toSyntax(){
		this.result = "new "+this.type.toSyntax()+"(";
		for(int i = 0;i<this.parameters.size();i++){
			this.result+=this.parameters.get(i).toSyntax();
			if(i!=this.parameters.size()-1){
				this.result+=", ";
			}
		}
		this.result +=")";
		return this.result;
	}
}
