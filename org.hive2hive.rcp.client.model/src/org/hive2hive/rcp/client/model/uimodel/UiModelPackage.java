/**
 */
package org.hive2hive.rcp.client.model.uimodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.hive2hive.rcp.client.model.uimodel.UiModelFactory
 * @model kind="package"
 * @generated
 */
public interface UiModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "uimodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://uimodel/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "uimodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UiModelPackage eINSTANCE = org.hive2hive.rcp.client.model.uimodel.impl.UiModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.hive2hive.rcp.client.model.uimodel.impl.UserImpl <em>User</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hive2hive.rcp.client.model.uimodel.impl.UserImpl
	 * @see org.hive2hive.rcp.client.model.uimodel.impl.UiModelPackageImpl#getUser()
	 * @generated
	 */
	int USER = 0;

	/**
	 * The feature id for the '<em><b>Network Tree</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__NETWORK_TREE = 0;

	/**
	 * The feature id for the '<em><b>Local Tree</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__LOCAL_TREE = 1;

	/**
	 * The feature id for the '<em><b>User Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__USER_ID = 2;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__PASSWORD = 3;

	/**
	 * The feature id for the '<em><b>Pin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__PIN = 4;

	/**
	 * The feature id for the '<em><b>Root Dir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__ROOT_DIR = 5;

	/**
	 * The number of structural features of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.hive2hive.rcp.client.model.uimodel.impl.UiModelImpl <em>Ui Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hive2hive.rcp.client.model.uimodel.impl.UiModelImpl
	 * @see org.hive2hive.rcp.client.model.uimodel.impl.UiModelPackageImpl#getUiModel()
	 * @generated
	 */
	int UI_MODEL = 1;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_MODEL__USER = 0;

	/**
	 * The feature id for the '<em><b>Network</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_MODEL__NETWORK = 1;

	/**
	 * The number of structural features of the '<em>Ui Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_MODEL_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Ui Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.hive2hive.rcp.client.model.uimodel.impl.NetworkImpl <em>Network</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hive2hive.rcp.client.model.uimodel.impl.NetworkImpl
	 * @see org.hive2hive.rcp.client.model.uimodel.impl.UiModelPackageImpl#getNetwork()
	 * @generated
	 */
	int NETWORK = 2;

	/**
	 * The number of structural features of the '<em>Network</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Network</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.hive2hive.rcp.client.model.uimodel.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User</em>'.
	 * @see org.hive2hive.rcp.client.model.uimodel.User
	 * @generated
	 */
	EClass getUser();

	/**
	 * Returns the meta object for the reference '{@link org.hive2hive.rcp.client.model.uimodel.User#getNetworkTree <em>Network Tree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Network Tree</em>'.
	 * @see org.hive2hive.rcp.client.model.uimodel.User#getNetworkTree()
	 * @see #getUser()
	 * @generated
	 */
	EReference getUser_NetworkTree();

	/**
	 * Returns the meta object for the reference '{@link org.hive2hive.rcp.client.model.uimodel.User#getLocalTree <em>Local Tree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Local Tree</em>'.
	 * @see org.hive2hive.rcp.client.model.uimodel.User#getLocalTree()
	 * @see #getUser()
	 * @generated
	 */
	EReference getUser_LocalTree();

	/**
	 * Returns the meta object for the attribute '{@link org.hive2hive.rcp.client.model.uimodel.User#getUserId <em>User Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Id</em>'.
	 * @see org.hive2hive.rcp.client.model.uimodel.User#getUserId()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_UserId();

	/**
	 * Returns the meta object for the attribute '{@link org.hive2hive.rcp.client.model.uimodel.User#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see org.hive2hive.rcp.client.model.uimodel.User#getPassword()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Password();

	/**
	 * Returns the meta object for the attribute '{@link org.hive2hive.rcp.client.model.uimodel.User#getPin <em>Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pin</em>'.
	 * @see org.hive2hive.rcp.client.model.uimodel.User#getPin()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Pin();

	/**
	 * Returns the meta object for the attribute '{@link org.hive2hive.rcp.client.model.uimodel.User#getRootDir <em>Root Dir</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Root Dir</em>'.
	 * @see org.hive2hive.rcp.client.model.uimodel.User#getRootDir()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_RootDir();

	/**
	 * Returns the meta object for class '{@link org.hive2hive.rcp.client.model.uimodel.UiModel <em>Ui Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ui Model</em>'.
	 * @see org.hive2hive.rcp.client.model.uimodel.UiModel
	 * @generated
	 */
	EClass getUiModel();

	/**
	 * Returns the meta object for the reference '{@link org.hive2hive.rcp.client.model.uimodel.UiModel#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see org.hive2hive.rcp.client.model.uimodel.UiModel#getUser()
	 * @see #getUiModel()
	 * @generated
	 */
	EReference getUiModel_User();

	/**
	 * Returns the meta object for the reference '{@link org.hive2hive.rcp.client.model.uimodel.UiModel#getNetwork <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Network</em>'.
	 * @see org.hive2hive.rcp.client.model.uimodel.UiModel#getNetwork()
	 * @see #getUiModel()
	 * @generated
	 */
	EReference getUiModel_Network();

	/**
	 * Returns the meta object for class '{@link org.hive2hive.rcp.client.model.uimodel.Network <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Network</em>'.
	 * @see org.hive2hive.rcp.client.model.uimodel.Network
	 * @generated
	 */
	EClass getNetwork();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UiModelFactory getUiModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.hive2hive.rcp.client.model.uimodel.impl.UserImpl <em>User</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hive2hive.rcp.client.model.uimodel.impl.UserImpl
		 * @see org.hive2hive.rcp.client.model.uimodel.impl.UiModelPackageImpl#getUser()
		 * @generated
		 */
		EClass USER = eINSTANCE.getUser();

		/**
		 * The meta object literal for the '<em><b>Network Tree</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER__NETWORK_TREE = eINSTANCE.getUser_NetworkTree();

		/**
		 * The meta object literal for the '<em><b>Local Tree</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER__LOCAL_TREE = eINSTANCE.getUser_LocalTree();

		/**
		 * The meta object literal for the '<em><b>User Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__USER_ID = eINSTANCE.getUser_UserId();

		/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__PASSWORD = eINSTANCE.getUser_Password();

		/**
		 * The meta object literal for the '<em><b>Pin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__PIN = eINSTANCE.getUser_Pin();

		/**
		 * The meta object literal for the '<em><b>Root Dir</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__ROOT_DIR = eINSTANCE.getUser_RootDir();

		/**
		 * The meta object literal for the '{@link org.hive2hive.rcp.client.model.uimodel.impl.UiModelImpl <em>Ui Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hive2hive.rcp.client.model.uimodel.impl.UiModelImpl
		 * @see org.hive2hive.rcp.client.model.uimodel.impl.UiModelPackageImpl#getUiModel()
		 * @generated
		 */
		EClass UI_MODEL = eINSTANCE.getUiModel();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UI_MODEL__USER = eINSTANCE.getUiModel_User();

		/**
		 * The meta object literal for the '<em><b>Network</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UI_MODEL__NETWORK = eINSTANCE.getUiModel_Network();

		/**
		 * The meta object literal for the '{@link org.hive2hive.rcp.client.model.uimodel.impl.NetworkImpl <em>Network</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hive2hive.rcp.client.model.uimodel.impl.NetworkImpl
		 * @see org.hive2hive.rcp.client.model.uimodel.impl.UiModelPackageImpl#getNetwork()
		 * @generated
		 */
		EClass NETWORK = eINSTANCE.getNetwork();

	}

} //UiModelPackage
