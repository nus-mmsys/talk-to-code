package nlp;

public class GrammarRelation {
	public Word word1;
	public Word word2;
	public String relation;
	
	GrammarRelation(Word w1, Word w2, String r)
	{
		word1 = w1;
		word2 = w2;
		relation = r;
	}
	
	public boolean hasWord1(String w1, String name)
	{
		if(w1.toLowerCase().equals(word1.word.toLowerCase()))
			if(name.equals(relation))
				return true;
		return false;
	}
	
	public boolean hasWord2(String w2, String name)
	{
		if(w2.toLowerCase().equals(word2.word.toLowerCase()))
			if(name.equals(relation))
				return true;
		return false;
	}
	
	public String toString() {
		return word1 + " with " + word2 + " has relation " + relation;
	}
	
}
