package quizz.importer.gift;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import quizz.Answer;
import quizz.Question;
import quizz.Quizz;
import quizz.TextFormat;

public class GiftImporterTest {
	
	protected GiftImporter importer;

	@Before
	public void setUp() throws Exception {
		importer = new GiftImporter();
	}
	
	@Test
	public void testSimpleQuestionWithoutTitle() {
		final String questionText = "Which answer equals 5?";
		final String ansText1 = "2 + 2";
		final String ansText2 = "2 + 3";
		final String ansText3 = "2 + 4";
		Question q = importer.readQuestion(questionText + " {\n" +
				"~ "+ ansText1 + "\n" +
				"= "+ ansText2 + "\n" +
				"~ "+ ansText3 + "\n" +
				"}");
		assertNotNull(q);
		//System.out.println(q.toString());
		assertEquals(questionText, q.getText());
		assertEquals(null, q.getTitle());
		assertNotNull(q.getAnswer());
		assertEquals(3, q.getAnswer().size());
		assertEquals(ansText1, q.getAnswer().get(0).getText());
		assertFalse(q.getAnswer().get(0).isCorrect());
		assertEquals(ansText2, q.getAnswer().get(1).getText());
		assertTrue(q.getAnswer().get(1).isCorrect());
		assertEquals(ansText3, q.getAnswer().get(2).getText());
		assertFalse(q.getAnswer().get(2).isCorrect());
		
	}
	
	@Test
	public void testSimpleQuestionWithTitle() {
		final String questionTitle = "Simple arithmetic";
		final String questionText = "Which answer equals 5?";
		final String ansText1 = "2 + 2";
		final String ansText2 = "2 + 3";
		final String ansText3 = "2 + 4";
		Question q = importer.readQuestion("::" + questionTitle + "::" + questionText + " {\n" +
				"~ "+ ansText1 + "\n" +
				"= "+ ansText2 + "\n" +
				"= "+ ansText3 + "\n" +
				"}");
		assertEquals(questionText, q.getText());
		assertEquals(questionTitle, q.getTitle());
		assertNotNull(q.getAnswer());
		assertEquals(3, q.getAnswer().size());
		assertEquals(ansText1, q.getAnswer().get(0).getText());
		assertEquals(ansText2, q.getAnswer().get(1).getText());
		assertEquals(ansText3, q.getAnswer().get(2).getText());
		
	}
	
	@Test
	public void testImportTwoQuestions() {
		final String question1Text = "Which answer equals 5?";
		final String ans1Text1 = "2 + 2";
		final String ans1Text2 = "2 + 3";
		final String ans1Text3 = "2 + 4";
		final String question2Text = "Which answer equals 6?";
		final String ans2Text1 = "2 + 3";
		final String ans2Text2 = "2 + 4";
		final String ans2Text3 = "2 + 5";
		Quizz q = importer.readQuizz(question1Text + " {\n" +
				"~ "+ ans1Text1 + "\n" +
				"= "+ ans1Text2 + "\n" +
				"~ "+ ans1Text3 + "\n" +
				"}\n" + 
				question2Text + " {\n" +
				"~ "+ ans2Text1 + "\n" +
				"= "+ ans2Text2 + "\n" +
				"~ "+ ans2Text3 + "\n" +
				"}\n");
		assertNotNull(q);
		//System.out.println(q.toString());
		assertEquals(2, q.getQuestion().size());
		final Question q1 = q.getQuestion().get(0);
		assertEquals(question1Text, q1.getText());
		assertEquals(null, q1.getTitle());
		assertNotNull(q1.getAnswer());
		assertEquals(3, q1.getAnswer().size());
		assertEquals(ans1Text1, q1.getAnswer().get(0).getText());
		assertFalse(q1.getAnswer().get(0).isCorrect());
		assertEquals(ans1Text2, q1.getAnswer().get(1).getText());
		assertTrue(q1.getAnswer().get(1).isCorrect());
		assertEquals(ans1Text3, q1.getAnswer().get(2).getText());
		assertFalse(q1.getAnswer().get(2).isCorrect());
		final Question q2 = q.getQuestion().get(1);
		assertEquals(question2Text, q2.getText());
		assertEquals(null, q2.getTitle());
		assertNotNull(q2.getAnswer());
		assertEquals(3, q2.getAnswer().size());
		assertEquals(ans2Text1, q2.getAnswer().get(0).getText());
		assertFalse(q2.getAnswer().get(0).isCorrect());
		assertEquals(ans2Text2, q2.getAnswer().get(1).getText());
		assertTrue(q2.getAnswer().get(1).isCorrect());
		assertEquals(ans2Text3, q2.getAnswer().get(2).getText());
		assertFalse(q2.getAnswer().get(2).isCorrect());
	}

	@Test
	public void testToReadAQuizzThatContainAComment() {
		final String input = "//Quizz: UML 2 certification guide\n" +
				"Which of the following diagram types are defined in UML? {\n" +
				"    =composite structure diagram\n" +
				"    ~Message sequence chart\n" +
				"    ~Data flow diagram\n" +
				"    =Activity diagram\n" +
				"}\n";
		Question q = importer.readQuestion(input);
		assertNotNull(q);
		assertFalse(q.isTrueFalse());
		assertEquals("Which of the following diagram types are defined in UML?", q.getText());
		assertEquals(4, q.getAnswer().size());
		assertEquals("composite structure diagram", q.getAnswer().get(0).getText());
		assertTrue(q.getAnswer().get(0).isCorrect());
		assertEquals("Message sequence chart", q.getAnswer().get(1).getText());
		assertFalse(q.getAnswer().get(1).isCorrect());
		assertEquals("Data flow diagram", q.getAnswer().get(2).getText());
		assertFalse(q.getAnswer().get(2).isCorrect());
		assertEquals("Activity diagram", q.getAnswer().get(3).getText());
		assertTrue(q.getAnswer().get(3).isCorrect());
	}
	
	@Test
	public void testAQuestionThatIsHTMLFormatted() {
		final String input = "[html]<img src=\"\"/> Which statements are correct? {" +
				"    ~The import relationship between Q and P is an ElementImport.\n" +
				"    =B is known in Q.\n" +
				"    =B is known in A.\n" +
				"    ~B is known in C.\n" +
				"    ~P is known in C.\n" +
				"    ~It's possible to define an alias at the import relationship between Q and P." +
				"}";
		final Question q= importer.readQuestion(input);
		assertNotNull(q);
		System.out.println(q.toString());
		assertEquals("<img src=\"\"/> Which statements are correct?", q.getText());
		assertEquals(TextFormat.HTML, q.getTextFormat());
		assertEquals(6, q.getAnswer().size());
		assertEquals("The import relationship between Q and P is an ElementImport.", q.getAnswer().get(0).getText());
		assertEquals("It's possible to define an alias at the import relationship between Q and P.", q.getAnswer().get(5).getText());
	}
	
	@Test
	public void testTrueBooleanQuestionWithOneAnswer() {
		final String questionText = "The importer can import yes/no question?";
		final String input = questionText + " { T }";
		final Question q = importer.readQuestion(input);
		assertNotNull(q);
		assertEquals(questionText, q.getText());
		assertEquals(2, q.getAnswer().size());		
		assertTrue("The question shall be a yes/no question.", q.isTrueFalse());
		final Answer trueAns = q.getAnswer().get(0);
		final Answer falseAns = q.getAnswer().get(1);
		assertTrue(trueAns.isCorrect());
		assertFalse(falseAns.isCorrect());
		assertEquals("True", trueAns.getText());
		assertEquals("False", falseAns.getText());		
	}
	
	@Test
	public void testFalseBooleanQuestionWithOneAnswer() {
		final String questionText = "The importer can completly read Gift?";
		final String input = questionText + " { F }";
		final Question q = importer.readQuestion(input);
		assertNotNull(q);
		assertEquals(questionText, q.getText());
		assertEquals(2, q.getAnswer().size());		
		assertTrue("The question shall be a yes/no question.", q.isTrueFalse());
		final Answer trueAns = q.getAnswer().get(0);
		final Answer falseAns = q.getAnswer().get(1);		
		assertFalse(trueAns.isCorrect());
		assertTrue(falseAns.isCorrect());
		assertEquals("True", trueAns.getText());
		assertEquals("False", falseAns.getText());	
	}
	
	@Test
	public void testQuestionWithFeedback() {
		final String input = "For object nodes that are target of continuous flows (such as electrical signals), which of the following propositions would you do? {\n" +
			 "\t~ apply stereotypes Overwrite and NoBuffer#It is forbidden to apply both at the same time.\n" + 
			 "\t= apply Overwrite stereotype#In that case, both have the same semantic.\n" +
			 "\t= apply NoBuffer stereotype#In that case, both have the same semantic.\n" +
			 "}\n";
		final Question q = importer.readQuestion(input);
		assertNotNull(q);
		assertEquals("For object nodes that are target of continuous flows (such as electrical signals), which of the following propositions would you do?", q.getText());
		assertFalse(q.isTrueFalse());
		assertEquals(3, q.getAnswer().size());
		final Answer a1 = q.getAnswer().get(0);
		final Answer a2 = q.getAnswer().get(1);
		final Answer a3 = q.getAnswer().get(2);
		assertEquals("apply stereotypes Overwrite and NoBuffer", a1.getText());
		assertEquals("apply Overwrite stereotype", a2.getText());
		assertEquals("apply NoBuffer stereotype", a3.getText());
		assertEquals("It is forbidden to apply both at the same time.", a1.getFeedback());
		assertEquals("In that case, both have the same semantic.", a2.getFeedback());
		assertEquals("In that case, both have the same semantic.", a3.getFeedback());
		assertFalse(a1.isCorrect());
		assertTrue(a2.isCorrect());
		assertTrue(a3.isCorrect());
	}
}
