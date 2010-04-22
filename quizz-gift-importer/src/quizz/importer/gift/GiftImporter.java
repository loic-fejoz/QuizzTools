/**
 * quizz-plugin-gift-importer
 * 2009 RealTime-at-Work
 * @author Loïc Fejoz
 */
package quizz.importer.gift;

import java.io.Reader;

import quizz.Answer;
import quizz.Question;
import quizz.Quizz;
import quizz.QuizzFactory;
import quizz.TextFormat;
import quizz.util.CharStream;
import quizz.util.ReaderCharStreamImpl;
import quizz.util.StringCharStreamImpl;

/**
 * @author Loïc Fejoz
 *
 */
public class GiftImporter {
	
	protected QuizzFactory factory;

	protected static class PairOfQuestionAndIndex {
		public Question q;
		public int index;
		
		public PairOfQuestionAndIndex(final Question q, final int i) {
			this.q = q;
			index = i;
		}
	}
	
	/**
	 * 
	 */
	public GiftImporter() {
		this(QuizzFactory.eINSTANCE);
	}
	
	public GiftImporter(QuizzFactory factory) {
		this.factory = factory;
	}
	
	public Question readQuestion(final Reader input) {
		return readQuestion(new ReaderCharStreamImpl(input));
	}
	
	public Question readQuestion(final String input) {
		return readQuestion(new StringCharStreamImpl(input));
	}
	
	protected void skipWhiteSpace(final CharStream cs) {
		while(cs.available() && Character.isWhitespace(cs.charAt(0))) {
			cs.skip();
		}
	}
	
	protected Question readQuestion(final CharStream cs) {
		Question result = factory.createQuestion();
		skipWhiteSpace(cs);
		if (cs.startsWith("//")) {
			// Skip comment
			cs.skip(2);
			for(; cs.available() && cs.charAt(0) != '\n'; cs.skip()) {};
		}
		cs.setMark();
		if (cs.startsWith("::")) {
			// Read title text
			cs.skip(2);
			cs.setMark();
			for(; cs.available() && cs.charAt(0) != ':'; cs.skip()) {};
			result.setTitle(cs.getFromMark().trim());
			cs.skip(2);
		}
		if (cs.startsWith("[html]")) {
			cs.skip(6);
			result.setTextFormat(TextFormat.HTML);
		}
		cs.setMark();
		
		// Read question text
		for(; cs.available() && cs.charAt(0) != '{'; cs.skip()) {};
		result.setText(cs.getFromMark().trim());
		cs.setMark();
		
		// Skip characters until after '{'
		for(; cs.available() && cs.charAt(0) != '{'; cs.skip()) {};
		cs.skip();
		
		// Read answers
		Answer ans;
		while(true) {
			ans = factory.createAnswer();
			// Skip whitespaces
			skipWhiteSpace(cs);
			if (cs.startsWith("T")) {
				ans.setCorrect(true);
				ans.setText("True");
				Answer other = factory.createAnswer();
				other.setCorrect(false);
				other.setText("False");
				result.getAnswer().add(ans);
				result.getAnswer().add(other);
				cs.skip(1); // Skip T
				if (cs.available() && cs.charAt(0) == 'R') {
					cs.skip(3); // skip RUE
				}
			}
			if (cs.startsWith("F")) {
				Answer other = factory.createAnswer();
				other.setCorrect(false);
				other.setText("True");
				ans.setCorrect(true);
				ans.setText("False");
				result.getAnswer().add(other);
				result.getAnswer().add(ans);
				cs.skip(1); // Skip F
				if (cs.available() && cs.charAt(0) == 'A') {
					cs.skip(4); // skip ALSE
				}
			}
			
			// Skip characters until =(true) or ~(false)
			for(; cs.available() && cs.charAt(0) != '}' && cs.charAt(0) != '~' && cs.charAt(0) != '='; cs.skip()) {};
			if (!cs.available()) {
				return null;
			}
			if (cs.charAt(0) == '}') {
				cs.skip();
				break;
			}
			if (cs.charAt(0) == '~') {
				ans.setCorrect(false);
				cs.skip();
			}
			if (cs.charAt(0) == '=') {
				ans.setCorrect(true);
				cs.skip();
			}
			cs.setMark();
			// Read answer's text.
			for(; cs.available() && cs.charAt(0) != '}' && cs.charAt(0) != '\r' && cs.charAt(0) != '\n' && cs.charAt(0) != '#'; cs.skip()) {};
			ans.setText(cs.getFromMark().trim());
			
			// Read feedback.
			if (cs.charAt(0) == '#') {
				cs.skip();
			}
			cs.setMark();
			for(; cs.available() && cs.charAt(0) != '}' && cs.charAt(0) != '\r' && cs.charAt(0) != '\n'; cs.skip()) {};
			ans.setFeedback(cs.getFromMark().trim());
			
			result.getAnswer().add(ans);
		}
		
		return result;
	}

	public Quizz readQuizz(final String input) {
		return readQuizz(new StringCharStreamImpl(input));
	}
	
	public Quizz readQuizz(final Reader input) {
		return readQuizz(new ReaderCharStreamImpl(input));
	}
	
	protected Quizz readQuizz(final CharStream cs) {	
		final Quizz result = factory.createQuizz();
		Question q;
		while(cs.available()) {
			q = readQuestion(cs);
			if (q != null) {
				result.getQuestion().add(q);
			}
		}
		return result;
	}

}
