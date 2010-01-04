/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package quizz;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Answer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link quizz.Answer#getText <em>Text</em>}</li>
 *   <li>{@link quizz.Answer#getFeedback <em>Feedback</em>}</li>
 *   <li>{@link quizz.Answer#isCorrect <em>Correct</em>}</li>
 * </ul>
 * </p>
 *
 * @see quizz.QuizzPackage#getAnswer()
 * @model
 * @generated
 */
public interface Answer extends EObject {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see quizz.QuizzPackage#getAnswer_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link quizz.Answer#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Feedback</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feedback</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feedback</em>' attribute.
	 * @see #setFeedback(String)
	 * @see quizz.QuizzPackage#getAnswer_Feedback()
	 * @model
	 * @generated
	 */
	String getFeedback();

	/**
	 * Sets the value of the '{@link quizz.Answer#getFeedback <em>Feedback</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feedback</em>' attribute.
	 * @see #getFeedback()
	 * @generated
	 */
	void setFeedback(String value);

	/**
	 * Returns the value of the '<em><b>Correct</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Correct</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Correct</em>' attribute.
	 * @see #setCorrect(boolean)
	 * @see quizz.QuizzPackage#getAnswer_Correct()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isCorrect();

	/**
	 * Sets the value of the '{@link quizz.Answer#isCorrect <em>Correct</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Correct</em>' attribute.
	 * @see #isCorrect()
	 * @generated
	 */
	void setCorrect(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * Return true is this answer is a True or False answer,
	 * ie text is one of {T, TRUE, F, FALSE}.
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isTrueFalse();

} // Answer
