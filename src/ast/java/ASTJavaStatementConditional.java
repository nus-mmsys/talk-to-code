package ast.java;
import java.util.*;

import ast.ASTNode;
public final class ASTJavaStatementConditional extends ASTJavaSimpleStatement {
	private static final String TYPE_JAVA_STATEMENT_CONDITION = "Java Conditional Statement Node";
	private ASTJavaExpression condition;
	private ArrayList<ASTJavaSimpleStatement> ifBranch;
	private ArrayList<ASTJavaSimpleStatement> elseBranch;
	
	private void initialize() {
		this.ifBranch =  new ArrayList<ASTJavaSimpleStatement>();
		this.elseBranch = new ArrayList<ASTJavaSimpleStatement>();
		this.condition = new ASTJavaObjectLiteral("true");
		
	}
	public void changeCondition(ASTJavaExpression input){
		this.condition = input;
	}
	public ASTJavaStatementConditional(){
		this.initialize();
		
	}
	public ASTJavaStatementConditional(ASTJavaExpression condition){
		this.initialize(); 
		this.changeCondition(condition);
		
	}
	public void addIf(ASTJavaSimpleStatement input){
		this.ifBranch.add(input);
		input.addParent(this);
	}
	public void addElse(ASTJavaSimpleStatement input){
		this.elseBranch.add(input);
		input.addParent(this);
	}
	public String toSyntax(){
		return super.toSyntax()+" -> "+TYPE_JAVA_STATEMENT_CONDITION;
		
	}
}
