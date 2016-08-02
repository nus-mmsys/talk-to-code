package ast.java;
import java.util.*;

public final class ASTJavaStatementSwitch extends ASTJavaSimpleStatement{
	
	private static final String TYPE_JAVA_STATEMENT_SWITCH = "Java Switch Statement Node";
	private static final int INDEX_INVALID = -2;
	private static final int INDEX_DEFAULT_BRANCH = -1;
	private ASTJavaExpression condition;
	private ArrayList<ASTJavaExpression> cases;
	private ArrayList<ArrayList<ASTJavaSimpleStatement>> statements;
	private ArrayList<Integer> mappingIndex;
	private ArrayList<ASTJavaSimpleStatement> defaultBranch;
	private int numOfBranches;
	private int numOfCases;
	private int currentCase;
	
	private void init(){
		this.cases = new ArrayList<ASTJavaExpression>();
		this.statements = new ArrayList<ArrayList<ASTJavaSimpleStatement>>();
		this.mappingIndex = new ArrayList<Integer>();
		this.defaultBranch = new ArrayList<ASTJavaSimpleStatement>();
		this.numOfBranches = this.statements.size();
		this.numOfCases = this.cases.size();
		this.currentCase = INDEX_INVALID;
		
	}
}
