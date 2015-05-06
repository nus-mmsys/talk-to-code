package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

import nlp.Parser;
import nlp.StanfordParser;
import ast.ASTCreator;

public class ATD {
	private ArrayList<ArrayList<String>> _testCases;
	private ArrayList<Boolean> _ignoreCases;
	private int _caseCtr;
	private ConsoleLogger cL;
	
	public ATD(String testPath, ConsoleLogger c) throws IOException
	{
		
		_testCases = new ArrayList<ArrayList<String>>();
		_ignoreCases = new ArrayList<Boolean>();
		//18
		
		for(int i = 0; i<132; i++)
		{
			if(i<0)
				_ignoreCases.add(true);
			else
				_ignoreCases.add(false);
		}
		_caseCtr = 0;
		FileReader fr = new FileReader(testPath);
		BufferedReader br = new BufferedReader(fr);
		String newLine = "";
		while(true)
		{
			ArrayList<String> x = new ArrayList<String>();
			newLine = br.readLine();
			if(newLine == null)
				break;
			if(!newLine.equals(""))
			{
				x.add(newLine);
				_testCases.add(x);
			}
		}
		br.close();
		cL = c;
	}
	
	public void test() throws IOException
	{
		
		Parser p = new StanfordParser();
		for(ArrayList<String> s:_testCases)
		{
			if(!_ignoreCases.get(_caseCtr))
			{
				ASTCreator ast = new ASTCreator(cL);
				ast.constructAST(p.getSentences(s));
				String output = ast.print();
				output = output.concat("\n\nLog\n");
				output = output.concat(cL.getLog());
				writeToFile("C://Users//User//Documents//FYP//FYPTest//output"+_caseCtr+".txt", output);
			}
			_caseCtr++;
			cL.clear();
		}	
		
	}	
	
	public void writeToFile(String path, String text) throws IOException
	{

			FileWriter write = new FileWriter(path, false);
			PrintWriter print_line = new PrintWriter(write);
			print_line.print(text);
			print_line.close();
	}
	
	
	
	
	
}
