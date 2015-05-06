package nlp;

import java.util.ArrayList;

public class Sentence {
	public ArrayList<Word> words;
	public ArrayList<GrammarRelation> relations;
	public ArrayList<Clause> clauses;
	public String fullSentence;
	
	Sentence(ArrayList<Word> w, ArrayList<GrammarRelation> r, ArrayList<Clause> c)
	{
		words = w;
		relations = r;
		clauses = c;
		String x = "";
		for(Word w1:words)
			x = x.concat(w1.word+" ");
		x.trim();
		x = x.substring(0, x.length()-3);
		x = x.concat(".");
		fullSentence = x;
	}
	
	Sentence(ArrayList<Word> w)
	{
		words = w;
		relations = new ArrayList<GrammarRelation>();
		clauses = new ArrayList<Clause>();
	}
	
	public ArrayList<Word> getPosTagListFromClause(String POSTag, int indx)
	{
		ArrayList<Word> retList = new ArrayList<Word>();
		for(Word w:clauses.get(indx).words)
			if(w.gramClass.equals(POSTag))
				retList.add(w);
		return retList;
	}
	
	public ArrayList<Word> getPosTagList(String POStag)
	{
		ArrayList<Word> retList = new ArrayList<Word>();
		for(Word w: words)
		{
			if(w.gramClass.equals(POStag))
				retList.add(w);
		}
		return retList;
	}
	
	public String findRelation(Word w, String name)
	{
		for(GrammarRelation r:relations)
		{
			if(r.hasWord1(w.word, name))
			{
				return r.word2.word;
			}		
		}
		return null;
	}
	
	public String findWord2InRelation(String w, String name)
	{
		for(GrammarRelation r: relations)
		{
			if(r.hasWord1(w, name))
			{
				return r.word2.word;
			}
		}
		return null;
		
	}
	
	public String findWord1InRelation(String w, String name)
	{
		for(GrammarRelation r:relations)
		{
			if(r.hasWord2(w, name))
			{
				return r.word1.word;
			}
		}
		return null;
	}
	
	public String print()
	{
		String s = "";
		for(Word w:words)
		{
			s = s.concat(w.word+" ");
		}
		return s;
	}
	
	public String returnWordElement(String w, int displacement)
	{
		int i = 0;
		for(Word w1:words)
		{
			if(w1.word.equals(w))
				if(i+displacement>=0)
					return words.get(i+displacement).word;
				else
					return null;
			i++;			
		}
		
		return null;	
	}
	
	public boolean find(String w)
	{
		for(Word w1:words)
		{
			if(w1.word.toLowerCase().equals(w.toLowerCase()))
				return true;
		}
		return false;
	}
	
	public boolean findPhrase(String p)
	{
		if(fullSentence.contains(p))
			return true;
		return false;
	}
	
	
}
