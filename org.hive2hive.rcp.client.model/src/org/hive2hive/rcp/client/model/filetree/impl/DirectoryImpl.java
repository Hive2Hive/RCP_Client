/**
 */
package org.hive2hive.rcp.client.model.filetree.impl;

import org.eclipse.emf.ecore.EClass;
import org.hive2hive.rcp.client.model.filetree.Directory;
import org.hive2hive.rcp.client.model.filetree.FileTreePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Directory</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DirectoryImpl extends ContainerImpl implements Directory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DirectoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FileTreePackage.Literals.DIRECTORY;
	}

	@Override
	public String toString() {
		return getName();
	}

} // DirectoryImpl
