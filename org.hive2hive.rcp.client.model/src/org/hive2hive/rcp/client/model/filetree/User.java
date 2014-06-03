/**
 */
package org.hive2hive.rcp.client.model.filetree;

import java.nio.file.Path;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.hive2hive.rcp.client.model.filetree.User#getUserId <em>User Id</em>}</li>
 *   <li>{@link org.hive2hive.rcp.client.model.filetree.User#getPassword <em>Password</em>}</li>
 *   <li>{@link org.hive2hive.rcp.client.model.filetree.User#getPin <em>Pin</em>}</li>
 *   <li>{@link org.hive2hive.rcp.client.model.filetree.User#getRootDir <em>Root Dir</em>}</li>
 *   <li>{@link org.hive2hive.rcp.client.model.filetree.User#getFileTree <em>File Tree</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.hive2hive.rcp.client.model.filetree.FileTreePackage#getUser()
 * @model
 * @generated
 */
public interface User extends EObject {
	/**
	 * Returns the value of the '<em><b>User Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Id</em>' attribute.
	 * @see #setUserId(String)
	 * @see org.hive2hive.rcp.client.model.filetree.FileTreePackage#getUser_UserId()
	 * @model
	 * @generated
	 */
	String getUserId();

	/**
	 * Sets the value of the '{@link org.hive2hive.rcp.client.model.filetree.User#getUserId <em>User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Id</em>' attribute.
	 * @see #getUserId()
	 * @generated
	 */
	void setUserId(String value);

	/**
	 * Returns the value of the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @see org.hive2hive.rcp.client.model.filetree.FileTreePackage#getUser_Password()
	 * @model
	 * @generated
	 */
	String getPassword();

	/**
	 * Sets the value of the '{@link org.hive2hive.rcp.client.model.filetree.User#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(String value);

	/**
	 * Returns the value of the '<em><b>Pin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pin</em>' attribute.
	 * @see #setPin(String)
	 * @see org.hive2hive.rcp.client.model.filetree.FileTreePackage#getUser_Pin()
	 * @model
	 * @generated
	 */
	String getPin();

	/**
	 * Sets the value of the '{@link org.hive2hive.rcp.client.model.filetree.User#getPin <em>Pin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pin</em>' attribute.
	 * @see #getPin()
	 * @generated
	 */
	void setPin(String value);

	/**
	 * Returns the value of the '<em><b>Root Dir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Dir</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Dir</em>' attribute.
	 * @see #setRootDir(Path)
	 * @see org.hive2hive.rcp.client.model.filetree.FileTreePackage#getUser_RootDir()
	 * @model dataType="org.hive2hive.rcp.client.model.filetree.Path"
	 * @generated
	 */
	Path getRootDir();

	/**
	 * Sets the value of the '{@link org.hive2hive.rcp.client.model.filetree.User#getRootDir <em>Root Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root Dir</em>' attribute.
	 * @see #getRootDir()
	 * @generated
	 */
	void setRootDir(Path value);

	/**
	 * Returns the value of the '<em><b>File Tree</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Tree</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Tree</em>' reference.
	 * @see #setFileTree(FileTree)
	 * @see org.hive2hive.rcp.client.model.filetree.FileTreePackage#getUser_FileTree()
	 * @model
	 * @generated
	 */
	FileTree getFileTree();

	/**
	 * Sets the value of the '{@link org.hive2hive.rcp.client.model.filetree.User#getFileTree <em>File Tree</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Tree</em>' reference.
	 * @see #getFileTree()
	 * @generated
	 */
	void setFileTree(FileTree value);

} // User
