package nlp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations;
import edu.stanford.nlp.util.*;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations;
import edu.stanford.nlp.semgraph.SemanticGraphEdge;

public class StanfordParser implements Parser {

	public ArrayList<Sentence> getSentences(ArrayList<String> textInput) {
		ArrayList<Sentence> sents = new ArrayList<Sentence>();
		Properties props = new Properties();
		props.put("annotators", "tokenize, ssplit, pos, parse");
		StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
		for(String s:textInput)
		{
			Annotation annotation = new Annotation(s);
			pipeline.annotate(annotation);
			List<CoreMap> sentences = annotation
					.get(CoreAnnotations.SentencesAnnotation.class);
			ArrayList<Tree> treeList = new ArrayList<Tree>();
			for (int i = 0; i < sentences.size(); i++) 
			{
				if (sentences != null && sentences.size() > 0) {
					ArrayCoreMap sentence = (ArrayCoreMap) sentences.get(i);
					Tree tree = sentence.get(TreeCoreAnnotations.TreeAnnotation.class);
					ArrayList<Clause> c = getClauses(tree);
					ArrayList<Word> words = getWordList(tree);
					SemanticGraph sg = sentence.get(SemanticGraphCoreAnnotations.CollapsedCCProcessedDependenciesAnnotation.class);
					ArrayList<GrammarRelation> relations = getRelationList(sg);
					sents.add(new Sentence(words, relations, c));
				}
			}
		}
		return sents;
		
	}
	
	public ArrayList<Clause> getClauses(Tree t)
	{
		ArrayList<Clause> retList = new ArrayList<Clause>();
		for(Tree subTree: t)
		{
			if(subTree.label().value().equals("S"))
			{
				for(Tree tree:subTree.children())
				{
					retList.add(getLeavesOfRoot(tree));
				}
				break;
			}
		}
		return retList;
	}
	
	public Clause getLeavesOfRoot(Tree tree)
	{
		ArrayList<Word> retList = new ArrayList<Word>();
		for(Tree t: tree.getLeaves())
			retList.add(new Word(t.label().value(), t.parent(tree).label().value()));
		return new Clause(retList, tree.label().value());
	}
	
	public ArrayList<Word> getWordList(Tree t)
	{
		ArrayList<Word>	retList = new ArrayList<Word>();
		for(Tree tree:t.getLeaves())
		{
			retList.add(new Word(tree.label().value(), tree.parent(t).label().value()));
		}
		return retList;
	}
	
	public ArrayList<GrammarRelation> getRelationList(SemanticGraph s)
	{
		ArrayList<GrammarRelation> retList = new ArrayList<GrammarRelation>();
		for(SemanticGraphEdge e:s.edgeListSorted())
		{
			retList.add(new GrammarRelation(new Word(e.getGovernor().value(), e.getGovernor().tag()), new Word(e.getDependent().value(), e.getDependent().tag()), e.getRelation().toString()));
			//System.out.println(e.getRelation().toString());
		}
		return retList;
	}
}
