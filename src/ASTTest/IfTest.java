package ASTTest;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.junit.Test;

import ast.ASTParser;

import junit.framework.TestCase;

public class IfTest extends TestCase {
	//private static ASTParser parser;
	private static ASTTestInputProcessor pro = new ASTTestInputProcessor();
	@Test
	public void testIf() {
		try {
			InputStream in = new FileInputStream(new File("Ifinput.txt"));
			//parser = new ASTParser(in);
			InputStream out = new FileInputStream(new File("Ifoutput.txt"));
			pro.parse("Ifinput.txt", "ActualOutput.txt");
			InputStream actualOut = new FileInputStream(new File("ActualOutput.txt"));
			BufferedReader br1 = new BufferedReader(new InputStreamReader(out));
			BufferedReader br2 = new BufferedReader(new InputStreamReader(actualOut));
			ArrayList<String> expectedOutput = new ArrayList<String>();
			ArrayList<String> actualOutput = new ArrayList<String>();
			String temp;
			int count = 0;
			while((temp=br1.readLine())!=null){
				expectedOutput.add(temp);
				count++;
			}
			while((temp=br2.readLine())!=null){
				actualOutput.add(temp);
			}
			int testNo = 0;
			while(testNo!=count){
				try {
					
					//System.out.println(parser.statement().print());
					assertEquals(testNo+" "+expectedOutput.get(testNo),testNo+" "+actualOutput.get(testNo));
					testNo++;
				} catch (Exception ex){
					ex.printStackTrace();
				}
			}
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}
