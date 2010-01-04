package quizz.importer.gift;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import quizz.Question;

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
				"= "+ ansText3 + "\n" +
				"}");
		assertEquals(questionText, q.getText());
		assertEquals(null, q.getTitle());
		assertNotNull(q.getAnswer());
		assertEquals(3, q.getAnswer().size());
		assertEquals(ansText1, q.getAnswer().get(1).getText());
		assertEquals(ansText2, q.getAnswer().get(2).getText());
		assertEquals(ansText3, q.getAnswer().get(3).getText());
		
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
		assertEquals(ansText1, q.getAnswer().get(1).getText());
		assertEquals(ansText2, q.getAnswer().get(2).getText());
		assertEquals(ansText3, q.getAnswer().get(3).getText());
		
	}	

}
