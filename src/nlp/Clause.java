package nlp;

import java.util.ArrayList;

public class Clause {
	public ArrayList<Word> words;
	public String clauseName;
	
	Clause(ArrayList<Word> list, String name)
	{
		words = list;
		clauseName = name;
	}
}
