/**
 */
package org.hive2hive.rcp.client.model.filetree;

import org.eclipse.emf.common.util.EMap;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.hive2hive.rcp.client.model.filetree.File#getAccessRights <em>Access Rights</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.hive2hive.rcp.client.model.filetree.FileTreePackage#getFile()
 * @model
 * @generated
 */
public interface File extends FileTreeElement {

	/**
	 * Returns the value of the '<em><b>Access Rights</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link org.hive2hive.rcp.client.model.filetree.AccessRights},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Access Rights</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access Rights</em>' map.
	 * @see org.hive2hive.rcp.client.model.filetree.FileTreePackage#getFile_AccessRights()
	 * @model mapType="org.hive2hive.rcp.client.model.filetree.UserIdToAccessRightsMap<org.eclipse.emf.ecore.EString, org.hive2hive.rcp.client.model.filetree.AccessRights>"
	 * @generated
	 */
	EMap<String, AccessRights> getAccessRights();
} // File
