/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package quizz;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Category</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link quizz.Category#getName <em>Name</em>}</li>
 *   <li>{@link quizz.Category#getSubCategory <em>Sub Category</em>}</li>
 *   <li>{@link quizz.Category#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see quizz.QuizzPackage#getCategory()
 * @model
 * @generated
 */
public interface Category extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see quizz.QuizzPackage#getCategory_Name()
	 * @model id="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link quizz.Category#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Sub Category</b></em>' containment reference list.
	 * The list contents are of type {@link quizz.Category}.
	 * It is bidirectional and its opposite is '{@link quizz.Category#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Category</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Category</em>' containment reference list.
	 * @see quizz.QuizzPackage#getCategory_SubCategory()
	 * @see quizz.Category#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Category> getSubCategory();

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link quizz.Category#getSubCategory <em>Sub Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Category)
	 * @see quizz.QuizzPackage#getCategory_Owner()
	 * @see quizz.Category#getSubCategory
	 * @model opposite="subCategory" transient="false"
	 * @generated
	 */
	Category getOwner();

	/**
	 * Sets the value of the '{@link quizz.Category#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Category value);

} // Category
