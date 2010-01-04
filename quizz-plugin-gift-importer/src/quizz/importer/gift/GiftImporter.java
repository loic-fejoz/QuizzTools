/**
 * quizz-plugin-gift-importer
 * 2009 RealTime-at-Work
 * @author Loïc Fejoz
 */
package quizz.importer.gift;

import quizz.Answer;
import quizz.Question;
import quizz.QuizzFactory;

/**
 * @author Loïc Fejoz
 *
 */
public class GiftImporter {
	
	protected QuizzFactory factory;

	/**
	 * 
	 */
	public GiftImporter() {
		this(QuizzFactory.eINSTANCE);
	}
	
	public GiftImporter(QuizzFactory factory) {
		this.factory = factory;
	}
	
	public Question readQuestion(final String input) {
		int i = 0;
		int j = 0;
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
		Answer ans = factory.createAnswer();
		while(true) {
			for(; i < input.length() && input.charAt(i) != '}' && input.charAt(i) != '~' && input.charAt(i) != '='; i++) {};
			if (input.charAt(i) == '}') {
				break;
			}
		}
		
		
		return result;
	}

}
