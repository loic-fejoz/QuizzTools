/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package quizz.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import quizz.Quizz;
import quizz.QuizzFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Quizz</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class QuizzTest extends TestCase {

	/**
	 * The fixture for this Quizz test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Quizz fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(QuizzTest.class);
	}

	/**
	 * Constructs a new Quizz test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuizzTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Quizz test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Quizz fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Quizz test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Quizz getFixture() {
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
		setFixture(QuizzFactory.eINSTANCE.createQuizz());
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
	
	public void test() {
		fixture.setName("Foo");
		assertEquals("Foo", fixture.getName());
	}

} //QuizzTest
