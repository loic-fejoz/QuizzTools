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
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>Quizz</b></em>' model.
 * <!-- end-user-doc -->
 * @generated
 */
public class QuizzAllTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new QuizzAllTests("Quizz Tests");
		suite.addTest(QuizzTests.suite());
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuizzAllTests(String name) {
		super(name);
	}

} //QuizzAllTests
