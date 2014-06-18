/**
 */
package org.hive2hive.rcp.client.model.uimodel.impl;

import java.nio.file.Path;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.hive2hive.rcp.client.model.filetree.Tree;

import org.hive2hive.rcp.client.model.uimodel.UiModelPackage;
import org.hive2hive.rcp.client.model.uimodel.User;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.hive2hive.rcp.client.model.uimodel.impl.UserImpl#getNetworkTree <em>Network Tree</em>}</li>
 *   <li>{@link org.hive2hive.rcp.client.model.uimodel.impl.UserImpl#getLocalTree <em>Local Tree</em>}</li>
 *   <li>{@link org.hive2hive.rcp.client.model.uimodel.impl.UserImpl#getUserId <em>User Id</em>}</li>
 *   <li>{@link org.hive2hive.rcp.client.model.uimodel.impl.UserImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link org.hive2hive.rcp.client.model.uimodel.impl.UserImpl#getPin <em>Pin</em>}</li>
 *   <li>{@link org.hive2hive.rcp.client.model.uimodel.impl.UserImpl#getRootDir <em>Root Dir</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UserImpl extends MinimalEObjectImpl.Container implements User {
	/**
	 * The cached value of the '{@link #getNetworkTree() <em>Network Tree</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNetworkTree()
	 * @generated
	 * @ordered
	 */
	protected Tree networkTree;

	/**
	 * The cached value of the '{@link #getLocalTree() <em>Local Tree</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalTree()
	 * @generated
	 * @ordered
	 */
	protected Tree localTree;

	/**
	 * The default value of the '{@link #getUserId() <em>User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserId()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUserId() <em>User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserId()
	 * @generated
	 * @ordered
	 */
	protected String userId = USER_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected static final String PASSWORD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
	protected String password = PASSWORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getPin() <em>Pin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPin()
	 * @generated
	 * @ordered
	 */
	protected static final String PIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPin() <em>Pin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPin()
	 * @generated
	 * @ordered
	 */
	protected String pin = PIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getRootDir() <em>Root Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootDir()
	 * @generated
	 * @ordered
	 */
	protected static final Path ROOT_DIR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRootDir() <em>Root Dir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootDir()
	 * @generated
	 * @ordered
	 */
	protected Path rootDir = ROOT_DIR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UserImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UiModelPackage.Literals.USER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tree getNetworkTree() {
		if (networkTree != null && networkTree.eIsProxy()) {
			InternalEObject oldNetworkTree = (InternalEObject)networkTree;
			networkTree = (Tree)eResolveProxy(oldNetworkTree);
			if (networkTree != oldNetworkTree) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UiModelPackage.USER__NETWORK_TREE, oldNetworkTree, networkTree));
			}
		}
		return networkTree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tree basicGetNetworkTree() {
		return networkTree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNetworkTree(Tree newNetworkTree) {
		Tree oldNetworkTree = networkTree;
		networkTree = newNetworkTree;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiModelPackage.USER__NETWORK_TREE, oldNetworkTree, networkTree));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tree getLocalTree() {
		if (localTree != null && localTree.eIsProxy()) {
			InternalEObject oldLocalTree = (InternalEObject)localTree;
			localTree = (Tree)eResolveProxy(oldLocalTree);
			if (localTree != oldLocalTree) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UiModelPackage.USER__LOCAL_TREE, oldLocalTree, localTree));
			}
		}
		return localTree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tree basicGetLocalTree() {
		return localTree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalTree(Tree newLocalTree) {
		Tree oldLocalTree = localTree;
		localTree = newLocalTree;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiModelPackage.USER__LOCAL_TREE, oldLocalTree, localTree));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserId(String newUserId) {
		String oldUserId = userId;
		userId = newUserId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiModelPackage.USER__USER_ID, oldUserId, userId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassword(String newPassword) {
		String oldPassword = password;
		password = newPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiModelPackage.USER__PASSWORD, oldPassword, password));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPin() {
		return pin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPin(String newPin) {
		String oldPin = pin;
		pin = newPin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiModelPackage.USER__PIN, oldPin, pin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Path getRootDir() {
		return rootDir;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRootDir(Path newRootDir) {
		Path oldRootDir = rootDir;
		rootDir = newRootDir;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiModelPackage.USER__ROOT_DIR, oldRootDir, rootDir));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UiModelPackage.USER__NETWORK_TREE:
				if (resolve) return getNetworkTree();
				return basicGetNetworkTree();
			case UiModelPackage.USER__LOCAL_TREE:
				if (resolve) return getLocalTree();
				return basicGetLocalTree();
			case UiModelPackage.USER__USER_ID:
				return getUserId();
			case UiModelPackage.USER__PASSWORD:
				return getPassword();
			case UiModelPackage.USER__PIN:
				return getPin();
			case UiModelPackage.USER__ROOT_DIR:
				return getRootDir();
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
			case UiModelPackage.USER__NETWORK_TREE:
				setNetworkTree((Tree)newValue);
				return;
			case UiModelPackage.USER__LOCAL_TREE:
				setLocalTree((Tree)newValue);
				return;
			case UiModelPackage.USER__USER_ID:
				setUserId((String)newValue);
				return;
			case UiModelPackage.USER__PASSWORD:
				setPassword((String)newValue);
				return;
			case UiModelPackage.USER__PIN:
				setPin((String)newValue);
				return;
			case UiModelPackage.USER__ROOT_DIR:
				setRootDir((Path)newValue);
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
			case UiModelPackage.USER__NETWORK_TREE:
				setNetworkTree((Tree)null);
				return;
			case UiModelPackage.USER__LOCAL_TREE:
				setLocalTree((Tree)null);
				return;
			case UiModelPackage.USER__USER_ID:
				setUserId(USER_ID_EDEFAULT);
				return;
			case UiModelPackage.USER__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
				return;
			case UiModelPackage.USER__PIN:
				setPin(PIN_EDEFAULT);
				return;
			case UiModelPackage.USER__ROOT_DIR:
				setRootDir(ROOT_DIR_EDEFAULT);
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
			case UiModelPackage.USER__NETWORK_TREE:
				return networkTree != null;
			case UiModelPackage.USER__LOCAL_TREE:
				return localTree != null;
			case UiModelPackage.USER__USER_ID:
				return USER_ID_EDEFAULT == null ? userId != null : !USER_ID_EDEFAULT.equals(userId);
			case UiModelPackage.USER__PASSWORD:
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
			case UiModelPackage.USER__PIN:
				return PIN_EDEFAULT == null ? pin != null : !PIN_EDEFAULT.equals(pin);
			case UiModelPackage.USER__ROOT_DIR:
				return ROOT_DIR_EDEFAULT == null ? rootDir != null : !ROOT_DIR_EDEFAULT.equals(rootDir);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

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

} //UserImpl
