package nlp;

public class Word {
	public String word;
	public String gramClass;
	
	Word()
	{
		word="";
		gramClass="";
	}
	
	Word(String w, String g)
	{
		word = w;
		gramClass = g;
	}
	
	public String toString() {
		return word + "(" + gramClass + ")";
	}
	
}
