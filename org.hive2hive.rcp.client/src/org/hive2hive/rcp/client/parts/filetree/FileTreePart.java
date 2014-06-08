package org.hive2hive.rcp.client.parts.filetree;

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
import org.hive2hive.rcp.client.bundleresourceloader.IBundleResourceLoader;
import org.hive2hive.rcp.client.model.filetree.util.FileTreeModelUtile;
import org.hive2hive.rcp.client.services.IFileService;
import org.hive2hive.rcp.client.services.IModelService;
import org.hive2hive.rcp.client.services.IService;
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
	private void handleSuccessfulUserLogin(
			@UIEventTopic(IUserService.USER_STATUS) IService.StatusMessage<IUserService.Status> statusMessage) {
		if (IUserService.Status.LOGIN_SUCCESSFUL == statusMessage.getStatus()) {
			logger.debug("User '{}' logged in successfully - request current file tree.", statusMessage.getMessage());
			fileService.updateFileTreeOfUser(eventBroker);
		}
	}

	@Inject
	@Optional
	public void updateFileTree(@UIEventTopic(IFileService.FILE_SERVICE_STATUS) IFileService.Status status) {
		if (IFileService.Status.FILE_LIST_UPDATE == status) {
			logger.debug("File list was updated.");
			treeViewer.setInput(modelService.getUser().getFileTree());
			treeViewer.expandAll();
		}
	}

}
