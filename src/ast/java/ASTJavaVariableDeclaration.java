package ast.java;

import java.util.*;

public class ASTJavaVariableDeclaration extends ASTJavaSimpleStatement {
	private static final String TYPE_JAVA_STATEMENT_VAR_DECLARATION_NODE = "Java Variable Declaration Node";
	private static final String MSG_WRONG_VISIBILITY_TYPE = "Wrong visibility type, it can only be either default (0), public (1), protected (2) or private (3)";
	private static final int VISIBILITY_DEFAULT = 0;
	private static final int VISIBILITY_PUBLIC = 1;
	private static final int VISIBILITY_PROTECTED = 2;
	private static final int VISIBILITY_PRIVATE = 3;
	private String type;
	private boolean isConstant;
	private boolean isStatic;
	private boolean isAttribute;
	private int visibility;
	private ArrayList<ASTJavaObject> variables = new ArrayList<ASTJavaObject>();
	
	public ASTJavaVariableDeclaration(String type){
		this.variables = new ArrayList<ASTJavaObject>();
		this.type = type;
		this.isAttribute = false;
		this.isConstant = false;
		this.isStatic = false;
		this.visibility = VISIBILITY_DEFAULT;
	}
	public void setConstant(){
		this.isConstant = true;
	}
	public void setAttribute(){
		this.isAttribute = true;
	}
	public void setStatic(){
		this.isStatic = true;
	}
	public void setVisibility(int type) throws InputMismatchException {
		switch (type){
		case VISIBILITY_DEFAULT:
		case VISIBILITY_PUBLIC:
		case VISIBILITY_PROTECTED:
		case VISIBILITY_PRIVATE:
		{
			this.visibility = type;
			break;
		}
		default:
		{
			throw new InputMismatchException(MSG_WRONG_VISIBILITY_TYPE);
		}
		}
	}
	public void addVariable(String name){
		ASTJavaObjectVariable newVar = new ASTJavaObjectVariable(name);
		newVar.setConstant(this.isConstant);
		newVar.setAttribute(this.isAttribute);
		newVar.setStatic(this.isStatic);
		newVar.setVisibility(this.visibility);
		newVar.changeType(this.type);
		this.variables.add(newVar);
		
	}
	public void addVariable(ASTJavaExpressionAssignment variableWithValue){
		ASTJavaObjectVariable newVar = (ASTJavaObjectVariable) variableWithValue.getBody();
		newVar.setConstant(this.isConstant);
		newVar.setAttribute(this.isAttribute);
		newVar.setStatic(this.isStatic);
		newVar.setVisibility(this.visibility);
		newVar.changeType(this.type);
		this.variables.add(newVar);
	}
	public String toSyntax(){
		return super.toSyntax()+" -> "+TYPE_JAVA_STATEMENT_VAR_DECLARATION_NODE;
	}
	
}
