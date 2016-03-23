package ast;

public class ASTExpressionUnitOperator extends ASTExpressionUnit{
	private static final String NODE_TYPE = "Types";
	private static final String[][] ALL_OPERATORS = {
					/*usability 000*/				{},
					/*usability 001*/				{"&","*"},
					/*usability 010*/				{">>>"},
					/*usability 011*/				{"++","--","&&","||",">>=","<<=","&=",
													"|=","^=","~"},
					/*usability 100*/			    {"**","//","<>","**=","//=","is"},
					/*usability 101*/				{},
					/*usability 110*/				{},
					/*usability 111*/				{"+","-","*","/","%","==","!=",
													 ">","<",">=","<=","!","&","|","^",
													 "~","<<",">>","=","+=","-=","*=",
													 "/=","%=",}};
	public static final String[][] PREFIX_OPERATORS = {
					/*INDEX C*/						{"&","*","++","--","-","!","~"},
					/*INDEX JAVA*/					{"++","--","-","!","~"},
					/*INDEX PYTHON*/				{"-","!","~"},
														};
	public static final String[][] POSTFIX_OPERATORS = {
			/*INDEX C*/						{"++","--"},
			/*INDEX JAVA*/					{"++","--"},
			/*INDEX PYTHON*/				{},
												};
	public static final String[][] INFIX_OPERATORS = {
			/*INDEX C*/						{"&&","||","+","-","*","/","%","==","!=",
				 							">","<",">=","<=","&","|","^","<<",">>"},
			/*INDEX JAVA*/					{"&&","||","+","-","*","/","%","==","!=",
					 						">","<",">=","<=","&","|","^","<<",">>",">>>"},
			/*INDEX PYTHON*/				{"**","//","<>","is","+","-","*","/","%","==","!=",
						 					">","<",">=","<=","&","|","^","<<",">>"},
											};
	public static final String[][] ASSIGN_OPERATORS = {
			/*INDEX C*/						{">>=","<<=","&=","|=","^=","=","+=","-=","*=",
				 							 "/=","%="},
			/*INDEX JAVA*/					{">>=","<<=","&=","|=","^=","=","+=","-=","*=",
					 						"/=","%="},
			/*INDEX PYTHON*/				{"**","//","<>","is","+","-","*","/","%","==","!=",
						 					">","<",">=","<=","&","|","^","<<",">>"},
											};
	private int usability;
	private String operator;
	public ASTExpressionUnitOperator(){
		super();
	}
	public ASTExpressionUnitOperator (String operator){
		this.usability = generateUsability(operator);
		this.operator = operator;
	}
	public static int generateUsability(String operator){
		int currentUsability = -1;
		for(int i = 0;i<ALL_OPERATORS.length;i++){
			for(int j = 0;j<ALL_OPERATORS[i].length;j++){
				if(operator.equals(ALL_OPERATORS[i][j])){
					currentUsability = i;
					break;
				}
			}
		}
		return currentUsability;
	}
	public static boolean isCorrectSet(ASTExpressionUnitOperator op,String[][] set){
		for(int i = 0;i<set.length;i++){
			for(int j = 0;j<set[i].length;j++){
				if(op.operator.equals(set[i][j])){
					return true;
				}
			}
		}
		return false;
	}
	public int getUsability(){
		return this.usability;
	}
	public String typeof(){
		return super.typeof()+"->"+NODE_TYPE;
	}
	public String toSyntax(){
		return this.operator;
	}
}
