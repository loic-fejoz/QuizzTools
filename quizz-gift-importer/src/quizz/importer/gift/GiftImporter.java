/**
 * quizz-plugin-gift-importer
 * 2009 RealTime-at-Work
 * @author Loïc Fejoz
 */
package quizz.importer.gift;

import quizz.Answer;
import quizz.Question;
import quizz.Quizz;
import quizz.QuizzFactory;

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
	
	protected int skipWhiteSpace(final String input, final int start) {
		int i = start;
		while(i <input.length() && Character.isSpaceChar(input.charAt(i))) {
			i++;
		}
		return i;
	}
	
	public Question readQuestion(final String input) {
		return readQuestion(input, 0).q;
	}
	
	protected PairOfQuestionAndIndex readQuestion(final String input, final int start) {
		int i = start;
		int j = start;
		Question result = factory.createQuestion();
		if (input.startsWith("::")) {
			// Read title text
			i = j = 2;
			for(; i < input.length() && input.charAt(i) != ':'; i++) {};
			result.setTitle(input.substring(j, i).trim());
			j = i + 2;
		}
		
		// Read question text
		for(; i < input.length() && input.charAt(i) != '{'; i++) {};
		result.setText(input.substring(j, i).trim());
		j = i;
		
		// Read answers
		Answer ans;
		while(true) {
			ans = factory.createAnswer();
			// Skip characters until =(true) or ~(false)
			for(; i < input.length() && input.charAt(i) != '}' && input.charAt(i) != '~' && input.charAt(i) != '='; i++) {};
			if (i >= input.length()) {
				return new PairOfQuestionAndIndex(null, i);
			}
			if (input.charAt(i) == '}') {
				break;
			}
			j = i+1;
			if (input.charAt(i) == '~') {
				ans.setCorrect(false);
				i++;
			}
			if (input.charAt(i) == '=') {
				ans.setCorrect(true);
				i++;
			}
			// Read answer's text.
			for(; i < input.length() && input.charAt(i) != '}' && input.charAt(i) != '\r' && input.charAt(i) != '\n'; i++) {};
			ans.setText(input.substring(j, i).trim());
			result.getAnswer().add(ans);
		}
		
		return new PairOfQuestionAndIndex(result, i);
	}

	public Quizz readQuizz(final String input) {
		final Quizz result = factory.createQuizz();
		PairOfQuestionAndIndex qi = new PairOfQuestionAndIndex(null, 0);
		while(qi.index < input.length()) {
			qi = readQuestion(input, qi.index);
			if (qi.q != null) {
				result.getQuestion().add(qi.q);
			}
			qi.index++; // = skipWhiteSpace(input, qi.index);
		}
		return result;
	}

}
