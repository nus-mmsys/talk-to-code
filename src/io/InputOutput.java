package io;

import java.io.BufferedReader;
import utils.Constants;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import ast.ASTCreator;
import nlp.Parser;
import nlp.StanfordParser;


public class InputOutput{
	public static void main(String[] args) throws IOException
	{
		ConsoleLogger cL = new ConsoleLogger();
		ATD atd = new ATD(Constants.SUPPORTED_CLAUSES, cL);
		if(atd!=null)
		{
			ArrayList<String> textInput = getTextInput(Constants.INPUTFILE);
			Parser p = new StanfordParser();
			ASTCreator ast = new ASTCreator(cL);
			ast.constructAST(p.getSentences(textInput));
			String output = ast.print();
			System.out.println(output);
			writeToFile(Constants.OUTPUTFILE, output);
			cL.writeToFile();
		}
		else
		{
			atd.test();
		}
	}
	
	public static ArrayList<String> getTextInput(String path) throws IOException
	{
		ArrayList<String> retList = new ArrayList<String>();
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		String lines = "";
		String newLine = "";
		while(true)
		{
			newLine = br.readLine();
			if(newLine == null)
				break;	
			lines = lines.concat(newLine);
			retList.add(lines.trim());
			lines = "";
		}
		br.close();
		return retList;
	}
	
	public static void writeToFile(String path, String text) throws IOException
	{
		FileWriter write = new FileWriter(path, false);
		PrintWriter print_line = new PrintWriter(write);
		print_line.print(text);
		print_line.close();
	}
}
