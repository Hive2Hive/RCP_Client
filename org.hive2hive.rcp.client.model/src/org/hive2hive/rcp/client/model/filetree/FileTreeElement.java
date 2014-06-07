/**
 */
package org.hive2hive.rcp.client.model.filetree;

import java.io.File;
import java.nio.file.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.hive2hive.rcp.client.model.filetree.FileTreeElement#getPath <em>Path</em>}</li>
 *   <li>{@link org.hive2hive.rcp.client.model.filetree.FileTreeElement#getName <em>Name</em>}</li>
 *   <li>{@link org.hive2hive.rcp.client.model.filetree.FileTreeElement#getParent <em>Parent</em>}</li>
 *   <li>{@link org.hive2hive.rcp.client.model.filetree.FileTreeElement#getAccessRights <em>Access Rights</em>}</li>
 *   <li>{@link org.hive2hive.rcp.client.model.filetree.FileTreeElement#getFile <em>File</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.hive2hive.rcp.client.model.filetree.FileTreePackage#getFileTreeElement()
 * @model abstract="true"
 * @generated
 */
public interface FileTreeElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(Path)
	 * @see org.hive2hive.rcp.client.model.filetree.FileTreePackage#getFileTreeElement_Path()
	 * @model dataType="org.hive2hive.rcp.client.model.filetree.Path"
	 * @generated
	 */
	Path getPath();

	/**
	 * Sets the value of the '{@link org.hive2hive.rcp.client.model.filetree.FileTreeElement#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(Path value);

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
	 * @see org.hive2hive.rcp.client.model.filetree.FileTreePackage#getFileTreeElement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.hive2hive.rcp.client.model.filetree.FileTreeElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.hive2hive.rcp.client.model.filetree.Container#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(Container)
	 * @see org.hive2hive.rcp.client.model.filetree.FileTreePackage#getFileTreeElement_Parent()
	 * @see org.hive2hive.rcp.client.model.filetree.Container#getChildren
	 * @model opposite="children" transient="false"
	 * @generated
	 */
	Container getParent();

	/**
	 * Sets the value of the '{@link org.hive2hive.rcp.client.model.filetree.FileTreeElement#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Container value);

	/**
	 * Returns the value of the '<em><b>Access Rights</b></em>' reference list.
	 * The list contents are of type {@link org.hive2hive.rcp.client.model.filetree.AccessRight}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Access Rights</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access Rights</em>' reference list.
	 * @see org.hive2hive.rcp.client.model.filetree.FileTreePackage#getFileTreeElement_AccessRights()
	 * @model
	 * @generated
	 */
	EList<AccessRight> getAccessRights();

	/**
	 * Returns the value of the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File</em>' attribute.
	 * @see #setFile(File)
	 * @see org.hive2hive.rcp.client.model.filetree.FileTreePackage#getFileTreeElement_File()
	 * @model dataType="org.hive2hive.rcp.client.model.filetree.File"
	 * @generated
	 */
	File getFile();

	/**
	 * Sets the value of the '{@link org.hive2hive.rcp.client.model.filetree.FileTreeElement#getFile <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File</em>' attribute.
	 * @see #getFile()
	 * @generated
	 */
	void setFile(File value);

} // FileTreeElement
