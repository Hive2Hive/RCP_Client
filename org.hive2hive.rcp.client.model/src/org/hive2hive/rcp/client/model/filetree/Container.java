/**
 */
package org.hive2hive.rcp.client.model.filetree;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.hive2hive.rcp.client.model.filetree.Container#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.hive2hive.rcp.client.model.filetree.FileTreePackage#getContainer()
 * @model
 * @generated
 */
public interface Container extends FileTreeElement {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.hive2hive.rcp.client.model.filetree.FileTreeElement}.
	 * It is bidirectional and its opposite is '{@link org.hive2hive.rcp.client.model.filetree.FileTreeElement#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.hive2hive.rcp.client.model.filetree.FileTreePackage#getContainer_Children()
	 * @see org.hive2hive.rcp.client.model.filetree.FileTreeElement#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<FileTreeElement> getChildren();

} // Container
