/**
 */
package org.hive2hive.rcp.client.model.filetree.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.hive2hive.rcp.client.model.filetree.AccessRights;
import org.hive2hive.rcp.client.model.filetree.FileTreePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Access Rights</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.hive2hive.rcp.client.model.filetree.impl.AccessRightsImpl#isReadPermission <em>Read Permission</em>}</li>
 *   <li>{@link org.hive2hive.rcp.client.model.filetree.impl.AccessRightsImpl#isWritePermission <em>Write Permission</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AccessRightsImpl extends MinimalEObjectImpl.Container implements AccessRights {
	/**
	 * The default value of the '{@link #isReadPermission() <em>Read Permission</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReadPermission()
	 * @generated
	 * @ordered
	 */
	protected static final boolean READ_PERMISSION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReadPermission() <em>Read Permission</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReadPermission()
	 * @generated
	 * @ordered
	 */
	protected boolean readPermission = READ_PERMISSION_EDEFAULT;

	/**
	 * The default value of the '{@link #isWritePermission() <em>Write Permission</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWritePermission()
	 * @generated
	 * @ordered
	 */
	protected static final boolean WRITE_PERMISSION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isWritePermission() <em>Write Permission</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWritePermission()
	 * @generated
	 * @ordered
	 */
	protected boolean writePermission = WRITE_PERMISSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AccessRightsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FileTreePackage.Literals.ACCESS_RIGHTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReadPermission() {
		return readPermission;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReadPermission(boolean newReadPermission) {
		boolean oldReadPermission = readPermission;
		readPermission = newReadPermission;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FileTreePackage.ACCESS_RIGHTS__READ_PERMISSION, oldReadPermission, readPermission));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isWritePermission() {
		return writePermission;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWritePermission(boolean newWritePermission) {
		boolean oldWritePermission = writePermission;
		writePermission = newWritePermission;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FileTreePackage.ACCESS_RIGHTS__WRITE_PERMISSION, oldWritePermission, writePermission));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FileTreePackage.ACCESS_RIGHTS__READ_PERMISSION:
				return isReadPermission();
			case FileTreePackage.ACCESS_RIGHTS__WRITE_PERMISSION:
				return isWritePermission();
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
			case FileTreePackage.ACCESS_RIGHTS__READ_PERMISSION:
				setReadPermission((Boolean)newValue);
				return;
			case FileTreePackage.ACCESS_RIGHTS__WRITE_PERMISSION:
				setWritePermission((Boolean)newValue);
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
			case FileTreePackage.ACCESS_RIGHTS__READ_PERMISSION:
				setReadPermission(READ_PERMISSION_EDEFAULT);
				return;
			case FileTreePackage.ACCESS_RIGHTS__WRITE_PERMISSION:
				setWritePermission(WRITE_PERMISSION_EDEFAULT);
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
			case FileTreePackage.ACCESS_RIGHTS__READ_PERMISSION:
				return readPermission != READ_PERMISSION_EDEFAULT;
			case FileTreePackage.ACCESS_RIGHTS__WRITE_PERMISSION:
				return writePermission != WRITE_PERMISSION_EDEFAULT;
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
		result.append(" (readPermission: ");
		result.append(readPermission);
		result.append(", writePermission: ");
		result.append(writePermission);
		result.append(')');
		return result.toString();
	}

} //AccessRightsImpl
