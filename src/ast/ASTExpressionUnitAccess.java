package ast;

import java.util.ArrayList;

public class ASTExpressionUnitAccess extends ASTExpressionUnit {
	private static final String NODE_TYPE = "Expression Access";
	private ASTExpressionUnit parent;
	private ASTExpressionUnit child;
	public ASTExpressionUnitAccess(){
		super();
	}
	public ASTExpressionUnitAccess(ASTExpressionUnit parent,ASTExpressionUnit child){
		this.parent = parent;
		this.child = child;
		this.parent.parent = this;
		this.child.parent = this;
	
	}
	public ASTExpressionUnitAccess(ASTExpressionUnit parent){
		this.parent = parent;
		
		this.parent.parent = this;

	
	}
	public void addChild(ASTExpressionUnit child){
		this.child = child;
		child.addParent(this);
	}
	public static ASTExpressionUnitAccess generateNestedAccess(ArrayList<String> ids){
		ASTExpressionUnitIdentifier parent = new ASTExpressionUnitIdentifier(ids.get(0));
		ASTExpressionUnitAccess output = new ASTExpressionUnitAccess(parent);
		ASTExpressionUnitAccess current = output;
		for(int i = 1;i<ids.size();i++){
			ASTExpressionUnitIdentifier attributes = new ASTExpressionUnitIdentifier(ids.get(i));
			if(i!=ids.size()-1){
				ASTExpressionUnitAccess temp = new ASTExpressionUnitAccess(attributes);
				current.addChild(temp);
				current = (ASTExpressionUnitAccess) current.child;
			} else {
				current.addChild(attributes);				
			}
			
		}
		return current;
	}
	public String toSyntax(){
		this.result = this.parent.toSyntax()+"."+this.child.toSyntax();
		return super.toSyntax();
	}
	public String typeof(){
		return super.typeof()+NODE_TYPE;
	}
}
