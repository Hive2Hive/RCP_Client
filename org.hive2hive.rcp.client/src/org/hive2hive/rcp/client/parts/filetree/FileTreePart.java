package org.hive2hive.rcp.client.parts.filetree;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import net.miginfocom.swt.MigLayout;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.hive2hive.core.processes.implementations.files.list.FileTaste;
import org.hive2hive.rcp.client.model.filetree.util.FileTreeModelUtile;
import org.hive2hive.rcp.client.services.IFileService;
import org.hive2hive.rcp.client.services.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileTreePart {
	private static final Logger logger = LoggerFactory.getLogger(FileTreePart.class);

	@Inject
	private IFileService fileService;

	@Inject
	private IEventBroker eventBroker;

	private TreeViewer treeViewer;
	private Tree tree;

	private Button btnUpdate;

	@PostConstruct
	public void createControlls(final Composite parent, IUserService userService) {
		MigLayout layout = new MigLayout("insets 1, wrap", "[left, grow]", "[][fill,grow]");
		parent.setLayout(layout);

		btnUpdate = new Button(parent, SWT.PUSH);
		btnUpdate.setText("Refresh");
		btnUpdate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				fileService.fetchUpdatedFileList(eventBroker);
			}
		});

		createTreeViewer(parent);
		tree.setLayoutData("growx, growy");
		treeViewer.setInput(FileTreeModelUtile.createDummyModel());
		treeViewer.expandAll();
	}

	void createTreeViewer(final Composite parent) {
		tree = new Tree(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		treeViewer = new TreeViewer(tree);
		treeViewer.setContentProvider(new FileTreeContentProvider());
		treeViewer.setLabelProvider(new FileTreeLabelProvider());

		TreeColumn col = new TreeColumn(tree, SWT.LEFT);
		col.setAlignment(SWT.LEFT);
		col.setText("Files");
		col.setWidth(100);

		col = new TreeColumn(tree, SWT.LEFT);
		col.setAlignment(SWT.LEFT);
		col.setText("Infos");
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
		logger.error("Implement a refresh of the file tree");
	}
}
