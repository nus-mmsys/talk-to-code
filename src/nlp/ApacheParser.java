package nlp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTagger;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InvalidFormatException;

public class ApacheParser implements Parser {

	public ArrayList<Sentence> getSentences(ArrayList<String> textInput) {
		ArrayList<Sentence> retList = new ArrayList<Sentence>();
		try {
			InputStream is;
			is = new FileInputStream("en-sent.bin");
			SentenceModel model = new SentenceModel(is);
			SentenceDetectorME sdetector = new SentenceDetectorME(model);
			is.close();

			InputStream ts = new FileInputStream("en-token.bin");
			TokenizerModel tokenModel = new TokenizerModel(ts);
			Tokenizer tokenizer = new TokenizerME(tokenModel);
			ts.close();

			InputStream ps = new FileInputStream("en-pos-maxent.bin");
			POSModel posModel = new POSModel(ps);
			POSTagger posTagger = new POSTaggerME(posModel);
			ps.close();

			String sentences[] = sdetector.sentDetect(textInput.get(0));

			for (String s : sentences) {
				ArrayList<Word> words = new ArrayList<Word>();
				String tokens[] = tokenizer.tokenize(s);
				String tags[] = posTagger.tag(tokens);
				for (int i = 0; i < tokens.length; i++)
					words.add(new Word(tokens[i], tags[i]));
				retList.add(new Sentence(words));
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}

}
