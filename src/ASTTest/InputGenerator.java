package ASTTest;
import java.util.*;
import java.io.*;
public class InputGenerator {
	private static ArrayList<String> legalLiterals = new ArrayList<String>();
	private static ArrayList<String> legalCharacters = new ArrayList<String>();
	private static ArrayList<String> numberLiterals = new ArrayList<String>();
	private static final int INDEX_BYTE = 0;
	private static final int INDEX_SHORT = 1;
	private static final int INDEX_INT = 2;
	private static final int INDEX_LONG = 3;
	private static final int INDEX_FLOAT = 4;
	private static final int INDEX_DOUBLE = 5;
	private static final int INDEX_BOOLEAN = 6;
	private static final int INDEX_CHAR = 7;
	private static final int INDEX_STRING = 8;
	private static final int MAX_VAR_LENGTH = 20;
	private static final int MAX_EXP_LENGTH = 5;
	private static final int MAX_STR_LENGTH = 100;
	private static final int INDEX_PRE = 0;
	private static final int INDEX_IN = 1;
	private static final int INDEX_POST = 2;
	private static final String[] primitive_types = {"byte","short","int","long","float","double","boolean","char","String"};
	private static final String[] prefix_operators = {"#pre_inc","#pre_dec","#not"};
	private static final String[] postfix_operators = {"#post_inc","#post_dec"};
	private static final String[] infix_operators = {"#plus","#minus","#multiply","#divide","#less_than","#greater_than","#equal","#less_equal","#greater_equal",
													 "#not_equal","#or","#and","#bit_and","#bit_or","#bit_xor","#mod","#shift_left","#shift_right","#shift_right_zero"};
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		init();
		int input = sc.nextInt();
		ArrayList<String> inputs = generateCreateVariable(input);
		outputToFile(inputs);
	}
	private static void init() {
		for(int i = 0;i<26;i++){
			legalLiterals.add(String.valueOf((char)(65+i)));
			legalLiterals.add(String.valueOf((char)(97+i)));
			
		}
		legalLiterals.add("_");
		for(int j = 0;j<10;j++){
			numberLiterals.add(String.valueOf(j));
			
		}
		for(int k = 32;k<=126;k++){
			if(k!=34&&k!=44&&k!=63)
			legalCharacters.add(String.valueOf((char)k));
		}

		legalCharacters.add("");
	}
	private static String randomVariableName(int length){
		String output = "";
		Random ran = new Random();
		for(int i = 0; i<length;i++){
			if(i == 0) {
				output+=legalLiterals.get(Math.abs(ran.nextInt()%legalLiterals.size()));
			} else {
				if(ran.nextInt()%2 == 0){
					output+=numberLiterals.get(Math.abs(ran.nextInt()%10));
				} else {
					output+=legalLiterals.get(Math.abs(ran.nextInt()%legalLiterals.size()));
				}
			}
		}
		return output;
	}
	private static String randomStringLiteral(int length){
		String output = "\"";
		Random ran = new Random();
		for(int i = 0;i<length;i++){
			output+=legalCharacters.get(Math.abs(ran.nextInt()%legalCharacters.size()));
		}
		output+="\"";
		return output;
	}
	private static String randomCharacter(){
		String output = "\'";
		Random ran = new Random();
		output+=legalCharacters.get(Math.abs(ran.nextInt()%legalCharacters.size()));
		output+="\'";
		return output;
	}
	private static String randomInt(){
		String output = "";
		Random ran = new Random();
		output+=String.valueOf(ran.nextInt());
		return output;
	}
	private static String randomByte(){
		String output = "";
		Random ran = new Random();
		
		output+=String.valueOf(Math.abs(ran.nextInt()%128));

		return output;
	}
	private static String randomShort(){
		String output = "";
		Random ran = new Random();
		if(ran.nextInt()%2==0){
			output+="-";
			output+=String.valueOf(Math.abs(ran.nextInt()%32768)+1);
		} else {
			output+=String.valueOf(Math.abs(ran.nextInt()%32768));
		}
		return output;
	}
	private static String randomLong(){
		String output = "";
		Random ran = new Random();
		output+= String.valueOf(ran.nextLong());
		return output;
	}
	private static String randomFloat(){
		String output = "";
		Random ran = new Random();

		output+=String.valueOf(Math.abs(ran.nextInt()%32768));
		output+=".";
		output+=String.valueOf(Math.abs(ran.nextInt()%99999));

		
		return output;
	}
	
	private static ArrayList<String> generateCreateVariable(int no){
		ArrayList<String> output = new ArrayList<String>();
		Random ran = new Random();
		
		for(int i = 0; i<no;i++){
			String generatedInput = "";
			generatedInput +="#create ";
			int types = Math.abs(ran.nextInt()%primitive_types.length);
			generatedInput += primitive_types[types];
			generatedInput += generateVariableInput(ran);
			int values = Math.abs(ran.nextInt()%3);
			switch (values){
			case 0:
			{
				generatedInput += generateValue(ran, types);
				break;
			}
			case 1:{
				generatedInput += generateVariableInput(ran);
				break;
			}
			case 2:{
				generatedInput += generateExpression(ran);
				break;
			}
			}
			generatedInput += ";;";
			output.add(generatedInput);			
		}
		return output;
	}
	private static String generateExpression(Random ran){
		int type = ran.nextInt()%3;
		String output = "";
		switch (type){
		case INDEX_PRE:{
			output += generatePrefix(ran);
			break;
		}
		case INDEX_IN:{
			output += generateInfix(ran);
			break;
		}
		case INDEX_POST:{
			output += generatePostfix(ran);
			break;
		}
		}
		return output;
	}
	private static String generatePrefix(Random ran){
		boolean isValue = ran.nextBoolean();
		String output = "";
		if(isValue){
			output+="#bit_not ";
			output+="#value ";
			output+=randomInt()+" ";
		} else {
			int index = Math.abs(ran.nextInt()%prefix_operators.length);
			output += prefix_operators[index];
			output += " #variable ";
			output += randomVariableName(Math.abs(ran.nextInt()%MAX_VAR_LENGTH));
		}
		return output;
	}
	private static String generatePostfix(Random ran){
		String output = "";
		output+="#post #variable ";
		output+= randomVariableName(Math.abs(ran.nextInt()%MAX_VAR_LENGTH));
		int index = Math.abs(ran.nextInt()%postfix_operators.length);
		output += postfix_operators[index];
		return output;
	}
	private static String generateInfix(Random ran){
		String output = "";
		int length = Math.abs(ran.nextInt()%MAX_EXP_LENGTH);
		boolean isValue = ran.nextBoolean();
		if(isValue){
			output += generateValue(ran,Math.abs(ran.nextInt()%primitive_types.length));
		} else {
			output += generateVariableInput(ran);
		}
		for(int i = 1;i<length;i++){
			boolean isQuoted = ran.nextBoolean();
			if(isQuoted){
				output = "("+output;
			}
			output += infix_operators[Math.abs(ran.nextInt()%infix_operators.length)];
			isValue = ran.nextBoolean();
			if(isValue){
				output += generateValue(ran,Math.abs(ran.nextInt()%primitive_types.length));
			}else {
				output += generateVariableInput(ran);
			}
			if(isQuoted){
				output = output+")";
			
			}
		}
		return output;
	}
	private static String generateVariableInput(Random ran) {
		return " #variable "+randomVariableName(Math.abs(ran.nextInt()%MAX_VAR_LENGTH)+1);
	}
	private static String generateValue(Random ran,int types) {
		String output = "";
		output += " #value ";
		switch (types){
		case INDEX_BYTE:{
			output += randomByte()+" ";
			break;
		}
		case INDEX_SHORT:{
			output += randomShort()+" ";
			break;
		}
		case INDEX_INT:{
			output += randomInt()+" ";
			break;
		}
		case INDEX_LONG:{
			output += randomLong()+" ";
			break;
		}
		case INDEX_FLOAT:
		case INDEX_DOUBLE:{
			output += randomFloat()+" ";
			break;
		}
		case INDEX_BOOLEAN:{
			output += ran.nextInt()%2==0?"true ":"false ";
			break;
		}
		case INDEX_CHAR:{
			output += randomCharacter()+" ";
			break;
		}
		case INDEX_STRING:{
			output += randomStringLiteral(Math.abs(ran.nextInt()%MAX_STR_LENGTH))+" ";
			break;
		}
		}
		return output;
	}
	
	private static void outputToFile(ArrayList<String> input){
		try{
			File inputFile = new File("input.txt");
			if(!inputFile.exists()){
				inputFile.createNewFile();
			}
			System.out.println(inputFile.getAbsolutePath());
			FileWriter fw = new FileWriter(inputFile.getAbsoluteFile());
			
			BufferedWriter bw = new BufferedWriter(fw);
			for(int i = 0;i<input.size();i++){
				bw.write(input.get(i)+"\n");
			}
			bw.close();
			System.out.println("FINISHED!");
		} catch(IOException e){
			e.printStackTrace();
		}
			
	}
}
