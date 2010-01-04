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

import junit.framework.TestCase;

import junit.textui.TestRunner;

import quizz.Answer;
import quizz.QuizzFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Answer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link quizz.Answer#isTrueFalse() <em>Is True False</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class AnswerTest extends TestCase {

	/**
	 * The fixture for this Answer test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Answer fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AnswerTest.class);
	}

	/**
	 * Constructs a new Answer test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnswerTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Answer test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Answer fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Answer test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Answer getFixture() {
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
		setFixture(QuizzFactory.eINSTANCE.createAnswer());
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
	 * Tests the '{@link quizz.Answer#isTrueFalse() <em>Is True False</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see quizz.Answer#isTrueFalse()
	 * @generated NOT
	 */
	public void testTIsTrueFalse() {
		fixture.setText("T");
		assertTrue(fixture.isTrueFalse());
	}
	
	public void testTRUEIsTrueFalse() {
		fixture.setText("true");
		assertTrue(fixture.isTrueFalse());
	}
	
	public void testFALSEIsTrueFalse() {
		fixture.setText("FALSE");
		assertTrue(fixture.isTrueFalse());
	}
	
	public void testFIsTrueFalse() {
		fixture.setText("f");
		assertTrue(fixture.isTrueFalse());
	}
	
	public void testFooIsNotTrueFalse() {
		fixture.setText("foo");
		assertFalse(fixture.isTrueFalse());
	}
	
	public void testTrueismIsNotTrueFalse() {
		fixture.setText("trueism");
		assertFalse(fixture.isTrueFalse());
	}		

} //AnswerTest
