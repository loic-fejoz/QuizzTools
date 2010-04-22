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
package quizz.exporter.html;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;

import quizz.Answer;
import quizz.Question;
import quizz.Quizz;

/**
 * @author Loïc Fejoz
 * 
 */
public class ExportToJson {

	public ExportToJson() {

	}

	public String exportToJson(Quizz quizz) {
		StringWriter buf = new StringWriter();
		try {
			exportToJson(buf, quizz, 0);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return buf.toString();
	}

	private void exportToJson(Writer buf, Quizz quizz, int level) throws IOException {
		buf.append("{\n");
		buf.append("  \"name\": \"");
		buf.append(quizz.getName());
		buf.append("\",\n");
		buf.append("  \"question\": [\n");
		Iterator<Question> itQuestions = quizz.getQuestion().iterator();
		while(itQuestions.hasNext()) {
			exportToJson(buf, itQuestions.next(), level+2);
			if (itQuestions.hasNext()) {
				buf.append(",");
			}
			buf.append("\n");
		}
		buf.append("  ]\n");
		buf.append("}\n");
	}

	public void export(File folderTarget, Quizz quizz) throws IOException {
		export(folderTarget, quizz, quizz.getName().replaceAll(" ", "-") + ".json");
	}

	public void export(File folderTarget, Quizz quizz, String fileName) throws IOException {
		final File target = new File(folderTarget, fileName);
		final Writer writer = new OutputStreamWriter(new FileOutputStream(
				target));
		exportToJson(writer, quizz, 0);
		writer.flush();
		writer.close();
	}
	
	public String exportToJson(Answer ans) {
		StringWriter buf = new StringWriter();
		try {
			exportToJson(buf, ans, 0);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		buf.append("\n");
		return buf.toString();
	}
	
	private void append(final Writer buf, int level, final String value) throws IOException {
		for(int i=0; i < level; i++) {
			buf.append(' ');
		}
		buf.append(value);
	}
	
	private void exportJsonStringAttr(final Writer buf, int level, final String attrName, final String value) throws IOException {
		exportJsonStringAttr(buf, level, attrName, value, true);
	}
	
	private void exportJsonStringAttr(final Writer buf, int level, final String attrName, final String value, final boolean hasFollowingAttribute) throws IOException {
		append(buf, level, "");
		buf.append("\""+ attrName + "\": \"");
		if (value != null) {
			buf.append(value.replaceAll("\\\"", "\\\\\""));
		}
		buf.append("\"");
		if (hasFollowingAttribute) {
			buf.append(",");
		}
		buf.append("\n");
	}
	
	private void exportJsonBooleanAttr(final Writer buf, int level, final String attrName, final boolean value) throws IOException {
		exportJsonBooleanAttr(buf, level, attrName, value, true);
	}
	
	private void exportJsonBooleanAttr(final Writer buf, int level, final String attrName, final boolean value, final boolean hasFollowingAttribute) throws IOException {
		append(buf, level, "");
		buf.append("\""+ attrName + "\": ");
		buf.append(Boolean.toString(value));
		if (hasFollowingAttribute) {
			buf.append(",");
		}
		buf.append("\n");
	}	

	private void exportToJson(Writer buf, Answer ans, int level) throws IOException {
		append(buf, level, "{\n");
		exportJsonStringAttr(buf, level+2, "text", ans.getText());
		exportJsonBooleanAttr(buf, level+2, "correct", ans.isCorrect());
		exportJsonStringAttr(buf, level+2, "feedback", ans.getFeedback() == null? "": ans.getFeedback(), false);
		append(buf, level, "}");
	}	

	public String exportToJson(Question q) {
		StringWriter buf = new StringWriter();
		try {
			exportToJson(buf, q, 0);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		buf.append("\n");
		return buf.toString();
	}

	private void exportToJson(Writer buf, Question q, int level) throws IOException {
		append(buf, level, "{\n");
		exportJsonStringAttr(buf, level+2, "title", q.getTitle());
		exportJsonStringAttr(buf, level+2, "text", q.getText());
		exportJsonStringAttr(buf, level+2, "textFormat", q.getTextFormat().toString());
		exportJsonBooleanAttr(buf, level+2, "isTrueFalse", q.isTrueFalse());
		append(buf, level+2, "\"answer\": [\n");
		Iterator<Answer> itAnswers = q.getAnswer().iterator();
		while(itAnswers.hasNext()) {
			exportToJson(buf, itAnswers.next(), level+2);
			if (itAnswers.hasNext()) {
				buf.append(",\n");
			}
		}
		buf.append("\n");
		append(buf, level+2, "]\n");
		append(buf, level, "}");
	}

}
