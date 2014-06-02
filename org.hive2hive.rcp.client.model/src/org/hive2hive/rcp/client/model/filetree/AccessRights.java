/**
 */
package org.hive2hive.rcp.client.model.filetree;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Access Rights</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.hive2hive.rcp.client.model.filetree.AccessRights#isReadPermission <em>Read Permission</em>}</li>
 *   <li>{@link org.hive2hive.rcp.client.model.filetree.AccessRights#isWritePermission <em>Write Permission</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.hive2hive.rcp.client.model.filetree.FileTreePackage#getAccessRights()
 * @model
 * @generated
 */
public interface AccessRights extends EObject {
	/**
	 * Returns the value of the '<em><b>Read Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Permission</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Permission</em>' attribute.
	 * @see #setReadPermission(boolean)
	 * @see org.hive2hive.rcp.client.model.filetree.FileTreePackage#getAccessRights_ReadPermission()
	 * @model
	 * @generated
	 */
	boolean isReadPermission();

	/**
	 * Sets the value of the '{@link org.hive2hive.rcp.client.model.filetree.AccessRights#isReadPermission <em>Read Permission</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Permission</em>' attribute.
	 * @see #isReadPermission()
	 * @generated
	 */
	void setReadPermission(boolean value);

	/**
	 * Returns the value of the '<em><b>Write Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Write Permission</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Write Permission</em>' attribute.
	 * @see #setWritePermission(boolean)
	 * @see org.hive2hive.rcp.client.model.filetree.FileTreePackage#getAccessRights_WritePermission()
	 * @model
	 * @generated
	 */
	boolean isWritePermission();

	/**
	 * Sets the value of the '{@link org.hive2hive.rcp.client.model.filetree.AccessRights#isWritePermission <em>Write Permission</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Write Permission</em>' attribute.
	 * @see #isWritePermission()
	 * @generated
	 */
	void setWritePermission(boolean value);

} // AccessRights
