/**
 */
package org.hive2hive.rcp.client.model.filetree.impl;

import java.io.File;

import java.nio.file.Path;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.hive2hive.rcp.client.model.filetree.AccessRight;
import org.hive2hive.rcp.client.model.filetree.FileTreePackage;
import org.hive2hive.rcp.client.model.filetree.TreeElement;
import org.hive2hive.rcp.client.model.filetree.Version;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tree Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.hive2hive.rcp.client.model.filetree.impl.TreeElementImpl#getPath <em>Path</em>}</li>
 *   <li>{@link org.hive2hive.rcp.client.model.filetree.impl.TreeElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.hive2hive.rcp.client.model.filetree.impl.TreeElementImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.hive2hive.rcp.client.model.filetree.impl.TreeElementImpl#getAccessRights <em>Access Rights</em>}</li>
 *   <li>{@link org.hive2hive.rcp.client.model.filetree.impl.TreeElementImpl#getFile <em>File</em>}</li>
 *   <li>{@link org.hive2hive.rcp.client.model.filetree.impl.TreeElementImpl#getVersions <em>Versions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TreeElementImpl extends MinimalEObjectImpl.Container implements TreeElement {
	/**
	 * The default value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected static final Path PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected Path path = PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAccessRights() <em>Access Rights</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessRights()
	 * @generated
	 * @ordered
	 */
	protected EList<AccessRight> accessRights;

	/**
	 * The default value of the '{@link #getFile() <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFile()
	 * @generated
	 * @ordered
	 */
	protected static final File FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFile() <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFile()
	 * @generated
	 * @ordered
	 */
	protected File file = FILE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVersions() <em>Versions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersions()
	 * @generated
	 * @ordered
	 */
	protected EList<Version> versions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TreeElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FileTreePackage.Literals.TREE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Path getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPath(Path newPath) {
		Path oldPath = path;
		path = newPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FileTreePackage.TREE_ELEMENT__PATH, oldPath, path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FileTreePackage.TREE_ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.hive2hive.rcp.client.model.filetree.Container getParent() {
		if (eContainerFeatureID() != FileTreePackage.TREE_ELEMENT__PARENT) return null;
		return (org.hive2hive.rcp.client.model.filetree.Container)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(org.hive2hive.rcp.client.model.filetree.Container newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, FileTreePackage.TREE_ELEMENT__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(org.hive2hive.rcp.client.model.filetree.Container newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != FileTreePackage.TREE_ELEMENT__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, FileTreePackage.CONTAINER__CHILDREN, org.hive2hive.rcp.client.model.filetree.Container.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FileTreePackage.TREE_ELEMENT__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AccessRight> getAccessRights() {
		if (accessRights == null) {
			accessRights = new EObjectResolvingEList<AccessRight>(AccessRight.class, this, FileTreePackage.TREE_ELEMENT__ACCESS_RIGHTS);
		}
		return accessRights;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public File getFile() {
		return file;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFile(File newFile) {
		File oldFile = file;
		file = newFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FileTreePackage.TREE_ELEMENT__FILE, oldFile, file));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Version> getVersions() {
		if (versions == null) {
			versions = new EObjectResolvingEList<Version>(Version.class, this, FileTreePackage.TREE_ELEMENT__VERSIONS);
		}
		return versions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FileTreePackage.TREE_ELEMENT__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((org.hive2hive.rcp.client.model.filetree.Container)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FileTreePackage.TREE_ELEMENT__PARENT:
				return basicSetParent(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case FileTreePackage.TREE_ELEMENT__PARENT:
				return eInternalContainer().eInverseRemove(this, FileTreePackage.CONTAINER__CHILDREN, org.hive2hive.rcp.client.model.filetree.Container.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FileTreePackage.TREE_ELEMENT__PATH:
				return getPath();
			case FileTreePackage.TREE_ELEMENT__NAME:
				return getName();
			case FileTreePackage.TREE_ELEMENT__PARENT:
				return getParent();
			case FileTreePackage.TREE_ELEMENT__ACCESS_RIGHTS:
				return getAccessRights();
			case FileTreePackage.TREE_ELEMENT__FILE:
				return getFile();
			case FileTreePackage.TREE_ELEMENT__VERSIONS:
				return getVersions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FileTreePackage.TREE_ELEMENT__PATH:
				setPath((Path)newValue);
				return;
			case FileTreePackage.TREE_ELEMENT__NAME:
				setName((String)newValue);
				return;
			case FileTreePackage.TREE_ELEMENT__PARENT:
				setParent((org.hive2hive.rcp.client.model.filetree.Container)newValue);
				return;
			case FileTreePackage.TREE_ELEMENT__ACCESS_RIGHTS:
				getAccessRights().clear();
				getAccessRights().addAll((Collection<? extends AccessRight>)newValue);
				return;
			case FileTreePackage.TREE_ELEMENT__FILE:
				setFile((File)newValue);
				return;
			case FileTreePackage.TREE_ELEMENT__VERSIONS:
				getVersions().clear();
				getVersions().addAll((Collection<? extends Version>)newValue);
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
			case FileTreePackage.TREE_ELEMENT__PATH:
				setPath(PATH_EDEFAULT);
				return;
			case FileTreePackage.TREE_ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FileTreePackage.TREE_ELEMENT__PARENT:
				setParent((org.hive2hive.rcp.client.model.filetree.Container)null);
				return;
			case FileTreePackage.TREE_ELEMENT__ACCESS_RIGHTS:
				getAccessRights().clear();
				return;
			case FileTreePackage.TREE_ELEMENT__FILE:
				setFile(FILE_EDEFAULT);
				return;
			case FileTreePackage.TREE_ELEMENT__VERSIONS:
				getVersions().clear();
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
			case FileTreePackage.TREE_ELEMENT__PATH:
				return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
			case FileTreePackage.TREE_ELEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FileTreePackage.TREE_ELEMENT__PARENT:
				return getParent() != null;
			case FileTreePackage.TREE_ELEMENT__ACCESS_RIGHTS:
				return accessRights != null && !accessRights.isEmpty();
			case FileTreePackage.TREE_ELEMENT__FILE:
				return FILE_EDEFAULT == null ? file != null : !FILE_EDEFAULT.equals(file);
			case FileTreePackage.TREE_ELEMENT__VERSIONS:
				return versions != null && !versions.isEmpty();
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
		result.append(" (path: ");
		result.append(path);
		result.append(", name: ");
		result.append(name);
		result.append(", file: ");
		result.append(file);
		result.append(')');
		return result.toString();
	}

} //TreeElementImpl
