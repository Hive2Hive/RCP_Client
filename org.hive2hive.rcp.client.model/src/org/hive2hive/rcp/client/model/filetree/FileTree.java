/**
 */
package org.hive2hive.rcp.client.model.filetree;

import java.nio.file.Path;
import org.eclipse.emf.common.util.EMap;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File Tree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.hive2hive.rcp.client.model.filetree.FileTree#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.hive2hive.rcp.client.model.filetree.FileTreePackage#getFileTree()
 * @model
 * @generated
 */
public interface FileTree extends Container {

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' map.
	 * The key is of type {@link java.nio.file.Path},
	 * and the value is of type {@link org.hive2hive.rcp.client.model.filetree.FileTreeElement},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' map.
	 * @see org.hive2hive.rcp.client.model.filetree.FileTreePackage#getFileTree_Elements()
	 * @model mapType="org.hive2hive.rcp.client.model.filetree.PathToTreeElementMap<org.hive2hive.rcp.client.model.filetree.Path, org.hive2hive.rcp.client.model.filetree.FileTreeElement>"
	 * @generated
	 */
	EMap<Path, FileTreeElement> getElements();
} // FileTree
