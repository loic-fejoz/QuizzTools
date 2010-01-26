/*******************************************************************************
 * Copyright (c) 26 janv. 2010 RealTime-at-Work.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    loic - initial API and implementation and/or initial documentation
 *******************************************************************************/ 
package quizz.exporter.html.files;

import quizz.Answer;
import quizz.Question;
import quizz.Quizz;
import quizz.QuizzFactory;
import junit.framework.TestCase;

/**
 * @author loic
 *
 */
public class MyExportToHtmlTest extends TestCase {
	
	protected MyExportToHtml exporter;
	private QuizzFactory factory;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		exporter = new MyExportToHtml();
		factory = QuizzFactory.eINSTANCE;
	}

	/**
	 * Test method for {@link quizz.exporter.html.files.MyExportToHtml#export(quizz.Quizz)}.
	 */
	public void testExportQuizz() {
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
		final String html = exporter.export(quizz);
		assertTrue(html.startsWith("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"));
	}

}
