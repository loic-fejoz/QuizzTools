/*******************************************************************************
 * Copyright © 4 janv. 2010 RealTime-at-Work.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Loïc Fejoz - initial API and implementation and/or initial documentation
 *******************************************************************************/
package quizz.exporter.html.files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;

import quizz.Quizz;

/**
 * @author Loïc Fejoz
 * 
 */
public class MyExportToHtml {

	public MyExportToHtml() {
	}

	public String export(Quizz quizz) {
		StringWriter wrt = new StringWriter();
		try {
			export(wrt, quizz);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return wrt.toString();
	}

	private void export(Writer writer, Quizz quizz) throws IOException {
		MyExportToJson jsonExporter = new MyExportToJson();
		writer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		writer.append("<html>\n");
		writer.append("<header>\n");
		writer.append("  <title>");
		writer.append(quizz.getName());
		writer.append("</title>\n");
		writer.append("  <style type=\"text/css\">\n");
		writer.append(".question {\n");
		writer.append("  list-style-type: lower-alpha;\n");
		writer.append("}\n");
		writer.append(".correct {\n");
		writer.append("  background-color: #98ff98;\n");
		writer.append("}\n");
		writer.append(".incorrect {\n");
		writer.append("  background-color: #ff9999;\n");
		writer.append("}\n");
		writer.append(".feedback {\n");
		writer.append("  display: none;\n");
		writer.append("}\n");
		writer.append(".shownfeedback {\n");
		writer.append("  display: visible;\n");
		writer.append("}\n");
		writer.append("  </style>\n");
		writer.append("<script type=\"text/javascript\">\n");
		writer.append("var currentQuestionIndex = 0;\n");
		writer.append("var currentQuestion;\n");
		writer.append("var quizz;\n");
		writer.append("\n");
		writer.append("var simpleQuizz =");
		writer.append(jsonExporter.exportToJson(quizz));
		writer.append(";\n");
		writer.append("\n");
		writer.append("function setQuizz(newQuizz) {\n");
		writer.append("  quizz = newQuizz;\n");
		writer.append("  document.title = quizz[\"name\"];\n");
		writer
				.append("  document.getElementById(\"nbQuestion\").innerHTML = quizz[\"question\"].length;\n");
		writer.append("  setQuestionIndex(0);\n");
		writer.append("}\n");
		writer.append("\n");
		writer.append("function setQuestionIndex(questionIndex) {\n");
		writer.append("  currentQuestionIndex = questionIndex;\n");
		writer
				.append("  var q = quizz[\"question\"][questionIndex];\n");
		writer
				.append("  document.getElementById(\"current\").innerHTML = questionIndex + 1;\n");
		writer.append("  setQuestion(q);\n");
		writer.append("}\n");
		writer.append("\n");
		writer.append("function setQuestion(question) {\n");
		writer.append("  currentQuestion = question;\n");
		writer
				.append("  document.getElementById(\"title\").innerHTML = question[\"title\"];\n");
		writer
				.append("  document.getElementById(\"question-text\").innerHTML = question[\"text\"];\n");
		writer.append("  var answers = question[\"answer\"];\n");
		writer.append("  var html = \"\";\n");
		writer.append("  var ans;\n");
		writer.append("  for(ansi in answers) {\n");
		writer.append("    ans = answers[ansi];\n");
		writer
				.append("    html += \"<li class='answer' id='answer\" + ansi + \"'><input id='answer-input\" + ansi + \"' type='checkbox'/><label for='answer\" + ansi + \"'>\" + ans[\"text\"] + \"</label> <span id='answer-feedback\" + ansi + \"' class='feedback'>\";\n");
		writer.append("    if (ans[\"feedback\"]) {\n");
		writer.append("        html += ans[\"feedback\"];\n");
		writer.append("    };	\n");
		writer.append("    html += \"</span></li>\";\n");
		writer.append("  }\n");
		writer
				.append("  document.getElementById(\"question-answers\").innerHTML = html;\n");
		writer.append("}\n");
		writer.append("\n");
		writer.append("function seeAnswers() {\n");
		writer
				.append("  var quizzButton = document.getElementById(\"quizzButton\");\n");
		writer.append("  quizzButton.value = \"next question\";\n");
		writer.append("  quizzButton.onclick = nextQuestion;\n");
		writer.append("  var ans;\n");
		writer.append("  var listItem;\n");
		writer.append("  var inputCB;\n");
		writer.append("  var answers = currentQuestion[\"answer\"];\n");
		writer.append("  var feedback;\n");
		writer.append("  for(ansi in answers) {\n");
		writer
				.append("    ans = currentQuestion[\"answer\"][ansi];\n");
		writer
				.append("    listItem = document.getElementById(\"answer\" + ansi);\n");
		writer
				.append("    inputCB = document.getElementById(\"answer-input\" + ansi);\n");
		writer.append("    feedback = document.getElementById(\"answer-feedback\" + ansi);\n");
		writer.append("    feedback.className += \"shownfeedback\";    \n");
		writer.append("    if (ans[\"correct\"]) {\n");
		writer.append("      listItem.className += \" correct\";\n");
		writer.append("      if (inputCB.checked) {\n");
		writer.append("        incScore(1);\n");
		writer.append("      }\n");
		writer.append("      incMaxScore(1);\n");
		writer.append("    } else {\n");
		writer.append("      listItem.className += \" incorrect\";\n");
		writer.append("    }\n");
		writer.append("  }\n");
		writer.append("  return false;\n");
		writer.append("}\n");
		writer.append("\n");
		writer.append("function incScore(increment) {\n");
		writer.append("  var scoreElt = document.getElementById(\"score\");\n");
		writer
				.append("  scoreElt.innerHTML = parseInt(scoreElt.innerHTML, 10) + increment;\n");
		writer.append("}\n");
		writer.append("\n");
		writer.append("function incMaxScore(increment) {\n");
		writer
				.append("  var scoreElt = document.getElementById(\"maxScore\");\n");
		writer
				.append("  scoreElt.innerHTML = parseInt(scoreElt.innerHTML, 10) + increment;\n");
		writer.append("}\n");
		writer.append("\n");
		writer.append("function getScore() {\n");
		writer
				.append("  return parseInt(document.getElementById(\"score\").innerHTML);\n");
		writer.append("}\n");
		writer.append("\n");
		writer.append("function getMaxScore() {\n");
		writer
				.append("  return parseInt(document.getElementById(\"maxScore\").innerHTML);\n");
		writer.append("}\n");
		writer.append("\n");
		writer.append("function nextQuestion() {\n");
		writer
				.append("  if (currentQuestionIndex >= quizz[\"question\"].length - 1) {\n");
		writer.append("    var score = getScore();\n");
		writer
				.append("    alert(\"You have finished the test with score: \" + score + \"!\\n\");\n");
		writer.append("    return false;\n");
		writer.append("  }\n");
		writer.append("  setQuestionIndex(currentQuestionIndex + 1);\n");
		writer
				.append("  var quizzButton = document.getElementById(\"quizzButton\");\n");
		writer.append("  quizzButton.value = \"see answers\";\n");
		writer.append("  quizzButton.onclick = seeAnswers;\n");
		writer.append("  return false;\n");
		writer.append("}\n");
		writer.append("\n");
		writer.append("</script>\n");
		writer.append("</header>\n");
		writer.append("<body onload=\"setQuizz(simpleQuizz);\">\n");
		writer
				.append("<h1><span id=\"title\">Title</span> - <span id=\"current\">1</span>/<span id=\"nbQuestion\">20</span></h1>\n");
		writer.append("<p id='question-text'>Question</p>\n");
		writer.append("<form>\n");
		writer.append("<ol id='question-answers' class='question'>\n");
		writer
				.append("	<li><input type='checkbox'/><label>answer 1 </label><span class=\"feedback\">Blah blah blah</span></li>\n");
		writer.append("	<li><input type='checkbox'/>answer 2</li>\n");
		writer.append("	<li><input type='checkbox'/>answer 3</li>\n");
		writer.append("	<li><input type='checkbox'/>answer 4</li>\n");
		writer.append("</ol>\n");
		writer
				.append("<input id=\"quizzButton\" type=\"submit\" value=\"See answers\" onclick=\"return seeAnswers();\"/>\n");
		writer.append("</form>\n");
		writer
				.append("<p>Your score: <span id='score'>0</span>/<span id='maxScore'>0</span></p>\n");
		writer.append("</html>\n");
	}

	public void export(File folderTarget, Quizz quizz, String fileName) throws IOException {
		final File f = new File(folderTarget, fileName);
		export(f, quizz);
	}
	
	public void export(final File target, Quizz quizz) throws IOException {
		assert target != null;
		assert quizz != null;
		Writer wrt = new OutputStreamWriter(new FileOutputStream(target));
		export(wrt, quizz);
		wrt.flush();
		wrt.close();
	}
}
