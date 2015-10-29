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
	private static final int MAX_CALUSE_NO = 5;
	private static final int MAX_NESTED_LAYER = 3;
	private static final int INDEX_CREATE_VARIABLE = 0;
	private static final int INDEX_ASSIGNMENT = 1;
	private static final int INDEX_PREFIX = 2;
	private static final int INDEX_POSTFIX = 3;
	private static final int INDEX_COMPOUND = 4;
	private static final String[] primitive_types = {"byte","short","int","long","float","double","boolean","char","String"};
	private static final String[] prefix_operators = {"#pre_inc","#pre_dec","#not"};
	private static final String[] postfix_operators = {"#post_inc","#post_dec"};
	private static final String[] infix_operators = {"#plus","#minus","#multiply","#divide","#less_than","#greater_than","#equal","#less_equal","#greater_equal",
													 "#not_equal","#or","#and","#bit_and","#bit_or","#bit_xor","#mod","#shift_left","#shift_right","#shift_right_zero"};
	private static final String[] compound_operators = {"#plus_equal","#minus_equal","#multiply_equal","#divide_equal","#mod_equal","#and_equal","#or_equal","#xor_equal"};
	private static final String[] reserved_words = {"abstract","assert","boolean","break","byte","case","catch","char","class","const",
			"continue","default","do","double","else","enum","extends","false","final","finally","float","for","goto","if","implements","import","instanceof","int","interface",
			"long","native","new","null","package","private","protected","public","return","short","static","strictfp","super","switch","synchronized","this","throw","throws","transient","true","try","void","volatile","while"};
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		init();
		int input = sc.nextInt();
		//ArrayList<String> inputs = generateCreateVariable(input);
		//ArrayList<String> inputs = generateAssignment(input);
		//ArrayList<String> inputs = generatePurePrefix(input);
		//ArrayList<String> inputs = generatePurePostfix(input);
		//ArrayList<String> inputs = generateCompound(input);
		ArrayList<String> inputs = generateIfStatements(input);
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
			if(k!=34&&k!=39&&k!=63){
				if(k == 92){
					//legalCharacters.add("\\");
				}
				else{
					legalCharacters.add(String.valueOf((char)k));
				}
			}
		}

		legalCharacters.add("");
	}
	private static String randomVariableName(int length){
		String output = "";
		Random ran = new Random();
		for(int i = 0; i<length;i++){
			if(i == 0) {
				while(legalLiterals.get(Math.abs(ran.nextInt()%legalLiterals.size())).equals("")){
					output+=legalLiterals.get(Math.abs(ran.nextInt()%legalLiterals.size()));
				}
				output+=legalLiterals.get(Math.abs(ran.nextInt()%legalLiterals.size()));
			} else {
				if(ran.nextInt()%2 == 0){
					output+=numberLiterals.get(Math.abs(ran.nextInt()%10));
				} else {
					while(legalLiterals.get(Math.abs(ran.nextInt()%legalLiterals.size())).equals("")){
						output+=legalLiterals.get(Math.abs(ran.nextInt()%legalLiterals.size()));
					}
					output+=legalLiterals.get(Math.abs(ran.nextInt()%legalLiterals.size()));
				}
			}
		}
		output = reservedWordDetection(output);
		return output;
	}
	private static String reservedWordDetection(String input){
		String output = input;
		for(int i = 0;i<reserved_words.length;i++){
			if(input.trim().equals(reserved_words[i])){
				output = input.trim()+"_var";
			}
		}
		return output;
	}
	private static String randomStringLiteral(int length){
		String output = "\"";
		Random ran = new Random();
		for(int i = 0;i<length;i++){
			String temp = legalCharacters.get(Math.abs(ran.nextInt()%legalCharacters.size()));
			while (temp.equals("\\")||temp.equals("")){
				temp=legalCharacters.get(Math.abs(ran.nextInt()%legalCharacters.size()));
			}
			output+=temp;
		}
		output+="\"";
		return output;
	}
	private static String randomCharacter(){
		String output = "\'";
		Random ran = new Random();
		String temp = legalCharacters.get(Math.abs(ran.nextInt()%legalCharacters.size()));
		while(temp.equals("\\")||temp.equals("")){
			temp=legalCharacters.get(Math.abs(ran.nextInt()%legalCharacters.size()));
		}
		output+=temp;
		output+="\'";
		return output;
	}
	private static String randomInt(){
		String output = "";
		Random ran = new Random();
		output+=String.valueOf(Math.abs(ran.nextInt()));
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
		output+=String.valueOf(Math.abs(ran.nextInt()%32768));
		return output;
	}
	private static String randomLong(){
		String output = "";
		Random ran = new Random();
		output+= String.valueOf(Math.abs(ran.nextLong()));
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
	private static ArrayList<String> generateCompound(int no){
		ArrayList<String> output = new ArrayList<String>();
		Random ran = new Random();
		
		for(int i = 0; i<no;i++){
			String temp = "";
			temp += generateVariableInput(ran);
			temp += " "+compound_operators[Math.abs(ran.nextInt()%compound_operators.length)]+" ";
			temp += generateExpression(ran);
			output.add(temp+";;");
		}
		return output;
	}
	private static ArrayList<String> generatePurePrefix(int no){
		ArrayList<String> output = new ArrayList<String>();
		Random ran = new Random();
		
		for(int i = 0; i<no;i++){
			output.add(generatePrefix(ran)+";;");
		}
		return output;
	}
	private static ArrayList<String> generatePurePostfix(int no){
		ArrayList<String> output = new ArrayList<String>();
		Random ran = new Random();
		
		for(int i = 0; i<no;i++){
			output.add(generatePostfix(ran)+";;");
		}
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
	private static ArrayList<String> generateAssignment(int no){
		ArrayList<String> output = new ArrayList<String>();
		Random ran = new Random();
		for(int i = 0;i<no;i++){
			String generatedInput = "";
			generatedInput +="#assign";
			generatedInput += generateVariableInput(ran);
			generatedInput +=" #with ";
			int values = Math.abs(ran.nextInt()%3);
			switch (values){
			case 0:
			{
				generatedInput += generateValue(ran, Math.abs(ran.nextInt()%primitive_types.length));
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
		int type = Math.abs(ran.nextInt()%3);
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
			output += randomVariableName(Math.abs(ran.nextInt()%MAX_VAR_LENGTH)+1);
			output += " ";
		}
		return output;
	}
	private static String generatePostfix(Random ran){
		String output = "";
		output+="#post #variable ";
		output+= randomVariableName(Math.abs(ran.nextInt()%MAX_VAR_LENGTH)+1);
		output+=" ";
		int index = Math.abs(ran.nextInt()%postfix_operators.length);
		output += postfix_operators[index];
		output+= " ";
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
		output += " ";
		for(int i = 1;i<length;i++){
			boolean isQuoted = ran.nextBoolean();
			if(isQuoted){
				output = "("+output;
			}
			output += infix_operators[Math.abs(ran.nextInt()%infix_operators.length)];
			output += " ";
			isValue = ran.nextBoolean();
			if(isValue){
				output += generateValue(ran,Math.abs(ran.nextInt()%primitive_types.length));
			}else {
				output += generateVariableInput(ran);
			}
			output += " ";
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
	private static String generateSingleStatement(int type){
		Random ran = new Random();
		String output = "";
		switch(type){
		case INDEX_CREATE_VARIABLE:
		{
			output = generateCreateVariable(1).get(0);
			break;
		}
		case INDEX_ASSIGNMENT :{	
			output = generateAssignment(1).get(0);
			break;
		}
		case INDEX_PREFIX: {
			output = generatePurePrefix(1).get(0);
			break;
			
		}
		case INDEX_POSTFIX:{
			output = generatePurePostfix(1).get(0);
			break;
		}
		case INDEX_COMPOUND:{
			output = generateCompound(1).get(0);
			break;
		}
		}
		return output;
	}
	private static ArrayList<String> generateIfStatements(int no){
		ArrayList<String> output = new ArrayList<String>();
		Random ran = new Random();
		for(int i = 0;i<no;i++){
			int layer = Math.abs(ran.nextInt()%MAX_NESTED_LAYER);
			output.add(generateIfStatment(layer));
		}
		return output;
	}
	private static String generateIfStatment(int layer){
		Random ran = new Random();
		int type;
		String output = "";
		output += "if #condition ";
		output += generateExpression(ran);
		output += " #if_branch_start ";
		boolean isNested;
		int caluse = Math.abs(ran.nextInt()%MAX_CALUSE_NO);
		for(int i = 0;i<caluse;i++){
			isNested = ran.nextBoolean();
			if(isNested){
				if(layer!=0){
					output += generateIfStatment(layer--);
				}
			} else {
				type = Math.abs(ran.nextInt()%INDEX_COMPOUND);
				output+= generateSingleStatement(type);
			}
		}
		output += " #if_branch_end";
		boolean hasElse = ran.nextBoolean();
		if(hasElse){
			output += " #else_branch_start ";
			caluse = Math.abs(ran.nextInt()%MAX_CALUSE_NO);
			for(int i = 0;i<caluse;i++){
				isNested = ran.nextBoolean();
				if(isNested){
					if(layer != 0)
						output += generateIfStatment(layer--);
				} else {
					type = Math.abs(ran.nextInt()%INDEX_COMPOUND);
					output+= generateSingleStatement(type);
				}
			}
			output += " #else_branch_end ";
		}
		output += ";;";
		return output;
	}
	private static void outputToFile(ArrayList<String> input){
		try{
			File inputFile = new File("Ifinput.txt");
			//File inputFile = new File("Compoundinput.txt");
			//File inputFile = new File("Postfixinput.txt");
			//File inputFile = new File("Prefixinput.txt");
			//File inputFile = new File("input.txt");
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
