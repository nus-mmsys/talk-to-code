package ASTTest;

import static org.junit.Assert.*;
import java.util.*;


import org.junit.Test;

import ast.ASTParser;

import java.io.*;
public class CreateVariableTest {
	private static ASTParser parser;
	@Test
	public void testCreateVariable() {
		try {
			InputStream in = new FileInputStream(new File("input.txt"));
			parser = new ASTParser(in);
			InputStream out = new FileInputStream(new File("output.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(out));
			ArrayList<String> expectedOutput = new ArrayList<String>();
			String temp;
			int count = 0;
			while((temp=br.readLine())!=null){
				expectedOutput.add(temp);
				count++;
			}
			int testNo = 0;
			while(testNo!=count){
				try {
					assertEquals(testNo+" "+expectedOutput.get(testNo),testNo+" "+parser.statement().toSyntax());
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
