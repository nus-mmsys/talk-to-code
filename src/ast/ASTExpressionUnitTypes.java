package ast;

public final class ASTExpressionUnitTypes extends ASTExpressionUnit{
	private static final String NODE_TYPE = "Types";
	private static final int USABILITY = 7; // 011 since python does not have primitive types
	private static final String[] PRIMITIVE_TYPE_C = {"char","signed char","unsigned char","short","short int",
												"signed short","signed short int","unsigned short", "unsigned short int",
												"int","signed","signed int","unsigned","unsigned int",
												"long","long int","signed long","signed long int","unsigned long",
												"unsigned long int","long long","long long int","signed long long",
												"signed long long int","unsigned long long","unsigned long long int","float",
												"double","long double"};
	private static final String[] PRIMITIVE_TYPE_JAVA = { "byte","short","int","long","float","double","char",
													"String","boolean"};
	
	private String type;
	public ASTExpressionUnitTypes(){
		super();
		this.usability = USABILITY;
	}
	public ASTExpressionUnitTypes(String type){
		this();
		this.type = type;
	}
	public String typeof(){
		return super.typeof()+"->"+NODE_TYPE;
	}
	public String toSyntax(){
		return this.type;
	}
	public static boolean isValidPrimitive(int programmingLanguageIndex,String type) throws Exception{
		switch(programmingLanguageIndex){
		case INDEX_C:
		{
			return isContains(PRIMITIVE_TYPE_C,type);
			
		}
		case INDEX_JAVA:
		{
			return isContains(PRIMITIVE_TYPE_JAVA,type);
		}
		case INDEX_PYTHON:{
			return false;
		}
		default:{
			throw new Exception("NOT SUPPORTED PROGRAMMING LANGUAGE");
		}
		}
	}
	private static boolean isContains(String[] primitiveTypes,String input){
		for(int index = 0; index<primitiveTypes.length;index++){
			if(primitiveTypes[index].equals(input.trim())){
				return true;
			}
		}
		return false;
	}
}
