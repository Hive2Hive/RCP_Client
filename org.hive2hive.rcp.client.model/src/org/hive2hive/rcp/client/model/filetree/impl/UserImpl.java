/**
 */
package org.hive2hive.rcp.client.model.filetree.impl;

import java.nio.file.Path;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.hive2hive.rcp.client.model.filetree.FileTreePackage;
import org.hive2hive.rcp.client.model.filetree.Tree;
import org.hive2hive.rcp.client.model.filetree.User;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.hive2hive.rcp.client.model.filetree.impl.UserImpl#getUserId <em>User Id</em>}</li>
 * <li>{@link org.hive2hive.rcp.client.model.filetree.impl.UserImpl#getPassword <em>Password</em>}</li>
 * <li>{@link org.hive2hive.rcp.client.model.filetree.impl.UserImpl#getPin <em>Pin</em>}</li>
 * <li>{@link org.hive2hive.rcp.client.model.filetree.impl.UserImpl#getRootDir <em>Root Dir</em>}</li>
 * <li>{@link org.hive2hive.rcp.client.model.filetree.impl.UserImpl#getFileTree <em>File Tree</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class UserImpl extends MinimalEObjectImpl.Container implements User {
	/**
	 * The default value of the '{@link #getUserId() <em>User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getUserId()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUserId() <em>User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getUserId()
	 * @generated
	 * @ordered
	 */
	protected String userId = USER_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected String password = PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getPin() <em>Pin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPin()
	 * @generated
	 * @ordered
	 */
	protected static final String PIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPin() <em>Pin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPin()
	 * @generated
	 * @ordered
	 */
	protected String pin = PIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getRootDir() <em>Root Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRootDir()
	 * @generated
	 * @ordered
	 */
	protected static final Path ROOT_DIR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRootDir() <em>Root Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRootDir()
	 * @generated
	 * @ordered
	 */
	protected Path rootDir = ROOT_DIR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFileTree() <em>File Tree</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getFileTree()
	 * @generated
	 * @ordered
	 */
	protected Tree fileTree;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected UserImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FileTreePackage.Literals.USER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getUserId() {
		return userId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setUserId(String newUserId) {
		String oldUserId = userId;
		userId = newUserId;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, FileTreePackage.USER__USER_ID, oldUserId, userId));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getPassword() {
		return password;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setPassword(String newPassword) {
		String oldPassword = password;
		password = newPassword;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, FileTreePackage.USER__PASSWORD, oldPassword, password));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getPin() {
		return pin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setPin(String newPin) {
		String oldPin = pin;
		pin = newPin;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, FileTreePackage.USER__PIN, oldPin, pin));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Path getRootDir() {
		return rootDir;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setRootDir(Path newRootDir) {
		Path oldRootDir = rootDir;
		rootDir = newRootDir;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, FileTreePackage.USER__ROOT_DIR, oldRootDir, rootDir));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Tree getFileTree() {
		if (fileTree != null && fileTree.eIsProxy()) {
			InternalEObject oldFileTree = (InternalEObject) fileTree;
			fileTree = (Tree) eResolveProxy(oldFileTree);
			if (fileTree != oldFileTree) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FileTreePackage.USER__FILE_TREE, oldFileTree,
							fileTree));
				}
			}
		}
		return fileTree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Tree basicGetFileTree() {
		return fileTree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setFileTree(Tree newFileTree) {
		Tree oldFileTree = fileTree;
		fileTree = newFileTree;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, FileTreePackage.USER__FILE_TREE, oldFileTree, fileTree));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FileTreePackage.USER__USER_ID:
				return getUserId();
			case FileTreePackage.USER__PASSWORD:
				return getPassword();
			case FileTreePackage.USER__PIN:
				return getPin();
			case FileTreePackage.USER__ROOT_DIR:
				return getRootDir();
			case FileTreePackage.USER__FILE_TREE:
				if (resolve) {
					return getFileTree();
				}
				return basicGetFileTree();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FileTreePackage.USER__USER_ID:
				setUserId((String) newValue);
				return;
			case FileTreePackage.USER__PASSWORD:
				setPassword((String) newValue);
				return;
			case FileTreePackage.USER__PIN:
				setPin((String) newValue);
				return;
			case FileTreePackage.USER__ROOT_DIR:
				setRootDir((Path) newValue);
				return;
			case FileTreePackage.USER__FILE_TREE:
				setFileTree((Tree) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FileTreePackage.USER__USER_ID:
				setUserId(USER_ID_EDEFAULT);
				return;
			case FileTreePackage.USER__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
				return;
			case FileTreePackage.USER__PIN:
				setPin(PIN_EDEFAULT);
				return;
			case FileTreePackage.USER__ROOT_DIR:
				setRootDir(ROOT_DIR_EDEFAULT);
				return;
			case FileTreePackage.USER__FILE_TREE:
				setFileTree((Tree) null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FileTreePackage.USER__USER_ID:
				return USER_ID_EDEFAULT == null ? userId != null : !USER_ID_EDEFAULT.equals(userId);
			case FileTreePackage.USER__PASSWORD:
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
			case FileTreePackage.USER__PIN:
				return PIN_EDEFAULT == null ? pin != null : !PIN_EDEFAULT.equals(pin);
			case FileTreePackage.USER__ROOT_DIR:
				return ROOT_DIR_EDEFAULT == null ? rootDir != null : !ROOT_DIR_EDEFAULT.equals(rootDir);
			case FileTreePackage.USER__FILE_TREE:
				return fileTree != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (userId: ");
		result.append(userId);
		result.append(", password: ");
		result.append(password);
		result.append(", pin: ");
		result.append(pin);
		result.append(", rootDir: ");
		result.append(rootDir);
		result.append(')');
		return result.toString();
	}

} // UserImpl
