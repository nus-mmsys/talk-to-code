package ast;
import java.util.*;

public class ASTExpressionUnitIdentifierArray extends ASTExpressionUnitIdentifier{
	private static final String NODE_TYPE = "Array";
	private static final String VALUE_UNDECLARED = "\0";
	private static final String VISIBLE_PUBLIC = "public";
	private static final String VISIBLE_PROTECTED = "protected";
	private static final String VISIBLE_PRIVATE = "private";
	//private ArrayList<ASTExpression> indexes = new ArrayList<ASTExpression>();
	private int dimension;
	public ASTExpressionUnitIdentifierArray() {
		super();
		this.dimension = 0;
	}
	public ASTExpressionUnitIdentifierArray(ASTNode a){
		super(a);
		this.dimension = 0;
	}
	public ASTExpressionUnitIdentifierArray(ASTExpressionUnitIdentifier a,int dimension){
		super(a);
		this.dimension = dimension;
		//this.indexes = indexes;
		//this.dimension = this.indexes.size();
	}
	public ASTExpressionUnitIdentifierArray(ASTExpressionUnitIdentifier a){
		super(a);
		this.dimension = 1;
		//this.indexes.add(index);
		//this.dimension = this.indexes.size();
	}
	public String print() {
		String result = "";
		if(this.isDeclaration){
			if(this.isAttribute) {
				result = componentAdd(result,this.getVisibility());
				if(this.isStatic) {
					result = componentAdd(result,"static");
				}
			}
			result += this.getType();
			for(int dimensionCount = 1; dimensionCount<=this.dimension;dimensionCount++){
				result+="[]";
			}
			result += this.getName();
		}
		else {
			result += this.getName();
			/*for(int dimensionCount = 0;dimensionCount<this.dimension;dimensionCount++){
				result = indexAddition(result,this.indexes.get(dimensionCount).print());
			}*/
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
	private static String indexAddition(String text,String index){
		return text+"["+index+"]";
	}
	public String typeof(){
		return super.typeof()+"->"+NODE_TYPE;
	}
}
