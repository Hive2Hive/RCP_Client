package org.hive2hive.rcp.client.parts.filedetails;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import net.miginfocom.swt.MigLayout;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.hive2hive.core.model.IFileVersion;
import org.hive2hive.rcp.client.bundleresourceloader.IBundleResourceLoader;
import org.hive2hive.rcp.client.model.filetree.AccessRight;
import org.hive2hive.rcp.client.model.filetree.FileTreeFactory;
import org.hive2hive.rcp.client.model.filetree.Tree;
import org.hive2hive.rcp.client.model.filetree.TreeElement;
import org.hive2hive.rcp.client.parts.filedetails.dialog.AddUserAccessRighsDialog;
import org.hive2hive.rcp.client.services.IFileService;
import org.hive2hive.rcp.client.services.IModelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileDetailPart {

	private static final Logger logger = LoggerFactory.getLogger(FileDetailPart.class);

	private TreeElement treeElement;

	private Label lblFileName;
	private Label lblPath;
	private Label lblFileSize;

	private TableViewer tblSharedWith;
	private TableViewer tblFileVersions;

	private Image accessGrantedImage;
	private Image accessDeniedImage;

	private Button btnAddUserAccessRights;

	@Inject
	private Shell shell;

	@Inject
	private IFileService fileService;

	@Inject
	private IEventBroker eventBroker;

	@Inject
	private IModelService modelService;

	@PostConstruct
	public void createControlls(Composite parent, IBundleResourceLoader resourceLoader) {

		accessGrantedImage = resourceLoader.loadImage(this.getClass(), "images/check/Check16x16.png");
		accessDeniedImage = resourceLoader.loadImage(this.getClass(), "images/cross/Cross16x16.png");

		MigLayout layout = new MigLayout("wrap", "[][]", "[][][]");
		parent.setLayout(layout);

		Label label = new Label(parent, SWT.NONE);
		label.setText("Name:");
		lblFileName = new Label(parent, SWT.NONE);
		lblFileName.setText("ExampleFile.txt");

		label = new Label(parent, SWT.NONE);
		label.setText("Path:");
		lblPath = new Label(parent, SWT.NONE);
		lblPath.setText("/abc/lll");

		label = new Label(parent, SWT.NONE);
		label.setText("Size:");
		lblFileSize = new Label(parent, SWT.NONE);
		lblFileSize.setText("63kb");

		createSharedWithTable(parent, resourceLoader);
		createFileVersionTable(parent);

		btnAddUserAccessRights = new Button(parent, SWT.PUSH);
		btnAddUserAccessRights.setText("Add User");
		btnAddUserAccessRights.setLayoutData("align right");
		btnAddUserAccessRights.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				addAccessRightsForFile();
			}
		});
	}

	@Inject
	private void handleSelectionChanged(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) TreeElement treeElement) {
		if (treeElement != null) {
			logger.debug("Selected element: {}", treeElement);
			this.treeElement = treeElement;
			updateViewElements();
			fileService.getFileVersions(treeElement.getFile(), eventBroker);
		}
	}

	private void updateViewElements() {
		lblFileName.setText(treeElement.getName());
		lblPath.setText(treeElement.getPath().toString());
		updateAccessRights();
	}

	private void updateAccessRights() {
		tblSharedWith.setInput(treeElement.getAccessRights());
	}

	private void createSharedWithTable(Composite parent, IBundleResourceLoader resourceLoader) {
		tblSharedWith = new TableViewer(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		Table table = tblSharedWith.getTable();
		table.setLayoutData("height 80::");
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		tblSharedWith.setContentProvider(ArrayContentProvider.getInstance());

		TableViewerColumn col = new TableViewerColumn(tblSharedWith, SWT.NONE);
		col.getColumn().setWidth(200);
		col.getColumn().setText("User-ID");
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((AccessRight) element).getUserId();
			}
		});

		col = new TableViewerColumn(tblSharedWith, SWT.CENTER);
		col.getColumn().setWidth(22);
		col.getColumn().setText("r");
		col.getColumn().setResizable(false);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public Image getImage(Object element) {
				return getImageForAccessRight(((AccessRight) element).isReadPermission());
			}

			@Override
			public String getText(Object element) {
				return null;
			}
		});

		col = new TableViewerColumn(tblSharedWith, SWT.CENTER);
		col.getColumn().setWidth(22);
		col.getColumn().setText("w");
		col.getColumn().setResizable(false);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public Image getImage(Object element) {
				return getImageForAccessRight(((AccessRight) element).isWritePermission());
			}

			@Override
			public String getText(Object element) {
				return null;
			}
		});
	}

	private void createFileVersionTable(Composite parent) {
		tblFileVersions = new TableViewer(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		Table table = tblFileVersions.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		// // TODO Nendor: create proper instances here
		// tblFileVersions.setContentProvider(new ShareContentProvider());
		// tblFileVersions.setLabelProvider(new ShareLabelProvider());
	}

	private Image getImageForAccessRight(boolean hasPermission) {
		if (hasPermission) {
			return accessGrantedImage;
		}
		return accessDeniedImage;
	}

	private void addAccessRightsForFile() {
		logger.debug("Giving new user access to the file {}.", lblFileName.getText());
		AddUserAccessRighsDialog dialog = new AddUserAccessRighsDialog(shell, treeElement);
		if (IDialogConstants.OK_ID == dialog.open()) {
			String userId = dialog.getUserId();
			boolean grantWriteAccess = dialog.isGrantWriteAccess();
			createAccessRights(userId, grantWriteAccess);
		}
	}

	private void createAccessRights(String userId, boolean grantWriteAccess) {
		AccessRight right = FileTreeFactory.eINSTANCE.createAccessRight();
		right.setUserId(userId);
		right.setReadPermission(true);
		right.setWritePermission(grantWriteAccess);
		fileService.shareWithUser(userId, treeElement.getFile(), right, eventBroker);
	}

	@Inject
	@Optional
	private void handleFileTreeChanged(@UIEventTopic(IFileService.FILE_SERVICE_STATUS) IFileService.Status status) {
		if (IFileService.Status.FILE_LIST_UPDATE == status && treeElement != null) {
			Tree fileTree = modelService.getUser().getFileTree();
			treeElement = fileTree.getElements().get(treeElement.getPath());
			updateViewElements();
		}
	}

	@Inject
	@Optional
	private void handleFileVersionFetch(@UIEventTopic(IFileService.FETCHED_FILE_VERSIONS) List<IFileVersion> fileVersions) {
		logger.debug("Received file versions:");
		for (IFileVersion fileVersion : fileVersions) {
			logger.debug("File version: index={}, date={}, size={}", fileVersion.getIndex(), fileVersion.getDate(),
					fileVersion.getSize());
		}
	}

}
