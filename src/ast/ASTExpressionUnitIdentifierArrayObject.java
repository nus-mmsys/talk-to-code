package ast;
import java.util.*;
public class ASTExpressionUnitIdentifierArrayObject extends ASTExpressionUnitIdentifier{
	private static final String NODE_TYPE = "Array Object";
	private ArrayList<ASTExpression> indexes;
	private int dimension;
	
	private void initialize() {
		this.indexes  = new ArrayList<ASTExpression>();
		this.dimension = 0;
		this.isDeclaration = false;
	}
	
	public ASTExpressionUnitIdentifierArrayObject(){
		super();
		initialize();
	}

	public ASTExpressionUnitIdentifierArrayObject(ASTExpressionUnitIdentifier a,ASTExpression index){
		super(a);
		initialize();
		this.indexes.add(index);
		this.dimension = this.indexes.size();
	}
	public ASTExpressionUnitIdentifierArrayObject(ASTExpressionUnitIdentifier a,Collection<ASTExpression> indexes){
		super(a);
		initialize();
		for(ASTExpression index:indexes){
			this.indexes.add(index);
		}
		this.dimension = this.indexes.size();
		
	}
	public String print() {
		String result = "";
		result+=this.name;
		for(int i = 0; i<this.dimension;i++){
			result+="[";
			result+=this.indexes.get(i);
			result+="]";
		}
		this.result = result;
		if(this.isQuoted) {
			this.result = quote(this.result);
		}
		if(this.isEnd){
			this.result = end(this.result);
		}
		return this.result;
	}
	public String typeof(){
		return super.typeof()+"->"+NODE_TYPE;
	}
}
