package ast.java;
import java.util.*;

public class ASTJavaProgram extends ASTJavaNode {
	private static final String TYPE_Program_NODE = "Program Node";
	private static final String NAME_NEW_PROGRAM = "NewProgram";
	private static final String NAME_POSTFIX = ".java";
	private static int count = 0;
	private String name;
	private ArrayList<ASTJavaImport> importField;
	private ArrayList<ASTJavaClassDeclaration> classField;
	public ASTJavaProgram(){
		
		super();
		if(this.count == 0){
			this.name = NAME_NEW_PROGRAM+NAME_POSTFIX;
		} else {
			this.name = NAME_NEW_PROGRAM+count+NAME_POSTFIX;
		}
		this.importField = new ArrayList<ASTJavaImport>();
		this.classField = new ArrayList<ASTJavaClassDeclaration>();
		count++;
	}
	public ASTJavaProgram(String name){
		
		super();
		this.name = name+NAME_POSTFIX;
		this.importField = new ArrayList<ASTJavaImport>();
		this.classField = new ArrayList<ASTJavaClassDeclaration>();
	}
	public void addImport(ASTJavaImport importStatement){
		this.importField.add(importStatement);
		importStatement.addParent(this);
		
	}
	public void addClass(ASTJavaClassDeclaration classDeclaration){
		this.classField.add(classDeclaration);
		classDeclaration.addParent(this);
	}
}
