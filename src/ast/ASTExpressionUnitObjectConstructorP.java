package ast;

public class ASTExpressionUnitObjectConstructorP extends ASTExpressionUnitObjectConstructor {

	public ASTExpressionUnitObjectConstructorP(String type) {
		super(type);
	}
	public String toSyntax(){
		this.result = this.type.toSyntax()+"(";
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
