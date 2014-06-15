/**
 */
package org.hive2hive.rcp.client.model.filetree;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see org.hive2hive.rcp.client.model.filetree.FileTreeFactory
 * @model kind="package"
 * @generated
 */
public interface FileTreePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "filetree";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://filetree/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "filetree";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FileTreePackage eINSTANCE = org.hive2hive.rcp.client.model.filetree.impl.FileTreePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.hive2hive.rcp.client.model.filetree.impl.TreeElementImpl <em>Tree Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hive2hive.rcp.client.model.filetree.impl.TreeElementImpl
	 * @see org.hive2hive.rcp.client.model.filetree.impl.FileTreePackageImpl#getTreeElement()
	 * @generated
	 */
	int TREE_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ELEMENT__PATH = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ELEMENT__NAME = 1;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ELEMENT__PARENT = 2;

	/**
	 * The feature id for the '<em><b>Access Rights</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ELEMENT__ACCESS_RIGHTS = 3;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ELEMENT__FILE = 4;

	/**
	 * The number of structural features of the '<em>Tree Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ELEMENT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.hive2hive.rcp.client.model.filetree.impl.ContainerImpl <em>Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hive2hive.rcp.client.model.filetree.impl.ContainerImpl
	 * @see org.hive2hive.rcp.client.model.filetree.impl.FileTreePackageImpl#getContainer()
	 * @generated
	 */
	int CONTAINER = 4;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__PATH = TREE_ELEMENT__PATH;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__NAME = TREE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__PARENT = TREE_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Access Rights</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__ACCESS_RIGHTS = TREE_ELEMENT__ACCESS_RIGHTS;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__FILE = TREE_ELEMENT__FILE;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__CHILDREN = TREE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_FEATURE_COUNT = TREE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.hive2hive.rcp.client.model.filetree.impl.TreeImpl <em>Tree</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hive2hive.rcp.client.model.filetree.impl.TreeImpl
	 * @see org.hive2hive.rcp.client.model.filetree.impl.FileTreePackageImpl#getTree()
	 * @generated
	 */
	int TREE = 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__PATH = CONTAINER__PATH;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__NAME = CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__PARENT = CONTAINER__PARENT;

	/**
	 * The feature id for the '<em><b>Access Rights</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__ACCESS_RIGHTS = CONTAINER__ACCESS_RIGHTS;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__FILE = CONTAINER__FILE;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__CHILDREN = CONTAINER__CHILDREN;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__ELEMENTS = CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_FEATURE_COUNT = CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.hive2hive.rcp.client.model.filetree.impl.DirectoryImpl <em>Directory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hive2hive.rcp.client.model.filetree.impl.DirectoryImpl
	 * @see org.hive2hive.rcp.client.model.filetree.impl.FileTreePackageImpl#getDirectory()
	 * @generated
	 */
	int DIRECTORY = 2;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__PATH = CONTAINER__PATH;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__NAME = CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__PARENT = CONTAINER__PARENT;

	/**
	 * The feature id for the '<em><b>Access Rights</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__ACCESS_RIGHTS = CONTAINER__ACCESS_RIGHTS;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__FILE = CONTAINER__FILE;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__CHILDREN = CONTAINER__CHILDREN;

	/**
	 * The number of structural features of the '<em>Directory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_FEATURE_COUNT = CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.hive2hive.rcp.client.model.filetree.impl.FileImpl <em>File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hive2hive.rcp.client.model.filetree.impl.FileImpl
	 * @see org.hive2hive.rcp.client.model.filetree.impl.FileTreePackageImpl#getFile()
	 * @generated
	 */
	int FILE = 3;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__PATH = TREE_ELEMENT__PATH;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__NAME = TREE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__PARENT = TREE_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Access Rights</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__ACCESS_RIGHTS = TREE_ELEMENT__ACCESS_RIGHTS;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__FILE = TREE_ELEMENT__FILE;

	/**
	 * The number of structural features of the '<em>File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_FEATURE_COUNT = TREE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.hive2hive.rcp.client.model.filetree.impl.UserImpl <em>User</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hive2hive.rcp.client.model.filetree.impl.UserImpl
	 * @see org.hive2hive.rcp.client.model.filetree.impl.FileTreePackageImpl#getUser()
	 * @generated
	 */
	int USER = 5;

	/**
	 * The feature id for the '<em><b>User Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__USER_ID = 0;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__PASSWORD = 1;

	/**
	 * The feature id for the '<em><b>Pin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__PIN = 2;

	/**
	 * The feature id for the '<em><b>Root Dir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__ROOT_DIR = 3;

	/**
	 * The feature id for the '<em><b>File Tree</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__FILE_TREE = 4;

	/**
	 * The number of structural features of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.hive2hive.rcp.client.model.filetree.impl.PathToTreeElementMapImpl <em>Path To Tree Element Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hive2hive.rcp.client.model.filetree.impl.PathToTreeElementMapImpl
	 * @see org.hive2hive.rcp.client.model.filetree.impl.FileTreePackageImpl#getPathToTreeElementMap()
	 * @generated
	 */
	int PATH_TO_TREE_ELEMENT_MAP = 6;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_TO_TREE_ELEMENT_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_TO_TREE_ELEMENT_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Path To Tree Element Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_TO_TREE_ELEMENT_MAP_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.hive2hive.rcp.client.model.filetree.impl.AccessRightImpl <em>Access Right</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hive2hive.rcp.client.model.filetree.impl.AccessRightImpl
	 * @see org.hive2hive.rcp.client.model.filetree.impl.FileTreePackageImpl#getAccessRight()
	 * @generated
	 */
	int ACCESS_RIGHT = 7;

	/**
	 * The feature id for the '<em><b>Read Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_RIGHT__READ_PERMISSION = 0;

	/**
	 * The feature id for the '<em><b>Write Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_RIGHT__WRITE_PERMISSION = 1;

	/**
	 * The feature id for the '<em><b>User Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_RIGHT__USER_ID = 2;

	/**
	 * The number of structural features of the '<em>Access Right</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_RIGHT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '<em>Path</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.nio.file.Path
	 * @see org.hive2hive.rcp.client.model.filetree.impl.FileTreePackageImpl#getPath()
	 * @generated
	 */
	int PATH = 8;


	/**
	 * The meta object id for the '<em>Java Io File</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.io.File
	 * @see org.hive2hive.rcp.client.model.filetree.impl.FileTreePackageImpl#getJavaIoFile()
	 * @generated
	 */
	int JAVA_IO_FILE = 9;


	/**
	 * Returns the meta object for class '{@link org.hive2hive.rcp.client.model.filetree.Tree <em>Tree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tree</em>'.
	 * @see org.hive2hive.rcp.client.model.filetree.Tree
	 * @generated
	 */
	EClass getTree();

	/**
	 * Returns the meta object for the map '{@link org.hive2hive.rcp.client.model.filetree.Tree#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Elements</em>'.
	 * @see org.hive2hive.rcp.client.model.filetree.Tree#getElements()
	 * @see #getTree()
	 * @generated
	 */
	EReference getTree_Elements();

	/**
	 * Returns the meta object for class '{@link org.hive2hive.rcp.client.model.filetree.TreeElement <em>Tree Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tree Element</em>'.
	 * @see org.hive2hive.rcp.client.model.filetree.TreeElement
	 * @generated
	 */
	EClass getTreeElement();

	/**
	 * Returns the meta object for the attribute '{@link org.hive2hive.rcp.client.model.filetree.TreeElement#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.hive2hive.rcp.client.model.filetree.TreeElement#getPath()
	 * @see #getTreeElement()
	 * @generated
	 */
	EAttribute getTreeElement_Path();

	/**
	 * Returns the meta object for the attribute '{@link org.hive2hive.rcp.client.model.filetree.TreeElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.hive2hive.rcp.client.model.filetree.TreeElement#getName()
	 * @see #getTreeElement()
	 * @generated
	 */
	EAttribute getTreeElement_Name();

	/**
	 * Returns the meta object for the container reference '{@link org.hive2hive.rcp.client.model.filetree.TreeElement#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see org.hive2hive.rcp.client.model.filetree.TreeElement#getParent()
	 * @see #getTreeElement()
	 * @generated
	 */
	EReference getTreeElement_Parent();

	/**
	 * Returns the meta object for the reference list '{@link org.hive2hive.rcp.client.model.filetree.TreeElement#getAccessRights <em>Access Rights</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Access Rights</em>'.
	 * @see org.hive2hive.rcp.client.model.filetree.TreeElement#getAccessRights()
	 * @see #getTreeElement()
	 * @generated
	 */
	EReference getTreeElement_AccessRights();

	/**
	 * Returns the meta object for the attribute '{@link org.hive2hive.rcp.client.model.filetree.TreeElement#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File</em>'.
	 * @see org.hive2hive.rcp.client.model.filetree.TreeElement#getFile()
	 * @see #getTreeElement()
	 * @generated
	 */
	EAttribute getTreeElement_File();

	/**
	 * Returns the meta object for class '{@link org.hive2hive.rcp.client.model.filetree.Directory <em>Directory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Directory</em>'.
	 * @see org.hive2hive.rcp.client.model.filetree.Directory
	 * @generated
	 */
	EClass getDirectory();

	/**
	 * Returns the meta object for class '{@link org.hive2hive.rcp.client.model.filetree.File <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File</em>'.
	 * @see org.hive2hive.rcp.client.model.filetree.File
	 * @generated
	 */
	EClass getFile();

	/**
	 * Returns the meta object for class '{@link org.hive2hive.rcp.client.model.filetree.Container <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container</em>'.
	 * @see org.hive2hive.rcp.client.model.filetree.Container
	 * @generated
	 */
	EClass getContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.hive2hive.rcp.client.model.filetree.Container#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.hive2hive.rcp.client.model.filetree.Container#getChildren()
	 * @see #getContainer()
	 * @generated
	 */
	EReference getContainer_Children();

	/**
	 * Returns the meta object for class '{@link org.hive2hive.rcp.client.model.filetree.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User</em>'.
	 * @see org.hive2hive.rcp.client.model.filetree.User
	 * @generated
	 */
	EClass getUser();

	/**
	 * Returns the meta object for the attribute '{@link org.hive2hive.rcp.client.model.filetree.User#getUserId <em>User Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Id</em>'.
	 * @see org.hive2hive.rcp.client.model.filetree.User#getUserId()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_UserId();

	/**
	 * Returns the meta object for the attribute '{@link org.hive2hive.rcp.client.model.filetree.User#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see org.hive2hive.rcp.client.model.filetree.User#getPassword()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Password();

	/**
	 * Returns the meta object for the attribute '{@link org.hive2hive.rcp.client.model.filetree.User#getPin <em>Pin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pin</em>'.
	 * @see org.hive2hive.rcp.client.model.filetree.User#getPin()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Pin();

	/**
	 * Returns the meta object for the attribute '{@link org.hive2hive.rcp.client.model.filetree.User#getRootDir <em>Root Dir</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Root Dir</em>'.
	 * @see org.hive2hive.rcp.client.model.filetree.User#getRootDir()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_RootDir();

	/**
	 * Returns the meta object for the reference '{@link org.hive2hive.rcp.client.model.filetree.User#getFileTree <em>File Tree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>File Tree</em>'.
	 * @see org.hive2hive.rcp.client.model.filetree.User#getFileTree()
	 * @see #getUser()
	 * @generated
	 */
	EReference getUser_FileTree();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Path To Tree Element Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path To Tree Element Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.hive2hive.rcp.client.model.filetree.Path" keyRequired="true"
	 *        valueType="org.hive2hive.rcp.client.model.filetree.TreeElement" valueRequired="true"
	 * @generated
	 */
	EClass getPathToTreeElementMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getPathToTreeElementMap()
	 * @generated
	 */
	EAttribute getPathToTreeElementMap_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getPathToTreeElementMap()
	 * @generated
	 */
	EReference getPathToTreeElementMap_Value();

	/**
	 * Returns the meta object for class '{@link org.hive2hive.rcp.client.model.filetree.AccessRight <em>Access Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Access Right</em>'.
	 * @see org.hive2hive.rcp.client.model.filetree.AccessRight
	 * @generated
	 */
	EClass getAccessRight();

	/**
	 * Returns the meta object for the attribute '{@link org.hive2hive.rcp.client.model.filetree.AccessRight#isReadPermission <em>Read Permission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Permission</em>'.
	 * @see org.hive2hive.rcp.client.model.filetree.AccessRight#isReadPermission()
	 * @see #getAccessRight()
	 * @generated
	 */
	EAttribute getAccessRight_ReadPermission();

	/**
	 * Returns the meta object for the attribute '{@link org.hive2hive.rcp.client.model.filetree.AccessRight#isWritePermission <em>Write Permission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Write Permission</em>'.
	 * @see org.hive2hive.rcp.client.model.filetree.AccessRight#isWritePermission()
	 * @see #getAccessRight()
	 * @generated
	 */
	EAttribute getAccessRight_WritePermission();

	/**
	 * Returns the meta object for the attribute '{@link org.hive2hive.rcp.client.model.filetree.AccessRight#getUserId <em>User Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Id</em>'.
	 * @see org.hive2hive.rcp.client.model.filetree.AccessRight#getUserId()
	 * @see #getAccessRight()
	 * @generated
	 */
	EAttribute getAccessRight_UserId();

	/**
	 * Returns the meta object for data type '{@link java.nio.file.Path <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Path</em>'.
	 * @see java.nio.file.Path
	 * @model instanceClass="java.nio.file.Path"
	 * @generated
	 */
	EDataType getPath();

	/**
	 * Returns the meta object for data type '{@link java.io.File <em>Java Io File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Java Io File</em>'.
	 * @see java.io.File
	 * @model instanceClass="java.io.File"
	 * @generated
	 */
	EDataType getJavaIoFile();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FileTreeFactory getFileTreeFactory();

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
		 * The meta object literal for the '{@link org.hive2hive.rcp.client.model.filetree.impl.TreeImpl <em>Tree</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hive2hive.rcp.client.model.filetree.impl.TreeImpl
		 * @see org.hive2hive.rcp.client.model.filetree.impl.FileTreePackageImpl#getTree()
		 * @generated
		 */
		EClass TREE = eINSTANCE.getTree();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE__ELEMENTS = eINSTANCE.getTree_Elements();

		/**
		 * The meta object literal for the '{@link org.hive2hive.rcp.client.model.filetree.impl.TreeElementImpl <em>Tree Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hive2hive.rcp.client.model.filetree.impl.TreeElementImpl
		 * @see org.hive2hive.rcp.client.model.filetree.impl.FileTreePackageImpl#getTreeElement()
		 * @generated
		 */
		EClass TREE_ELEMENT = eINSTANCE.getTreeElement();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE_ELEMENT__PATH = eINSTANCE.getTreeElement_Path();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE_ELEMENT__NAME = eINSTANCE.getTreeElement_Name();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE_ELEMENT__PARENT = eINSTANCE.getTreeElement_Parent();

		/**
		 * The meta object literal for the '<em><b>Access Rights</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE_ELEMENT__ACCESS_RIGHTS = eINSTANCE.getTreeElement_AccessRights();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE_ELEMENT__FILE = eINSTANCE.getTreeElement_File();

		/**
		 * The meta object literal for the '{@link org.hive2hive.rcp.client.model.filetree.impl.DirectoryImpl <em>Directory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hive2hive.rcp.client.model.filetree.impl.DirectoryImpl
		 * @see org.hive2hive.rcp.client.model.filetree.impl.FileTreePackageImpl#getDirectory()
		 * @generated
		 */
		EClass DIRECTORY = eINSTANCE.getDirectory();

		/**
		 * The meta object literal for the '{@link org.hive2hive.rcp.client.model.filetree.impl.FileImpl <em>File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hive2hive.rcp.client.model.filetree.impl.FileImpl
		 * @see org.hive2hive.rcp.client.model.filetree.impl.FileTreePackageImpl#getFile()
		 * @generated
		 */
		EClass FILE = eINSTANCE.getFile();

		/**
		 * The meta object literal for the '{@link org.hive2hive.rcp.client.model.filetree.impl.ContainerImpl <em>Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hive2hive.rcp.client.model.filetree.impl.ContainerImpl
		 * @see org.hive2hive.rcp.client.model.filetree.impl.FileTreePackageImpl#getContainer()
		 * @generated
		 */
		EClass CONTAINER = eINSTANCE.getContainer();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER__CHILDREN = eINSTANCE.getContainer_Children();

		/**
		 * The meta object literal for the '{@link org.hive2hive.rcp.client.model.filetree.impl.UserImpl <em>User</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hive2hive.rcp.client.model.filetree.impl.UserImpl
		 * @see org.hive2hive.rcp.client.model.filetree.impl.FileTreePackageImpl#getUser()
		 * @generated
		 */
		EClass USER = eINSTANCE.getUser();

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
		 * The meta object literal for the '<em><b>File Tree</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER__FILE_TREE = eINSTANCE.getUser_FileTree();

		/**
		 * The meta object literal for the '{@link org.hive2hive.rcp.client.model.filetree.impl.PathToTreeElementMapImpl <em>Path To Tree Element Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hive2hive.rcp.client.model.filetree.impl.PathToTreeElementMapImpl
		 * @see org.hive2hive.rcp.client.model.filetree.impl.FileTreePackageImpl#getPathToTreeElementMap()
		 * @generated
		 */
		EClass PATH_TO_TREE_ELEMENT_MAP = eINSTANCE.getPathToTreeElementMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATH_TO_TREE_ELEMENT_MAP__KEY = eINSTANCE.getPathToTreeElementMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_TO_TREE_ELEMENT_MAP__VALUE = eINSTANCE.getPathToTreeElementMap_Value();

		/**
		 * The meta object literal for the '{@link org.hive2hive.rcp.client.model.filetree.impl.AccessRightImpl <em>Access Right</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hive2hive.rcp.client.model.filetree.impl.AccessRightImpl
		 * @see org.hive2hive.rcp.client.model.filetree.impl.FileTreePackageImpl#getAccessRight()
		 * @generated
		 */
		EClass ACCESS_RIGHT = eINSTANCE.getAccessRight();

		/**
		 * The meta object literal for the '<em><b>Read Permission</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCESS_RIGHT__READ_PERMISSION = eINSTANCE.getAccessRight_ReadPermission();

		/**
		 * The meta object literal for the '<em><b>Write Permission</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCESS_RIGHT__WRITE_PERMISSION = eINSTANCE.getAccessRight_WritePermission();

		/**
		 * The meta object literal for the '<em><b>User Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCESS_RIGHT__USER_ID = eINSTANCE.getAccessRight_UserId();

		/**
		 * The meta object literal for the '<em>Path</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.nio.file.Path
		 * @see org.hive2hive.rcp.client.model.filetree.impl.FileTreePackageImpl#getPath()
		 * @generated
		 */
		EDataType PATH = eINSTANCE.getPath();

		/**
		 * The meta object literal for the '<em>Java Io File</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.io.File
		 * @see org.hive2hive.rcp.client.model.filetree.impl.FileTreePackageImpl#getJavaIoFile()
		 * @generated
		 */
		EDataType JAVA_IO_FILE = eINSTANCE.getJavaIoFile();

	}

} //FileTreePackage
