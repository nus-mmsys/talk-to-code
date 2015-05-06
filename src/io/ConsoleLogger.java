package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ConsoleLogger {
	ArrayList<String> consoleLog;
	boolean printToConsole;
	
	public ConsoleLogger()
	{
		consoleLog = new ArrayList<String>();
		printToConsole = true;
	}
	
	public ConsoleLogger(boolean b)
	{
		consoleLog = new ArrayList<String>();
		printToConsole = b;
	}
	
	public void log(String s)
	{
		if(printToConsole)
			System.out.println(s);
		consoleLog.add(s);
	}
	
	public void log(String s, boolean b)
	{
		if(b)
			System.out.println(s);
		consoleLog.add(s);
	}
	
	public void writeToLog() throws IOException
	{
		FileWriter write = new FileWriter("C:/Users/User/Documents/log.txt", false);
		PrintWriter print_line = new PrintWriter(write);
		for(int i = 0; i<consoleLog.size();i++)
		{
			print_line.printf("%s" + "%n", consoleLog.get(i));
		}
		print_line.close();		
	}
	
	public void writeToFile() throws IOException
	{
		FileWriter write = new FileWriter("C:/Users/User/Documents/log.txt", false);
		PrintWriter print_line = new PrintWriter(write);
		String text = "";
		for(String a:consoleLog)
			text = text.concat(a).concat("\n");
		print_line.print(text);
		print_line.close();
	}
	
	public String getLog()
	{
		String retString = "";
		for(String s:consoleLog)
			retString = retString.concat(s+"\n");
		return retString;
	}
	
	public void clear()
	{
		consoleLog.clear();
	}
}
