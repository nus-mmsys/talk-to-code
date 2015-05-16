package nlp;

import java.util.ArrayList;

public interface Parser {
	ArrayList<Sentence> getSentences(ArrayList<String> textInput);
}
