package ASTTest;
import java.io.*;
import ast.*;
import ast.ASTParser;
import java.util.*;
public class ASTTestInputProcessor {
	private ASTParser parser;
	public static void main(String[] args){
		//parse("Ifinput.txt","Ifoutput.txt");
	}
	public ASTTestInputProcessor(){
		
	}
	protected void parse(String inputPath,String outputPath){
		try {
			InputStream in = new FileInputStream(new File(inputPath));
			//InputStream in = new FileInputStream(new File("Compoundinput.txt"));
			//InputStream in = new FileInputStream(new File("Postfixinput.txt"));
			//InputStream in = new FileInputStream(new File("Prefixinput.txt"));
			//InputStream in = new FileInputStream(new File("Assignmentinput.txt"));
			//InputStream in = new FileInputStream(new File("input.txt"));
			this.parser = new ASTParser(in);
			//File outputFile = new File("output.txt");
			//File outputFile = new File("Assignmentoutput.txt");
			//File outputFile = new File("Prefixoutput.txt");
			//File outputFile = new File("Postfixoutput.txt");
			//File outputFile = new File("Compoundoutput.txt");
			File outputFile = new File(outputPath);
			if(!outputFile.exists()){
				outputFile.createNewFile();
			}
			FileWriter fw = new FileWriter(outputFile.getAbsoluteFile());
			ArrayList<String> result = new ArrayList<String>();
			BufferedWriter bw = new BufferedWriter(fw);
			try {
				int i = 0;
				while(i<10000){
					ASTNode temp = parser.statement();
					result.add(temp.toSyntax()+"\n");
					i++;
				}
				System.out.println(result.size());
				for(int j = 0;j<result.size();j++){
					bw.write(result.get(j));
				}
				bw.flush();
				bw.close();
				System.out.println("FINISH");
			} catch (Exception ex){
				ex.printStackTrace();
			}
		} catch (IOException e){
			e.printStackTrace();
		} 
	}
}
