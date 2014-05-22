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
	 * The meta object id for the '{@link org.hive2hive.rcp.client.model.filetree.impl.FileTreeElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hive2hive.rcp.client.model.filetree.impl.FileTreeElementImpl
	 * @see org.hive2hive.rcp.client.model.filetree.impl.FileTreePackageImpl#getFileTreeElement()
	 * @generated
	 */
	int FILE_TREE_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TREE_ELEMENT__PATH = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TREE_ELEMENT__NAME = 1;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TREE_ELEMENT__PARENT = 2;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TREE_ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TREE_ELEMENT_OPERATION_COUNT = 0;

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
	int CONTAINER__PATH = FILE_TREE_ELEMENT__PATH;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__NAME = FILE_TREE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__PARENT = FILE_TREE_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__CHILDREN = FILE_TREE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_FEATURE_COUNT = FILE_TREE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_OPERATION_COUNT = FILE_TREE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.hive2hive.rcp.client.model.filetree.impl.FileTreeImpl <em>File Tree</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hive2hive.rcp.client.model.filetree.impl.FileTreeImpl
	 * @see org.hive2hive.rcp.client.model.filetree.impl.FileTreePackageImpl#getFileTree()
	 * @generated
	 */
	int FILE_TREE = 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TREE__PATH = CONTAINER__PATH;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TREE__NAME = CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TREE__PARENT = CONTAINER__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TREE__CHILDREN = CONTAINER__CHILDREN;

	/**
	 * The number of structural features of the '<em>File Tree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TREE_FEATURE_COUNT = CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>File Tree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_TREE_OPERATION_COUNT = CONTAINER_OPERATION_COUNT + 0;

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
	 * The number of operations of the '<em>Directory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_OPERATION_COUNT = CONTAINER_OPERATION_COUNT + 0;

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
	int FILE__PATH = FILE_TREE_ELEMENT__PATH;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__NAME = FILE_TREE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__PARENT = FILE_TREE_ELEMENT__PARENT;

	/**
	 * The number of structural features of the '<em>File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_FEATURE_COUNT = FILE_TREE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_OPERATION_COUNT = FILE_TREE_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '<em>Path</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.nio.file.Path
	 * @see org.hive2hive.rcp.client.model.filetree.impl.FileTreePackageImpl#getPath()
	 * @generated
	 */
	int PATH = 5;


	/**
	 * Returns the meta object for class '{@link org.hive2hive.rcp.client.model.filetree.FileTree <em>File Tree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Tree</em>'.
	 * @see org.hive2hive.rcp.client.model.filetree.FileTree
	 * @generated
	 */
	EClass getFileTree();

	/**
	 * Returns the meta object for class '{@link org.hive2hive.rcp.client.model.filetree.FileTreeElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.hive2hive.rcp.client.model.filetree.FileTreeElement
	 * @generated
	 */
	EClass getFileTreeElement();

	/**
	 * Returns the meta object for the attribute '{@link org.hive2hive.rcp.client.model.filetree.FileTreeElement#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.hive2hive.rcp.client.model.filetree.FileTreeElement#getPath()
	 * @see #getFileTreeElement()
	 * @generated
	 */
	EAttribute getFileTreeElement_Path();

	/**
	 * Returns the meta object for the attribute '{@link org.hive2hive.rcp.client.model.filetree.FileTreeElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.hive2hive.rcp.client.model.filetree.FileTreeElement#getName()
	 * @see #getFileTreeElement()
	 * @generated
	 */
	EAttribute getFileTreeElement_Name();

	/**
	 * Returns the meta object for the container reference '{@link org.hive2hive.rcp.client.model.filetree.FileTreeElement#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see org.hive2hive.rcp.client.model.filetree.FileTreeElement#getParent()
	 * @see #getFileTreeElement()
	 * @generated
	 */
	EReference getFileTreeElement_Parent();

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
		 * The meta object literal for the '{@link org.hive2hive.rcp.client.model.filetree.impl.FileTreeImpl <em>File Tree</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hive2hive.rcp.client.model.filetree.impl.FileTreeImpl
		 * @see org.hive2hive.rcp.client.model.filetree.impl.FileTreePackageImpl#getFileTree()
		 * @generated
		 */
		EClass FILE_TREE = eINSTANCE.getFileTree();

		/**
		 * The meta object literal for the '{@link org.hive2hive.rcp.client.model.filetree.impl.FileTreeElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hive2hive.rcp.client.model.filetree.impl.FileTreeElementImpl
		 * @see org.hive2hive.rcp.client.model.filetree.impl.FileTreePackageImpl#getFileTreeElement()
		 * @generated
		 */
		EClass FILE_TREE_ELEMENT = eINSTANCE.getFileTreeElement();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_TREE_ELEMENT__PATH = eINSTANCE.getFileTreeElement_Path();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_TREE_ELEMENT__NAME = eINSTANCE.getFileTreeElement_Name();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILE_TREE_ELEMENT__PARENT = eINSTANCE.getFileTreeElement_Parent();

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
		 * The meta object literal for the '<em>Path</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.nio.file.Path
		 * @see org.hive2hive.rcp.client.model.filetree.impl.FileTreePackageImpl#getPath()
		 * @generated
		 */
		EDataType PATH = eINSTANCE.getPath();

	}

} //FileTreePackage
