/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package quizz.tests;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc --> A test suite for the '<em><b>quizz</b></em>' package.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class QuizzTests extends TestSuite {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new QuizzTests("quizz Tests");
		suite.addTestSuite(QuestionTest.class);
		suite.addTestSuite(AnswerTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public QuizzTests(String name) {
		super(name);
	}

} // QuizzTests
