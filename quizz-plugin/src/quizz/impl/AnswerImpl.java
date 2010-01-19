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
package quizz.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import quizz.Answer;
import quizz.QuizzPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Answer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link quizz.impl.AnswerImpl#getText <em>Text</em>}</li>
 *   <li>{@link quizz.impl.AnswerImpl#getFeedback <em>Feedback</em>}</li>
 *   <li>{@link quizz.impl.AnswerImpl#isCorrect <em>Correct</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnswerImpl extends EObjectImpl implements Answer {
	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFeedback() <em>Feedback</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeedback()
	 * @generated
	 * @ordered
	 */
	protected static final String FEEDBACK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFeedback() <em>Feedback</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeedback()
	 * @generated
	 * @ordered
	 */
	protected String feedback = FEEDBACK_EDEFAULT;

	/**
	 * The default value of the '{@link #isCorrect() <em>Correct</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCorrect()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CORRECT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCorrect() <em>Correct</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCorrect()
	 * @generated
	 * @ordered
	 */
	protected boolean correct = CORRECT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnswerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QuizzPackage.Literals.ANSWER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QuizzPackage.ANSWER__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFeedback() {
		return feedback;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeedback(String newFeedback) {
		String oldFeedback = feedback;
		feedback = newFeedback;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QuizzPackage.ANSWER__FEEDBACK, oldFeedback, feedback));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCorrect() {
		return correct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCorrect(boolean newCorrect) {
		boolean oldCorrect = correct;
		correct = newCorrect;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QuizzPackage.ANSWER__CORRECT, oldCorrect, correct));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isTrueFalse() {
		return "T".equals(text.toUpperCase()) ||
               "TRUE".equals(text.toUpperCase()) ||
               "F".equals(text.toUpperCase()) ||
               "FALSE".equals(text.toUpperCase());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QuizzPackage.ANSWER__TEXT:
				return getText();
			case QuizzPackage.ANSWER__FEEDBACK:
				return getFeedback();
			case QuizzPackage.ANSWER__CORRECT:
				return isCorrect();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QuizzPackage.ANSWER__TEXT:
				setText((String)newValue);
				return;
			case QuizzPackage.ANSWER__FEEDBACK:
				setFeedback((String)newValue);
				return;
			case QuizzPackage.ANSWER__CORRECT:
				setCorrect((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case QuizzPackage.ANSWER__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case QuizzPackage.ANSWER__FEEDBACK:
				setFeedback(FEEDBACK_EDEFAULT);
				return;
			case QuizzPackage.ANSWER__CORRECT:
				setCorrect(CORRECT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case QuizzPackage.ANSWER__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case QuizzPackage.ANSWER__FEEDBACK:
				return FEEDBACK_EDEFAULT == null ? feedback != null : !FEEDBACK_EDEFAULT.equals(feedback);
			case QuizzPackage.ANSWER__CORRECT:
				return correct != CORRECT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer();
		result.append(correct?"=":"~");
		result.append(text);
//		result.append(feedback);
		return result.toString();
	}

} //AnswerImpl
