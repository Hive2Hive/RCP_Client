package org.hive2hive.rcp.client.parts.filetree;

import java.nio.file.Path;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import net.miginfocom.swt.MigLayout;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.hive2hive.core.processes.implementations.files.list.FileTaste;
import org.hive2hive.rcp.client.bundleresourceloader.IBundleResourceLoader;
import org.hive2hive.rcp.client.model.filetree.Directory;
import org.hive2hive.rcp.client.model.filetree.FileTree;
import org.hive2hive.rcp.client.model.filetree.FileTreeElement;
import org.hive2hive.rcp.client.model.filetree.FileTreeFactory;
import org.hive2hive.rcp.client.model.filetree.User;
import org.hive2hive.rcp.client.model.filetree.util.FileTreeModelUtile;
import org.hive2hive.rcp.client.services.IFileService;
import org.hive2hive.rcp.client.services.IModelService;
import org.hive2hive.rcp.client.services.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileTreePart {
	private static final Logger logger = LoggerFactory.getLogger(FileTreePart.class);

	@Inject
	private IFileService fileService;

	@Inject
	private IEventBroker eventBroker;

	@Inject
	private ESelectionService selectionService;

	@Inject
	private IModelService modelService;

	private TreeViewer treeViewer;
	private Tree tree;

	private Button btnUpdate;

	@PostConstruct
	public void createControlls(final Composite parent, IUserService userService, IBundleResourceLoader resourceLoader) {
		MigLayout layout = new MigLayout("insets 1, wrap", "[left, grow]", "[][fill,grow]");
		parent.setLayout(layout);

		btnUpdate = new Button(parent, SWT.PUSH);
		btnUpdate.setText("Refresh");
		btnUpdate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				fileService.updateFileTreeOfUser(eventBroker);
			}
		});

		createTreeViewer(parent, resourceLoader);
		tree.setLayoutData("growx, growy");
		treeViewer.setInput(FileTreeModelUtile.createDummyModel());
		treeViewer.expandAll();
	}

	void createTreeViewer(final Composite parent, IBundleResourceLoader resourceLoader) {
		tree = new Tree(parent, SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		treeViewer = new TreeViewer(tree);
		treeViewer.setContentProvider(new FileTreeContentProvider());
		treeViewer.setLabelProvider(new FileTreeLabelProvider(resourceLoader.loadImage(this.getClass(),
				"images/folder/folder16x16.png")));

		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection) treeViewer.getSelection();
				selectionService.setSelection(selection.getFirstElement());
			}
		});

		TreeColumn col = new TreeColumn(tree, SWT.LEFT);
		col.setAlignment(SWT.LEFT);
		col.setText("Files");
		col.setWidth(100);

		col = new TreeColumn(tree, SWT.LEFT);
		col.setAlignment(SWT.LEFT);
		col.setText("Path");
		col.setWidth(100);
	}

	@Inject
	@Optional
	public void updateFileTree(@UIEventTopic(IFileService.FILE_LIST_UPDATE) List<FileTaste> fileList) {
		logger.debug("File list was updated.");
		logger.debug("Paths of the files in the current tree:");
		for (FileTaste fileTaste : fileList) {
			logger.debug(fileTaste.getPath().toString());
		}
		FileTree fileTree = createFileTree(fileList);
		treeViewer.setInput(fileTree);
		treeViewer.expandAll();

	}

	private FileTree createFileTree(List<FileTaste> fileList) {

		User user = modelService.getUser();

		FileTreeFactory factory = FileTreeFactory.eINSTANCE;
		FileTree tree = factory.createFileTree();
		tree.setName(String.format("file root of '%s'", user.getUserId()));
		tree.setPath(user.getRootDir());

		Directory rootDir = factory.createDirectory();
		rootDir.setName(user.getRootDir().toString());
		rootDir.setPath(user.getRootDir());
		tree.getElements().put(rootDir.getPath(), rootDir);
		logger.debug("Hash of root dir path = {}", rootDir.getPath().hashCode());
		tree.getChildren().add(rootDir);

		for (FileTaste fileTaste : fileList) {
			FileTreeElement element;
			if (fileTaste.getFile().isDirectory()) {
				element = FileTreeFactory.eINSTANCE.createDirectory();
			} else {
				element = FileTreeFactory.eINSTANCE.createFile();
			}
			addFileTreeElement(tree, element, fileTaste);
		}
		return tree;
	}

	private void addFileTreeElement(FileTree tree, FileTreeElement element, FileTaste fileTaste) {
		element.setName(fileTaste.getName());
		element.setPath(fileTaste.getFile().toPath());
		tree.getElements().put(element.getPath(), element);
		Path parentPath = element.getPath().getParent();
		fileTaste.getPath().isAbsolute();
		logger.debug("Hash of parent path = {}", parentPath.hashCode());
		Directory parent = (Directory) tree.getElements().get(parentPath);
		parent.getChildren().add(element);
	}

}
