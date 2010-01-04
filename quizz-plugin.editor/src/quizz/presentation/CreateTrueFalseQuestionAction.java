/**
 * quizz-plugin.editor
 * 2009 RealTime-at-Work
 * @author Loïc Fejoz
 */
package quizz.presentation;

import org.eclipse.jface.action.Action;

import quizz.Answer;
import quizz.Question;
import quizz.Quizz;
import quizz.QuizzFactory;

/**
 * @author Loïc Fejoz
 *
 */
public class CreateTrueFalseQuestionAction extends Action {

	private Quizz quizz; 
	
	/**
	 * 
	 */
	public CreateTrueFalseQuestionAction(Quizz quizz) {
		super("True/False question");
		this.quizz = quizz;
	}
	
	@Override
	public void run() {
		final Answer trueAnswer = QuizzFactory.eINSTANCE.createAnswer();
		trueAnswer.setText("TRUE");
		trueAnswer.setCorrect(false);
		final Answer falseAnswer = QuizzFactory.eINSTANCE.createAnswer();
		falseAnswer.setText("FALSE");
		falseAnswer.setCorrect(false);
		final Question q = QuizzFactory.eINSTANCE.createQuestion();
		q.getAnswer().add(trueAnswer);
		q.getAnswer().add(falseAnswer);
		quizz.getQuestion().add(q);
	}

}
