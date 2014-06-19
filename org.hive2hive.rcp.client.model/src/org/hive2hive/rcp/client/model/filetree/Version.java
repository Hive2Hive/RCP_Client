/**
 */
package org.hive2hive.rcp.client.model.filetree;

import java.lang.Comparable;
import java.math.BigInteger;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Version</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.hive2hive.rcp.client.model.filetree.Version#getIndex <em>Index</em>}</li>
 *   <li>{@link org.hive2hive.rcp.client.model.filetree.Version#getSize <em>Size</em>}</li>
 *   <li>{@link org.hive2hive.rcp.client.model.filetree.Version#getTimeStamp <em>Time Stamp</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.hive2hive.rcp.client.model.filetree.FileTreePackage#getVersion()
 * @model superTypes="org.hive2hive.rcp.client.model.filetree.VersionComparable"
 * @generated
 */
public interface Version extends EObject, Comparable<Version> {
	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #setIndex(int)
	 * @see org.hive2hive.rcp.client.model.filetree.FileTreePackage#getVersion_Index()
	 * @model
	 * @generated
	 */
	int getIndex();

	/**
	 * Sets the value of the '{@link org.hive2hive.rcp.client.model.filetree.Version#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(int value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(BigInteger)
	 * @see org.hive2hive.rcp.client.model.filetree.FileTreePackage#getVersion_Size()
	 * @model
	 * @generated
	 */
	BigInteger getSize();

	/**
	 * Sets the value of the '{@link org.hive2hive.rcp.client.model.filetree.Version#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Time Stamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Stamp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Stamp</em>' attribute.
	 * @see #setTimeStamp(long)
	 * @see org.hive2hive.rcp.client.model.filetree.FileTreePackage#getVersion_TimeStamp()
	 * @model
	 * @generated
	 */
	long getTimeStamp();

	/**
	 * Sets the value of the '{@link org.hive2hive.rcp.client.model.filetree.Version#getTimeStamp <em>Time Stamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Stamp</em>' attribute.
	 * @see #getTimeStamp()
	 * @generated
	 */
	void setTimeStamp(long value);

} // Version
