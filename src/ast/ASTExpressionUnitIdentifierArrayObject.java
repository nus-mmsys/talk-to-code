package ast;
import java.util.*;
public class ASTExpressionUnitIdentifierArrayObject extends ASTExpressionUnitIdentifier{
	private static final String NODE_TYPE = "Array Object";
	private static final int USABILITY = 7;//111
	private ArrayList<ASTExpression> indexes;
	private String name;
	private int dimension;
	
	private void initialize() {
		this.indexes  = new ArrayList<ASTExpression>();
		this.dimension = 0;
		this.usability = USABILITY;
	}
	
	public ASTExpressionUnitIdentifierArrayObject(){
		super();
		initialize();
	}

	public ASTExpressionUnitIdentifierArrayObject(String name){
		this.name = name;
		initialize();
	}
	public void addIndex(ASTExpression index){
		this.indexes.add(index);
		this.dimension++;
		index.parent = this;
	}
	public String toSyntax(){
			this.result = "";
			this.result+=this.name;
			for(int i = 0; i<this.dimension;i++){
				this.result+="[";
				this.result+=this.indexes.get(i).toSyntax();
				this.result+="]";
			}
			
			return this.result;
		
		
	}
	public String typeof(){
		return super.typeof()+"->"+NODE_TYPE;
	}
}
