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
package quizz.tests;

import org.eclipse.emf.common.util.EList;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import quizz.Answer;
import quizz.Question;
import quizz.QuizzFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Question</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link quizz.Question#isTrueFalse() <em>Is True False</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class QuestionTest extends TestCase {

	/**
	 * The fixture for this Question test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Question fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(QuestionTest.class);
	}

	/**
	 * Constructs a new Question test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuestionTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Question test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Question fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Question test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Question getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(QuizzFactory.eINSTANCE.createQuestion());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link quizz.Question#isTrueFalse() <em>Is True False</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see quizz.Question#isTrueFalse()
	 * @generated NOT
	 */
	public void testPositiveIsTrueFalse() {
		final Answer ansT = QuizzFactory.eINSTANCE.createAnswer();
		ansT.setText("T");
		fixture.getAnswer().add(ansT);
		assertTrue(fixture.isTrueFalse());
	}
	
	public void testTrueLieIsNotTrueFalse() {
		final Answer ansT = QuizzFactory.eINSTANCE.createAnswer();
		ansT.setText("True lie");
		fixture.getAnswer().add(ansT);
		assertFalse(fixture.isTrueFalse());
	}
	
	public void testYesNoMaybeIsNotTrueFalse() {
		final Answer ansT = QuizzFactory.eINSTANCE.createAnswer();
		ansT.setText("TRUE");
		final Answer ansF = QuizzFactory.eINSTANCE.createAnswer();
		ansF.setText("FALSE");
		final Answer ansM = QuizzFactory.eINSTANCE.createAnswer();
		ansM.setText("Maybe");
		EList<Answer> l = fixture.getAnswer();
		l.add(ansT);
		l.add(ansF);
		l.add(ansM);
		assertFalse(fixture.isTrueFalse());
	}
	
	public void testQuestionWithNoAnswerIsNotTrueFalse() {
		assertFalse(fixture.isTrueFalse());
	}	

} //QuestionTest
