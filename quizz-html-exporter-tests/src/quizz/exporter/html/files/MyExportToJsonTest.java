package quizz.exporter.html.files;

import junit.framework.TestCase;
import quizz.Answer;
import quizz.Question;
import quizz.Quizz;
import quizz.QuizzFactory;
import quizz.exporter.html.ExportToJson;

public class MyExportToJsonTest extends TestCase {

	protected QuizzFactory factory;
	protected ExportToJson exporter;

	// @Before
	public void setUp() throws Exception {
		exporter = new ExportToJson();
		factory = QuizzFactory.eINSTANCE;
	}

	// @Test
	public void testExportEmptyQuizzToJson() {
		Quizz quizz = factory.createQuizz();
		quizz.setName("emptyquizz");
		final String result = exporter.exportToJson(quizz);
		assertEquals(
				"{\n  \"name\": \"emptyquizz\",\n  \"question\": [\n  ]\n}\n",
				result);
	}

	// @Test
	public void testExportTrueAnswerToJson() {
		Answer q = factory.createAnswer();
		q.setText("T");
		q.setCorrect(true);
		assertEquals("{\n" + "  \"text\": \"T\",\n" + "  \"correct\": true,\n"
				+ "  \"feedback\": \"\"\n" + "}\n", exporter.exportToJson(q));
	}
	
	// @Test
	public void testExportEmptyAnswerToJson() {
		Answer q = factory.createAnswer();
		q.setCorrect(true);
		assertEquals("{\n" + "  \"text\": \"\",\n" + "  \"correct\": true,\n"
				+ "  \"feedback\": \"\"\n" + "}\n", exporter.exportToJson(q));
	}	
	
	// @Test
	public void testExportAnswerWithQuoteToJson() {
		Answer q = factory.createAnswer();
		q.setText("\"hello\"");
		q.setCorrect(true);
		assertEquals("{\n" + "  \"text\": \"\\\"hello\\\"\",\n" + "  \"correct\": true,\n"
				+ "  \"feedback\": \"\"\n" + "}\n", exporter.exportToJson(q));
	}	

	// @Test
	public void testExportTrueQuestionToJson() {
		final Question q = factory.createQuestion();
		q.setTitle("the title");
		q.setText("Is it true?");
		final Answer ans = factory.createAnswer();
		q.getAnswer().add(ans);
		ans.setText("T");
		ans.setCorrect(true);
		assertEquals("{\n" + "  \"title\": \"the title\",\n"
				+ "  \"text\": \"Is it true?\",\n"
				+ "  \"textFormat\": \"plain\",\n"
				+ "  \"isTrueFalse\": true,\n" + "  \"answer\": [\n"
				+ "  {\n" + "    \"text\": \"T\",\n"
				+ "    \"correct\": true,\n" + "    \"feedback\": \"\"\n"
				+ "  }\n" + "  ]\n" + "}\n", exporter.exportToJson(q));
	}

	// @Test
	public void testExportTrueFalseQuestionToJson() {
		final Question q = factory.createQuestion();
		q.setTitle("the title");
		q.setText("Is it true?");
		final Answer ans = factory.createAnswer();
		q.getAnswer().add(ans);
		ans.setText("T");
		ans.setCorrect(true);
		final Answer ansF = factory.createAnswer();
		q.getAnswer().add(ansF);
		ansF.setText("F");
		ansF.setCorrect(false);
		assertEquals("{\n" + "  \"title\": \"the title\",\n"
				+ "  \"text\": \"Is it true?\",\n"
				+ "  \"textFormat\": \"plain\",\n"
				+ "  \"isTrueFalse\": true,\n" + "  \"answer\": [\n"
				+ "  {\n" + "    \"text\": \"T\",\n"
				+ "    \"correct\": true,\n" + "    \"feedback\": \"\"\n"
				+ "  },\n" + "  {\n" + "    \"text\": \"F\",\n"
				+ "    \"correct\": false,\n" + "    \"feedback\": \"\"\n"
				+ "  }\n" + "  ]\n" + "}\n", exporter.exportToJson(q));
	}

	public void testExportSimpleQuizzToJson() {
		final Quizz quizz = factory.createQuizz();
		quizz.setName("simple quizz");
		final Question quest = factory.createQuestion();
		quest.setText("Is it true?");
		quest.setTitle("the title");
		quizz.getQuestion().add(quest);
		final Answer tAns = factory.createAnswer();
		quest.getAnswer().add(tAns);
		tAns.setText("T");
		tAns.setCorrect(true);
		final Answer fAns = factory.createAnswer();
		quest.getAnswer().add(fAns);
		fAns.setText("F");
		fAns.setCorrect(false);
		assertEquals(
				  "{\n  \"name\": \"simple quizz\",\n"
				+"  \"question\": [\n" 
				+ "  {\n"
				+ "    \"title\": \"the title\",\n"
				+ "    \"text\": \"Is it true?\",\n"
				+ "    \"textFormat\": \"plain\",\n"
				+ "    \"isTrueFalse\": true,\n"
				+ "    \"answer\": [\n"
				+ "    {\n" 
				+ "      \"text\": \"T\",\n"
				+ "      \"correct\": true,\n" 
				+ "      \"feedback\": \"\"\n"
				+ "    },\n" 
				+ "    {\n" 
				+ "      \"text\": \"F\",\n"
				+ "      \"correct\": false,\n"
				+ "      \"feedback\": \"\"\n"
				+ "    }\n" 
				+ "    ]\n" 
				+ "  }\n"
				+ "  ]\n"
				+ "}",
				exporter.exportToJson(quizz).trim());
	}

}
