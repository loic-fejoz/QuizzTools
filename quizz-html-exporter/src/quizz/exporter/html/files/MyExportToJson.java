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
import java.util.Iterator;

import quizz.Answer;
import quizz.Question;
import quizz.Quizz;

/**
 * @author Loïc Fejoz
 * 
 */
public class MyExportToJson {

	public MyExportToJson() {

	}

	public String exportToJson(Quizz quizz) {
		StringBuffer buf = new StringBuffer();
		exportToJson(buf, quizz, 0);
		return buf.toString();
	}

	private void exportToJson(StringBuffer buf, Quizz quizz, int level) {
		buf.append("{\n");
		buf.append("  \"name\": \"");
		buf.append(quizz.getName());
		buf.append("\",\n");
		buf.append("  \"question\": [\n");
		//buf.append("\n");
		buf.append("  ]\n");
		buf.append("}\n");
	}

	public void export(File folderTarget, Quizz quizz) {
		export(folderTarget, quizz, quizz.getName());
	}

	public void export(File folderTarget, Quizz quizz, String fileName) {
	}
	
	public String exportToJson(Answer ans) {
		StringBuffer buf = new StringBuffer();
		exportToJson(buf, ans, 0);
		buf.append("\n");
		return buf.toString();
	}
	
	private void append(final StringBuffer buf, int level, final String value) {
		for(int i=0; i < level; i++) {
			buf.append(' ');
		}
		buf.append(value);
	}
	
	private void exportJsonStringAttr(final StringBuffer buf, int level, final String attrName, final String value) {
		append(buf, level, "");
		buf.append("\""+ attrName + "\": \"");
		buf.append(value);
		buf.append("\",\n");
	}
	
	private void exportJsonBooleanAttr(final StringBuffer buf, int level, final String attrName, final boolean value) {
		append(buf, level, "");
		buf.append("\""+ attrName + "\": ");
		buf.append(Boolean.toString(value));
		buf.append(",\n");
	}	

	private void exportToJson(StringBuffer buf, Answer ans, int level) {
		append(buf, level, "{\n");
		exportJsonStringAttr(buf, level+2, "text", ans.getText());
		exportJsonBooleanAttr(buf, level+2, "correct", ans.isCorrect());
		exportJsonStringAttr(buf, level+2, "feedback", ans.getFeedback() == null? "": ans.getFeedback());
		append(buf, level, "}");
	}	

	public String exportToJson(Question q) {
		StringBuffer buf = new StringBuffer();
		exportToJson(buf, q, 0);
		buf.append("\n");
		return buf.toString();
	}

	private void exportToJson(StringBuffer buf, Question q, int level) {
		append(buf, level, "{\n");
		exportJsonStringAttr(buf, level+2, "title", q.getTitle());
		exportJsonStringAttr(buf, level+2, "text", q.getText());
		exportJsonStringAttr(buf, level+2, "textFormat", q.getTextFormat().toString());
		exportJsonStringAttr(buf, level+2, "isTrueFalse", Boolean.toString(q.isTrueFalse()));
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
